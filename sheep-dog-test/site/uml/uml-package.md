# UML Package Patterns

## src/main/java/org/farhan/dsl/issues

### {Language}IssueProposal

Always has a class named {Language}IssueProposal that represents quick fix proposals for validation issues.

**Rule**: ONE class matches {Language}IssueProposal pattern

**Regex**: `^{Language}IssueProposal$`
 - `SheepDogIssueProposal`

### {Type}IssueTypes

Might have one class per {Type} named {Type}IssueTypes that defines enum constants for issue types.

**Rule**: SOME class matches {Type}IssueTypes pattern

**Regex**: `^{Type}IssueTypes$`
 - `TestStepIssueTypes`
 - `TextIssueTypes`

### {Type}IssueDetector

Might have one class per {Type} named {Type}IssueDetector that validates grammar assignments.

**Rule**: SOME class matches {Type}IssueDetector pattern

**Regex**: `^{Type}IssueDetector$`
 - `TestStepIssueDetector`
 - `TextIssueDetector`

### {Type}IssueResolver

Might have one class per {Type} named {Type}IssueResolver that generates quick fix proposals.

**Rule**: SOME class matches {Type}IssueResolver pattern

**Regex**: `^{Type}IssueResolver$`
 - `TestStepIssueResolver`
 - `TextIssueResolver`

### LoggerFactory

Always has a class named LoggerFactory that provides loggers to all classes in this package.

**Rule**: ONE class matches LoggerFactory pattern

**Regex**: `^LoggerFactory$`
 - `LoggerFactory`

### LoggerProvider

Always has an interface named LoggerProvider that allows external systems to inject custom logger implementations.

**Rule**: ONE class matches LoggerProvider pattern

**Regex**: `^LoggerProvider$`
 - `LoggerProvider`

## src/main/java/org/farhan/dsl/lang

### IResourceRepository

Always has an interface named IResourceRepository for resource management.

**Rule**: ONE class matches IResourceRepository pattern

**Regex**: `^IResourceRepository$`
 - `IResourceRepository`

### ITestProject

Always has an interface named ITestProject representing the root of the test project hierarchy.

**Rule**: ONE class matches ITestProject pattern

**Regex**: `^ITestProject$`
 - `ITestProject`

### {Language}Builder

Always has a class named {Language}Builder that creates and initializes grammar elements.

**Rule**: ONE class matches {Language}Builder pattern

**Regex**: `^{Language}Builder$`
 - `SheepDogBuilder`

### {Language}Factory

Always has a class named {Language}Factory that creates grammar elements without initialization.

**Rule**: ONE class matches {Language}Factory pattern

**Regex**: `^{Language}Factory$`
 - `SheepDogFactory`

### I{Language}Factory

Always has an interface named I{Language}Factory defining factory methods for grammar elements.

**Rule**: ONE class matches I{Language}Factory pattern

**Regex**: `^I{Language}Factory$`
 - `ISheepDogFactory`

### I{Type}

Always has one interface per {Type} named I{Type} representing grammar elements.

**Rule**: SOME class matches I{Type} pattern

**Regex**: `^I{Type}$`
 - `ITestStep`
 - `IText`
 - `ICell`
 - `IRow`

### {Type}Utility

Might have one class per {Type} named {Type}Utility providing helper methods.

**Rule**: SOME class matches {Type}Utility pattern

**Regex**: `^{Type}Utility$`
 - `TestStepUtility`
 - `StepDefinitionUtility`
 - `StatementUtility`

### {Type}{Fragment}Types

Might have multiple classes per {Type} named {Type}{Fragment}Types defining enum constants for test step regex fragments.

**Rule**: SOME class matches {Type}{Fragment}Types pattern

**Regex**: `^{Type}{Fragment}Types$`
 - `TestStepComponentTypes`
 - `TestStepObjectVertexTypes`
 - `TestStepObjectEdgeTypes`
 - `TestStepPartTypes`
 - `TestStepStateTypes`
 - `TestStepTimeTypes`
 - `TestStepAttachmentTypes`
