# UML Overview

## UML Patterns Referenced

1. `uml-package.md`
2. `uml-class-*.md` - Class/interface patterns (one file per class)
   - `uml-class-IFeature.md`
   - `uml-class-FeatureUtility.md`
   - `uml-class-LanguageBuilder.md`
   - `uml-class-FeatureIssueDetector.md`
   - `uml-class-FeatureIssueTypes.md`
   - `uml-class-FeatureIssueResolver.md`
   - `uml-class-LanguageIssueProposal.md`
3. `uml-communication.md`
4. `uml-interaction.md`

## Technology Preferences Referenced

1. `sheep-dog-main/impl-slf4j.md` - **SLF4j** specific rules

## Pattern Variables

The Sheep Dog language is defined in the `src\org\farhan\dsl\sheepdog\SheepDog.xtext` file which is in the `sheep-dog-main\sheep-dog-local\sheepdogxtextplugin.parent\sheepdogxtextplugin` project.

The patterns refer to these variables (shown with curly braces `{Variable}` when used as placeholders in pattern descriptions):

1. **{Language}** - The name of the `.xtext` file, **SheepDog** in this case.
2. **{Feature}** - Non-terminal grammar rules in `.xtext` (e.g., `StepObject`, `StepDefinition`, `Model`, `Given`, `Cell`). Infrastructure classes like {Language}Builder, {Language}Factory, I{Language}Factory, and IResourceRepository are NOT Features.
3. **{Attribute}** - Named assignments in {Feature}, `statementList` or `stepDefinitionList` in this case.
4. **{Aspect}** - Not in `.xtext` file, derived from test specification.
5. **{Issue}** - One of **ONLY**, **FILE**, **WORKSPACE**