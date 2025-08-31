# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with the sheep-dog-local repository.

> **📚 Complete Documentation**: See the comprehensive guidance files:
> - `../sheep-dog-main/CLAUDE.md` - Cross-repository coordination
> - `CLAUDE.architecture.md` - System architecture & design patterns
> - `CLAUDE.development.md` - Development workflows & practices  
> - `CLAUDE.testing.md` - BDD/testing methodologies

## Agent Delegation Rules

**CRITICAL**: For any Xtext-related work, ALWAYS delegate to the general-purpose agent with Xtext expertise. DO NOT attempt these tasks directly.

### Xtext Work That Requires Agent Delegation
- **Xtext Grammar Development**: Modifying .xtext files, grammar rules, language syntax
- **Language Server Development**: LSP integration, server launchers, protocol implementation
- **Eclipse Plugin Development**: Tycho builds, plugin.xml, MANIFEST.MF, Eclipse-specific code
- **VSCode Extension Work**: ANY modification to VSCode extension files including:
  - Language client development (extension.ts)
  - Extension configuration (package.json for language extensions)  
  - Language configuration files (*.configuration.json)
  - TextMate grammars (*.tmLanguage.json)
  - Extension file structure analysis or comparison
  - File renaming within VSCode extension projects
- **Xtext Code Generation**: MWE2 workflows, code generators, template modifications
- **IDE Integration**: Content assist, validation, quick fixes, syntax highlighting
- **Build System Integration**: Gradle/Maven coordination for Xtext projects
- **Project Structure Analysis**: Comparing Xtext/VSCode projects, analyzing differences

### When to Use Agent Delegation - EXPANDED
```
ALWAYS delegate when:
- ANY mention of "Xtext", "language server", "LSP"
- "Eclipse plugin" development work
- "VSCode extension" creation, modification, or analysis
- Grammar modifications or language development
- Working with files: .xtext, .mwe2, package.json (for extensions), *.configuration.json
- Comparing language/extension projects
- Renaming files within Xtext/VSCode extension contexts
- Analyzing extension structures or configurations
- ANY task within org.xtext.example.mydsl.* directories
- ANY task within *vscode* extension directories
```

### What NOT to Delegate
- Simple file operations unrelated to Xtext (basic read/write/copy)
- General Maven/Gradle builds not involving Xtext
- Documentation updates to CLAUDE.md files
- Git operations (add, commit, push)

Use: `Task tool with subagent_type: "general-purpose"` and clearly specify Xtext expertise needed in the prompt.

## Repository Overview

**sheep-dog-local** is the **complete local development environment** with Eclipse IDE integration for the sheep-dog ecosystem.

### Key Components
- **sheep-dog-dev**: Core transformation library (bidirectional converters)
- **sheepdogxtextplugin.parent**: Eclipse plugin for DSL editing with IDE features
- **sheepdogcucumber.parent**: Xtext plugin for Cucumber language API  
- **sheep-dog-test**: Semantic validation rules and language constraints

### Maven Plugin Used
- **Plugin**: `sheep-dog-dev-maven-plugin:1.28-SNAPSHOT`
- **Key Requirement**: Always use `-DrepoDir` parameter for cross-repository transformations

## Development Commands

### Building This Repository
```bash
mvn clean install
```

### Forward Engineering (Generate Code from Specs)
```bash
# In sheep-dog-test project
scripts/forward-engineer.bat

# Or manually:
mvn clean  
mvn org.farhan:sheep-dog-dev-maven-plugin:uml-to-cucumber-guice \
  -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/ \
  -Dtags="sheep-dog-test"
```

### Cross-Repository Transformations
```bash
# Generate different types of test code
mvn org.farhan:sheep-dog-dev-maven-plugin:uml-to-cucumber \
  -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/ -Dtags="<tag>"

mvn org.farhan:sheep-dog-dev-maven-plugin:uml-to-cucumber-spring \
  -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/ -Dtags="<tag>"

mvn org.farhan:sheep-dog-dev-maven-plugin:uml-to-junit-guice \
  -DrepoDir=../../sheep-dog-qa/sheep-dog-specs/ -Dtags="<tag>"
```

## Eclipse IDE Development

### Setup Process
1. **Import Projects**: Import all projects from this repository into Eclipse workspace
2. **Build**: Run **Run As > Maven install** on each project  
3. **Launch Plugin**: Right-click `sheepdogxtextplugin` → **Run As > Eclipse Application**
4. **Install Plugin**: Install from `sheepdogxtextplugin.repository/target/` archive
5. **Edit Specs**: Work with specifications using full IDE support

### Eclipse IDE Features
- **Content Assist**: Context-aware suggestions for applications, objects, keywords
- **Validation**: Real-time error checking with component/object/predicate validation
- **Quick Fixes**: Create missing objects, rename to existing ones, generate step definitions
- **Syntax Highlighting**: Custom language coloring and formatting
- **Code Generation**: Generate step definitions, page objects, test runners

### Plugin Development Workflow
1. Modify Xtext grammar or validation rules
2. Regenerate language infrastructure
3. Test in separate Eclipse instance
4. Build plugin archive for distribution

## Generated Code Structure

### Output Locations
```
src-gen/test/
├── java/org/farhan/
│   ├── objects/              # Page object implementations
│   └── stepdefs/             # Step definition implementations  
└── resources/cucumber/specs/ # Generated Cucumber feature files
```

### Code Generation Goals Available
- `uml-to-cucumber`: Plain Cucumber (no DI)
- `uml-to-cucumber-spring`: Cucumber with Spring DI
- `uml-to-cucumber-guice`: Cucumber with Guice DI  
- `uml-to-junit-spring`: JUnit with Spring DI
- `uml-to-junit-guice`: JUnit with Guice DI

## Working with Specifications

### Specification Source
- **Always Edit In**: `../sheep-dog-qa/sheep-dog-specs/src/test/resources/asciidoc/specs/`
- **Never Edit**: Generated code in `src-gen/` directories (use reverse engineering instead)

### Common Tags for This Repository
- `sheep-dog-test`: Test automation specifications (primary tag for this repo)
- `sheep-dog-dev`: Development-focused specifications
- `round-trip`: Round-trip engineering examples

### Reverse Engineering
```bash
# Update specs from generated code changes
cd ../sheep-dog-qa/sheep-dog-specs
scripts/reverse-engineer.bat <tag_name>
```

## Repository-Specific Notes

### Dependencies
- **Build Order**: This repo should be built after `sheep-dog-ops` and `sheep-dog-qa`
- **Specifications**: Depends on specs from `sheep-dog-qa` repository
- **Plugin Repository**: Uses GitHub Packages for Maven plugins

### Testing
- **Generated Tests**: Located in `src-gen/test/` directories
- **Test Execution**: Use `mvn test` to run generated test suites
- **IDE Testing**: Test Xtext plugin functionality in separate Eclipse instance

### Plugin Development
- **Xtext Projects**: Use Eclipse Tycho for building
- **Release Process**: Uses custom `sheep-dog-mgmt-maven-plugin` for releases
- **Plugin Archive**: Generated in `sheepdogxtextplugin.repository/target/`

## Integration with Other Repositories

### Upstream Dependencies
- **sheep-dog-qa**: Source of all specifications and UML models
- **sheep-dog-ops**: Provides management plugins for releases

### Downstream Usage  
- **sheep-dog-cloud**: May reference generated artifacts from this repository
- **Testing**: Generated tests validate the transformation pipeline

### Cross-Repository Coordination
- Always use `-DrepoDir=../../sheep-dog-qa/sheep-dog-specs/` when generating from external specs
- Coordinate tag usage with other repositories for consistent transformations
- Generated artifacts in `src-gen/` should not be manually edited