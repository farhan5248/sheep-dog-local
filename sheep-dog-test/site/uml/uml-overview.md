# UML Overview

## UML Patterns Referenced

1. `uml-package.md`
2. `uml-class-*.md` - Class/interface patterns (one file per class)
   - `uml-class-I{Type}.md`
   - `uml-class-{Type}Utility.md`
   - `uml-class-{Language}Builder.md`
   - `uml-class-{Type}IssueDetector.md`
   - `uml-class-{Type}IssueTypes.md`
   - `uml-class-{Type}IssueResolver.md`
   - `uml-class-{Language}IssueProposal.md`
3. `uml-communication.md`
4. `uml-activity.md`
5. `uml-interaction.md`

## Technology Preferences Referenced

1. `sheep-dog-main/site/impl/impl-slf4j.md` - **SLF4j** specific rules
2. `sheep-dog-main/site/arch/arch-logging.md` - General logging patterns
3. `sheep-dog-main/site/impl/impl-xtext.md` - Xtext domain terminology and pattern variables

## Pattern Variables

Pattern variables used in UML files to represent families of classes following similar patterns.

1. **{Language}** - The name of the Xtext grammar/language implementation
   - Values: `(SheepDog)`
   - Used in: {Language}Builder, {Language}Factory, I{Language}Factory, {Language}IssueProposal

2. **{Type}** - Grammar types (non-terminal rules) defined in the .xtext file
   - Values: `(And|Cell|Given|Model|Row|Statement|StatementList|StepDefinition|StepObject|StepParameters|Table|TestCase|TestData|TestProject|TestSetup|TestStep|TestStepContainer|TestSuite|Text|Then|When)`
   - Used in: I{Type}, create{Type}(), get{Type}(), {Type}Utility, {Type}IssueTypes, {Type}IssueDetector, {Type}IssueResolver

3. **{Assignment}** - Named assignments within grammar rules
   - Values: `(name|[a-z][a-zA-Z0-9]*List)`
   - Used in: validate{Assignment}Only(), validate{Assignment}File(), validate{Assignment}Workspace(), get{Assignment}(), set{Assignment}()

4. **{Issue}** - Issue scope levels from {Type}IssueTypes enum
   - Values: `(Only|File|Workspace)`
   - Used in: validate{Assignment}{Issue}()

See `sheep-dog-main/site/impl/impl-xtext.md` Domain Terminology section for additional context.