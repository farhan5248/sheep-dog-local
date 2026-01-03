# UML Overview

## UML Patterns Referenced

1. `uml-package.md` - Package and class naming patterns
2. `uml-class-FeatureImpl.md` - Wrapper implementation patterns
3. `uml-class-LanguageValidator.md` - Validator check methods and constants
4. `uml-class-LanguageQuickfixProvider.md` - Quick fix methods and @Fix annotations
5. `uml-class-LanguageProposalProvider.md` - Content assist complete methods
6. `uml-communication.md` - Collaboration patterns
7. `uml-interaction.md` - Logging and exception handling

## Technology Preferences Referenced

1. `../../../../arch-logging.md` - Logging patterns (SLF4J)
2. `../../../../arch-xtext.md` - General Xtext framework architecture
3. `../../../../impl-log4j.md` - Log4J configuration

## Sub-Projects

List of sub-project directories where these patterns apply:

1. **sheepdogxtextplugin** - Contains core packages: grammar, impl, validation, formatting, generator, parser
2. **sheepdogxtextplugin.ui** - Contains UI packages: contentassist, quickfix, syntaxcoloring

## Pattern Variables

The Sheep Dog language IDE integration is based on the grammar defined in `SheepDog.xtext`.

IDE integration patterns refer to these variables:

1. **{Language}** - The name of the .xtext file, **SheepDog** in this case
   - Example: SheepDogValidator, SheepDogQuickfixProvider, SheepDogProposalProvider

2. **{Feature}** - Non-terminal grammar rules from SheepDog.xtext
   - Examples: TestStep, Cell, Row, TestStepContainer, StepObject, etc.
   - Used in: check{Feature}(), fix{Feature}(), complete{Feature}_Attribute()

3. **{Attribute}** - Named assignments within a {Feature} in the grammar
   - Examples: name, cellList, stepDefinitionList
   - Used in: completeFeature_{Attribute}() methods

4. **{Aspect}** - Validation aspects not directly in grammar
   - Examples: Name, Reference, CellList
   - Used in: validate{Aspect}(), correct{Aspect}(), suggest{Aspect}()

5. **{Issue}** - Issue scope levels from FeatureIssueTypes
   - **ONLY**: Element-level validation (capitalization, regex, format)
   - **FILE**: File-level validation (first element requirements, file structure)
   - **WORKSPACE**: Cross-file validation (references to other files, workspace-wide rules)

6. **{CheckType}** - Xtext validation timing/performance levels
   - **FAST**: Runs on every keystroke (CheckType.FAST)
     - Use for: Element validation (ONLY issues)
     - Example: Cell name capitalization
   - **NORMAL**: Runs on file save (CheckType.NORMAL)
     - Use for: File validation (FILE issues)
     - Example: First step must have component
   - **EXPENSIVE**: Runs on demand/build (CheckType.EXPENSIVE)
     - Use for: Workspace validation (WORKSPACE issues)
     - Example: TestStep references existing StepObject

