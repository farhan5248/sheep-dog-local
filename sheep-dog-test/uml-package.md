# UML Package Patterns

## org\farhan\dsl\issues

**Rules**
- Always has a class named **Language**IssueProposal
- Might have one class per **Feature** named **Feature**IssueTypes
- Might have one class per **Feature** named **Feature**IssueDetector
- Might have one class per **Feature** named **Feature**IssueResolver

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
- Always has a class named **Language**Builder
- Always has a class named **Language**Factory
- Always has an interface named ITestProject
- Always has one interface per **Feature** named I**Feature**
- Might have one class per **Feature** named **Feature**Utility
- Might have multiple classes per **Feature** named **FeatureAspect**Types

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
