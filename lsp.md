# VSCode Extension Creation Plan for Sheep Dog Xtext Project

Based on research of the existing `sheepdogxtextplugin.parent` project and Xtext VSCode integration approaches, here are the high-level steps:

## Approach: Add New Module (Recommended)

**You should add a new module rather than duplicating the project.** Your existing Xtext project already has the necessary IDE module (`sheepdogxtextplugin.ide`) which contains the Language Server Protocol (LSP) foundation.

## High-Level Steps

### 1. Convert IDE Module to Language Server
- Modify the existing `sheepdogxtextplugin.ide` module to support LSP
- Add Gradle build configuration for standalone server execution
- Create a language server launcher class

### 2. Create VSCode Extension Module
- Add new `sheepdogxtextplugin.vscode` module to the parent project
- Create Node.js-based VSCode extension structure
- Configure TypeScript files for extension and client code

### 3. Integration Options
**Option A (Embedded)**: Package language server within VSCode extension
**Option B (External)**: Run language server as separate process

### 4. Required Dependencies
- Update Xtext version to 2.25+ for better LSP support
- Add `org.eclipse.lsp4j` dependencies
- Include VSCode extension dependencies (Node.js, TypeScript)

### 5. Build Configuration
- Extend parent `pom.xml` with new VSCode module
- Add Gradle build file for language server packaging
- Configure Maven/Gradle coordination for builds

## IDE Requirements
**You can develop entirely in VSCode** - Eclipse IDE is not required for VSCode extension development, though it may be helpful for debugging the language server portion.

## Project Structure Impact
- Reuse existing modules: `sheepdogxtextplugin`, `sheepdogxtextplugin.ide` 
- Add new modules: `sheepdogxtextplugin.vscode`, `sheepdogxtextplugin.language-server`
- No duplication needed - leverage existing Xtext infrastructure

The plan maintains your existing Eclipse plugin while adding VSCode capability through new modules.

## Current Project Analysis

### Existing Structure
Your `sheepdogxtextplugin.parent` project contains:
- `sheepdogxtextplugin` - Core language implementation with SheepDog.xtext grammar
- `sheepdogxtextplugin.ide` - IDE-agnostic language services (perfect LSP foundation)
- `sheepdogxtextplugin.ui` - Eclipse-specific UI components
- `sheepdogxtextplugin.tests` - Language tests
- `sheepdogxtextplugin.feature` - Eclipse feature definition
- `sheepdogxtextplugin.repository` - P2 repository for Eclipse updates

### Key Technical Details
- **Xtext Version**: 2.39.0.M1 (recent, good LSP support)
- **Java Version**: 21 (compatible with modern tooling)
- **Build System**: Maven with Tycho (Eclipse-focused)
- **Language**: SheepDog DSL for test specifications

### SheepDog Language Features
Based on `SheepDog.xtext`, your language includes:
- StepObject and TestSuite top-level constructs
- StepDefinition with parameters
- TestCase and TestSetup structures
- Given/When/Then/And test steps
- Tables and text blocks
- Rich statement structure

## Detailed Implementation Steps

### Phase 1: Language Server Setup
1. **Enhance IDE Module**
   - Add LSP4J dependencies to `sheepdogxtextplugin.ide/pom.xml`
   - Create `ServerLauncher.java` class
   - Configure socket/stdio communication options

2. **Add Gradle Build**
   - Create `build.gradle` in IDE module for standalone execution
   - Configure application plugin for server launcher
   - Set up distribution packaging

### Phase 2: VSCode Extension Creation
1. **Initialize Extension**
   ```bash
   npm install -g yo generator-code
   yo code  # Choose "New Language Support"
   ```

2. **Extension Structure**
   ```
   sheepdogxtextplugin.vscode/
   ├── package.json          # Extension manifest
   ├── src/
   │   └── extension.ts      # Main extension code
   ├── syntaxes/
   │   └── sheepdog.tmGrammar.json  # Syntax highlighting
   └── server/               # Language server binaries
   ```

3. **Language Client Configuration**
   - Install `vscode-languageclient` dependency
   - Configure server startup options
   - Handle embedded vs external server modes

### Phase 3: Integration & Testing
1. **Build Integration**
   - Update parent `pom.xml` to include VSCode module
   - Create cross-platform server packaging
   - Set up VSIX generation pipeline

2. **Testing Strategy**
   - Unit tests for language server features
   - Integration tests with VSCode extension host
   - End-to-end testing with sample SheepDog files

### Phase 4: Distribution
1. **Packaging**
   - Generate VSIX extension package
   - Include platform-specific server binaries
   - Create marketplace-ready assets

2. **Publishing Options**
   - VS Code Marketplace (public)
   - Private/enterprise distribution
   - GitHub Releases

## Reference Resources
- [TypeFox Blog: Building VS Code Extension with Xtext](https://www.typefox.io/blog/building-a-vs-code-extension-with-xtext-and-the-language-server-protocol/)
- [Xtext Language Server Example](https://github.com/cdietrich/xtext-languageserver-example)
- [VS Code Extension API: Language Server Guide](https://code.visualstudio.com/api/language-extensions/language-server-extension-guide)

## Benefits of This Approach
- **Code Reuse**: Leverages existing Xtext language definition
- **Dual Target**: Maintains Eclipse support while adding VSCode
- **LSP Standard**: Uses industry-standard Language Server Protocol
- **Modularity**: Clean separation between server and client concerns
- **Flexibility**: Supports both embedded and standalone server deployment