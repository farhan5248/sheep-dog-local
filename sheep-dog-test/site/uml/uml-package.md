# UML Package Patterns

## org\farhan\dsl\issues

**Rules**
- Always has a class named {Language}IssueProposal
- Might have one class per {Feature} named {Feature}IssueTypes
- Might have one class per {Feature} named {Feature}IssueDetector
- Might have one class per {Feature} named {Feature}IssueResolver
- **Component-Based Organization**: Validation classes MUST be organized by grammar element, not by validation type (all TestStep concerns together, not all detectors together). 

**Examples**
- TestStepIssueTypes
- TextIssueTypes
- TestStepIssueDetector
- TextIssueDetector
- TestStepIssueResolver
- TextIssueResolver
- SheepDogIssueProposal

## org\farhan\dsl\lang

**Rules**
- Always has an interface named IResourceRepository
- Always has an interface named ITestProject
- Always has a class named {Language}Builder
- Always has a class named {Language}Factory
- Always has one interface per {Feature} named I{Feature}
- Might have one class per {Feature} named {Feature}Utility
- Might have multiple classes per {Feature} named {FeatureAspect}Types

**Examples**
- ITestStep
- IText
- TestStepUtility
- StepDefinitionUtility
- TestStepComponentTypes
- TestStepObjectEdgeTypes
- TestStepObjectVertexTypes
- SheepDogBuilder
- SheepDogFactory

## org\farhan\dsl\sheepdog\impl

**Rules**
- Always has one class per {Feature} named {Feature}Impl
- **EMF Wrapper Pattern**: Implementation classes MUST have private field of type matching grammar element name
- **Constructor Pattern**: {Feature}Impl constructor MUST accept {Feature} eObject parameter

**Examples**
- TestStepImpl (implements ITestStep, wraps TestStep EMF object)
- CellImpl (implements ICell, wraps Cell EMF object)
