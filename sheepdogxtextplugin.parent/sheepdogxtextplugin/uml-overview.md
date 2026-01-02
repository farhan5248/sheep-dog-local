# UML Overview

## UML Patterns Referenced

1. `uml-package.md` - Package and class naming patterns
2. `uml-class.md` - IDE integration patterns (Validator, QuickfixProvider, ProposalProvider)
3. `uml-communication.md` - Collaboration patterns
4. `uml-interaction.md` - Logging and exception handling

## Technology Preferences Referenced

1. `../../../../arch-logging.md` - Logging patterns (SLF4J)
2. `../../../../arch-xtext.md` - General Xtext framework architecture
3. `../../../../tech-log4j.md` - Log4J configuration

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

## Mapping: {Issue} → {CheckType}

| Issue Level | CheckType | When It Runs | Example |
|-------------|-----------|--------------|---------|
| ONLY | FAST | Every keystroke | Cell name starts with uppercase |
| FILE | NORMAL | File save | First step has component |
| WORKSPACE | EXPENSIVE | On-demand/build | Step references existing definition |
