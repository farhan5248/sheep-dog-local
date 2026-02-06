# UML Package Patterns

## src/main/java/org/farhan/dsl/issues

### ONE {Language}IssueProposal

Always has a class named {Language}IssueProposal that represents quick fix proposals for validation issues.

**Regex**: `^{Language}IssueProposal$`
 - `SheepDogIssueProposal`

### SOME {Type}IssueTypes

Might have one class per {Type} named {Type}IssueTypes that defines enum constants for issue types.

**Regex**: `^{Type}IssueTypes$`
 - `TestStepIssueTypes`
 - `TextIssueTypes`

### SOME {Type}IssueDetector

Might have one class per {Type} named {Type}IssueDetector that validates grammar assignments.

**Regex**: `^{Type}IssueDetector$`
 - `TestStepIssueDetector`
 - `TextIssueDetector`

### SOME {Type}IssueResolver

Might have one class per {Type} named {Type}IssueResolver that generates quick fix proposals.

**Regex**: `^{Type}IssueResolver$`
 - `TestStepIssueResolver`
 - `TextIssueResolver`

### ONE LoggerFactory

Always has a class named LoggerFactory that provides loggers to all classes in this package.

**Regex**: `^LoggerFactory$`
 - `LoggerFactory`

### ONE LoggerProvider

Always has an interface named LoggerProvider that allows external systems to inject custom logger implementations.

**Regex**: `^LoggerProvider$`
 - `LoggerProvider`

## src/main/java/org/farhan/dsl/lang

### ONE IResourceRepository

Always has an interface named IResourceRepository for resource management.

**Regex**: `^IResourceRepository$`
 - `IResourceRepository`

### ONE ITestProject

Always has an interface named ITestProject representing the root of the test project hierarchy.

**Regex**: `^ITestProject$`
 - `ITestProject`

### ONE {Language}Builder

Always has a class named {Language}Builder that creates and initializes grammar elements.

**Regex**: `^{Language}Builder$`
 - `SheepDogBuilder`

### ONE {Language}Factory

Always has a class named {Language}Factory that creates grammar elements without initialization.

**Regex**: `^{Language}Factory$`
 - `SheepDogFactory`

### ONE I{Language}Factory

Always has an interface named I{Language}Factory defining factory methods for grammar elements.

**Regex**: `^I{Language}Factory$`
 - `ISheepDogFactory`

### SOME I{Type}

Always has one interface per {Type} named I{Type} representing grammar elements.

**Regex**: `^I{Type}$`
 - `ITestStep`
 - `IText`
 - `ICell`
 - `IRow`

### SOME {Type}Utility

Might have one class per {Type} named {Type}Utility providing helper methods.

**Regex**: `^{Type}Utility$`
 - `TestStepUtility`
 - `StepDefinitionUtility`
 - `StatementUtility`

### SOME {TypeAspect}Types

Might have multiple classes per {Type} named {TypeAspect}Types defining enum constants for type aspects.

**Regex**: `^[A-Z][a-zA-Z0-9]*Types$`
 - `TestStepComponentTypes`
 - `TestStepObjectEdgeTypes`
 - `TestStepObjectVertexTypes`
