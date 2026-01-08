# UML Overview

## UML Patterns Referenced

1. `uml-package.md` - Package and class naming patterns
2. `uml-class-{Type}Impl.md` - Wrapper implementation patterns
3. `uml-class-{Language}Validator.md` - Validator check methods and constants
4. `uml-class-{Language}QuickfixProvider.md` - Quick fix methods and @Fix annotations
5. `uml-class-{Language}ProposalProvider.md` - Content assist complete methods
6. `uml-communication.md` - Collaboration patterns
7. `uml-interaction.md` - Logging and exception handling

## Technology Preferences Referenced

1. `sheep-dog-main/arch-logging.md` - Logging patterns (SLF4J)
2. `sheep-dog-main/arch-xtext.md` - General Xtext framework architecture
3. `sheep-dog-main/impl-log4j.md` - Log4J configuration
4. `sheep-dog-main/impl-xtext.md` - Xtext domain terminology and pattern variables

## Sub-Projects

List of sub-project directories where these patterns apply:

1. **sheepdogxtextplugin** - Contains core packages: grammar, impl, validation, formatting, generator, parser
2. **sheepdogxtextplugin.ui** - Contains UI packages: contentassist, quickfix, syntaxcoloring

## Pattern Variables

See `sheep-dog-main/impl-xtext.md` Domain Terminology section for pattern variable definitions.
