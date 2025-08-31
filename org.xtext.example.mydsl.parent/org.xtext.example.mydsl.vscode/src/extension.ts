import * as vscode from 'vscode';
import * as path from 'path';
import { LanguageClient, LanguageClientOptions, ServerOptions } from 'vscode-languageclient/node';

let client: LanguageClient;

export function activate(context: vscode.ExtensionContext) {
    console.log('MyDsl extension is being activated');

    // Configuration
    const config = vscode.workspace.getConfiguration('mydsl');
    const enabled = config.get('languageServer.enabled', true);
    
    if (!enabled) {
        console.log('MyDsl language server is disabled');
        return;
    }

    // Language Server executable
    const serverJarPath = path.join(context.extensionPath, 'server', 'mydsl-language-server-1.0.0-SNAPSHOT-standalone.jar');
    
    // Check if Java is available
    const javaExecutable = getJavaExecutable();
    if (!javaExecutable) {
        vscode.window.showErrorMessage('Java runtime is required for MyDsl language server. Please install Java 11 or higher.');
        return;
    }

    // Server options - embedded JAR approach
    const serverOptions: ServerOptions = {
        run: {
            command: javaExecutable,
            args: ['-jar', serverJarPath],
            options: {}
        },
        debug: {
            command: javaExecutable,
            args: ['-jar', serverJarPath],
            options: {}
        }
    };

    // Options to control the language client
    const clientOptions: LanguageClientOptions = {
        // Register the server for MyDsl documents
        documentSelector: [
            { scheme: 'file', language: 'mydsl' }
        ],
        synchronize: {
            // Notify the server about file changes to '.mydsl' files contained in the workspace
            fileEvents: vscode.workspace.createFileSystemWatcher('**/*.mydsl')
        },
        outputChannel: vscode.window.createOutputChannel('MyDsl Language Server'),
        traceOutputChannel: vscode.window.createOutputChannel('MyDsl Language Server Trace')
    };

    // Create the language client
    client = new LanguageClient(
        'mydslLanguageServer',
        'MyDsl Language Server',
        serverOptions,
        clientOptions
    );

    // Start the client. This will also launch the server
    console.log('Starting MyDsl language server...');
    client.start().then(() => {
        console.log('MyDsl language server started successfully');
        
        // Show status in status bar
        const statusBarItem = vscode.window.createStatusBarItem(vscode.StatusBarAlignment.Right, 100);
        statusBarItem.text = '$(check) MyDsl';
        statusBarItem.tooltip = 'MyDsl Language Server is running';
        statusBarItem.show();
        context.subscriptions.push(statusBarItem);
        
    }).catch(error => {
        console.error('Failed to start MyDsl language server:', error);
        vscode.window.showErrorMessage(`Failed to start MyDsl language server: ${error.message}`);
    });

    context.subscriptions.push(client);

    // Register commands
    const helloCommand = vscode.commands.registerCommand('mydsl.helloWorld', () => {
        vscode.window.showInformationMessage('Hello from MyDsl Extension!');
    });
    context.subscriptions.push(helloCommand);

    console.log('MyDsl extension activated');
}

export function deactivate(): Thenable<void> | undefined {
    if (!client) {
        return undefined;
    }
    console.log('Deactivating MyDsl extension...');
    return client.stop();
}

function getJavaExecutable(): string | null {
    // Check for JAVA_HOME environment variable
    const javaHome = process.env.JAVA_HOME;
    if (javaHome) {
        return path.join(javaHome, 'bin', process.platform === 'win32' ? 'java.exe' : 'java');
    }

    // Fallback to java in PATH
    return process.platform === 'win32' ? 'java.exe' : 'java';
}
