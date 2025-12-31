# UML Overview

## UML Patterns Referenced

1. `uml-package.md`
2. `uml-class.md`
3. `uml-communication.md`
4. `uml-interaction.md`

## Technology Preferences Referenced

1. `tech-logging.md` - General logging rules
2. `tech-log4j.md` - **Log4j** specific rules

## Pattern Variables

The Sheep Dog language is defined in the `src\org\farhan\dsl\sheepdog\SheepDog.xtext` file which is in the `sheep-dog-main\sheep-dog-local\sheepdogxtextplugin.parent\sheepdogxtextplugin` project.

The patterns refer to these variables:
1. **Language** - The name of the `.xtext` file, **SheepDog** in this case.
2. **Feature** - Non-terminal grammar features in `.xtext`, `StepObject` or `StepDefinition` in this case.
3. **Attribute** - Named assignments in **Feature**, `statementList` or `stepDefinitionList` in this case.
4. **Aspect** - Not in `.xtext` file, derived from test specification.
5. **Issue** - One of **ONLY**, **FILE**, **WORKSPACE**