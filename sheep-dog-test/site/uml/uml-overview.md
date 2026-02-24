# UML Overview

**References**

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
   - Values: `(And|Cell|Description|Given|Line|Model|NestedDescription|Phrase|Row|StepDefinition|StepDefinitionRef|StepObject|StepObjectRef|StepParameters|Table|TestCase|TestData|TestProject|TestSetup|TestStep|TestStepContainer|TestSuite|Text|Then|When)`
   - Used in: I{Type}, create{Type}(), {Type}Utility, {Type}IssueTypes, {Type}IssueDetector, {Type}IssueResolver
   - Case variants: `{type}` (camelCase), `{TYPE}` (UPPER_SNAKE_CASE)

3. **{Assignment}** - Named assignments within grammar rules
   - Values: `(Name|Description|NestedDescription|LineList|StepDefinitionList|StepParameterList|Table|TestStepContainerList|TestStepList|TestDataList|StepObjectName|StepDefinitionName|Text|RowList|CellList|StepObjectList|TestSuiteList)`
   - Used in: validate{Assignment}{Scope}(), correct{Assignment}{Scope}(), suggest{Assignment}{Scope}()
   - Case variants: `{assignment}` (camelCase for get/set methods), `{ASSIGNMENT}` (UPPER_SNAKE_CASE for enum constants)

4. **{Fragment}** - Test step regex fragments defining type enumerations
   - Values: `(Component|Object|ObjectVertex|ObjectEdge|Part|State|Tag|Todo)`
   - Used in: {Type}{Fragment}Types
   - Case variants: `{fragment}` (camelCase), `{FRAGMENT}` (UPPER_SNAKE_CASE)

5. **{Scope}** - Issue scope levels from {Type}IssueTypes enum
   - Values: `(Only|File|Workspace)`
   - Used in: validate{Assignment}{Scope}(), correct{Assignment}{Scope}(), suggest{Assignment}{Scope}()
   - Case variants: `{scope}` (camelCase), `{SCOPE}` (UPPER_SNAKE_CASE)

