"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.activate = activate;
exports.deactivate = deactivate;
const vscode = __importStar(require("vscode"));
const path = __importStar(require("path"));
const node_1 = require("vscode-languageclient/node");
let client;
function activate(context) {
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
    const serverOptions = {
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
    const clientOptions = {
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
    client = new node_1.LanguageClient('mydslLanguageServer', 'MyDsl Language Server', serverOptions, clientOptions);
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
function deactivate() {
    if (!client) {
        return undefined;
    }
    console.log('Deactivating MyDsl extension...');
    return client.stop();
}
function getJavaExecutable() {
    // Check for JAVA_HOME environment variable
    const javaHome = process.env.JAVA_HOME;
    if (javaHome) {
        return path.join(javaHome, 'bin', process.platform === 'win32' ? 'java.exe' : 'java');
    }
    // Fallback to java in PATH
    return process.platform === 'win32' ? 'java.exe' : 'java';
}
//# sourceMappingURL=extension.js.map