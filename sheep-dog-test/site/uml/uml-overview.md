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
   - Values: `(And|Cell|Description|Given|Line|TestDocument|Phrase|Row|StepDefinition|StepDefinitionRef|StepObject|StepObjectRef|StepParameters|Table|TestCase|TestData|TestProject|TestSetup|TestStep|TestStepContainer|TestSuite|Text|Then|When)`
   - Used in: I{Type}, create{Type}(), {Type}Utility, {Type}IssueTypes, {Type}IssueDetector, {Type}IssueResolver
   - Case variants: `{type}` (camelCase), `{TYPE}` (UPPER_SNAKE_CASE)

3. **{Assignment}** - Named assignments within grammar rules
   - Values: `(Content|Name|Description|LineList|StepDefinitionList|StepParameterList|Table|TestStepContainerList|TestStepList|TestDataList|StepObjectName|StepDefinitionName|Text|RowList|CellList|TestDocumentList)`
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

6. **{ObjectType}** - Object types from StepObjectRef vertex and edge type enums
   - Values: `(File|Page|Response|Dialog|Directory|Popup|Annotation|Hover|Tooltip|Request|Goal|Job|Action)`
   - Used in: TestObject{ObjectType}
   - Case variants: `{objectType}` (camelCase), `{OBJECT_TYPE}` (UPPER_SNAKE_CASE)

7. **{ComponentType}** - Component types from StepObjectRefComponentTypes enum
   - Values: `(Application|Project|Service|Batchjob|Plugin)`
   - Used in: StepObjectRef component fragment decomposition
   - Case variants: `{componentType}` (camelCase), `{COMPONENT_TYPE}` (UPPER_SNAKE_CASE)

8. **{StateType}** - State verb types from StepDefinitionRefStateTypes enum
   - Values: `(Is|Isn't|WillBe|Won'tBe)`
   - Used in: StepDefinitionRef state fragment decomposition
   - Case variants: `{stateType}` (camelCase), `{STATE_TYPE}` (UPPER_SNAKE_CASE)

9. **{PartType}** - Part types from StepDefinitionRefPartTypes enum
    - Values: `(Type|Language|Assignment|Fragment|Scope|Node)`
    - Used in: StepDefinitionRef part fragment decomposition
    - Case variants: `{partType}` (camelCase), `{PART_TYPE}` (UPPER_SNAKE_CASE)

10. **{ObjectName}** - Object name from StepObjectRef, free-form text identifying the specific test object
    - Values: `.+` (regex from `StepObjectRefFragments.OBJECT_NAME`)
    - Used in: {ObjectName}ActionImpl, {ObjectName}FileImpl, {ObjectName}PopupImpl, {ObjectName}AnnotationImpl

11. **{StateDesc}** - State description from StepDefinitionRef, free-form text describing the performed action
    - Values: `.+` (regex from `StepDefinitionRefFragments.STATE_DESC`)
    - Used in: set{StateDesc}

12. **{ComponentName}** - Component name from StepObjectRef, free-form text identifying the specific component
    - Values: `.+` (regex from `StepObjectRefFragments.COMPONENT_NAME`)
    - Used in: `org.farhan.objects.{componentName}` (generated interface package), `org.farhan.stepdefs.{componentName}` (generated step definition package)
    - Case variants: `{componentName}` (camelCase)

