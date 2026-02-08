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

**Case Sensitivity**: Pattern variable names are case-sensitive and automatically convert values:
- **PascalCase** variable (e.g., `{Assignment}`) → PascalCase values (as stored)
- **lowercase** variable (e.g., `{assignment}`) → camelCase values (auto-converted)
- **UPPERCASE** variable (e.g., `{ASSIGNMENT}`) → UPPER_SNAKE_CASE values (auto-converted)

1. **{Language}** - The name of the Xtext grammar/language implementation
   - Values: `(SheepDog)`
   - Used in: {Language}Builder, {Language}Factory, I{Language}Factory, {Language}IssueProposal

2. **{Type}** - Grammar types (non-terminal rules) defined in the .xtext file
   - Values: `(And|Cell|Given|Model|Row|Statement|StatementList|StepDefinition|StepDefinitionRef|StepObject|StepObjectRef|StepParameters|Table|TestCase|TestData|TestProject|TestSetup|TestStep|TestStepContainer|TestSuite|Text|Then|When)`
   - Used in: I{Type}, create{Type}(), {Type}Utility, {Type}IssueTypes, {Type}IssueDetector, {Type}IssueResolver
   - Case variants: `{type}` (camelCase), `{TYPE}` (UPPER_SNAKE_CASE)

3. **{Assignment}** - Named assignments within grammar rules
   - Values: `(Name|StatementList|StepDefinitionList|StepParameterList|Table|TestStepContainerList|TestStepList|TestDataList|StepObjectName|StepDefinitionName|Text|RowList|CellList)`
   - Used in: validate{Assignment}{Issue}(), correct{Assignment}{Issue}(), suggest{Assignment}{Issue}()
   - Case variants: `{assignment}` (camelCase for get/set methods), `{ASSIGNMENT}` (UPPER_SNAKE_CASE for enum constants)

4. **{Fragment}** - Test step regex fragments defining type enumerations
   - Values: `(Component|ObjectVertex|ObjectEdge|Part|State|Time|Attachment)`
   - Used in: {Type}{Fragment}Types
   - Derived from: Regex constants with _TYPE suffix in TestStepUtility (COMPONENT_TYPE, OBJECT_TYPE_VERTEX, OBJECT_TYPE_EDGE, PART_TYPE, STATE_TYPE, TIME_TYPE, ATTACHMENT)
   - Case variants: `{fragment}` (camelCase), `{FRAGMENT}` (UPPER_SNAKE_CASE)

5. **{Issue}** - Issue scope levels from {Type}IssueTypes enum
   - Values: `(Only|File|Workspace)`
   - Used in: validate{Assignment}{Issue}(), correct{Assignment}{Issue}(), suggest{Assignment}{Issue}()
   - Case variants: `{issue}` (camelCase), `{ISSUE}` (UPPER_SNAKE_CASE)

6. **{Proposal}** - Proposal attributes.
   - Values: `(Id|Description|Value|QualifiedName)`

7. **{IO}** - File operations. This has nothing to do with the domain, remove it
   - Values: `(get|put|delete|list|clear|contains)`

8. **{Accessor}** - Standard accessor naming convention. This has nothing to do with the domain, remove it
   - Values: `(get|set|add|is)`

See `sheep-dog-main/site/impl/impl-xtext.md` Domain Terminology section for additional context.