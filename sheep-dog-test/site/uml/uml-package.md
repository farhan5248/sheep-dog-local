# UML Package Patterns

## org.farhan.dsl.issues

### {Language}IssueProposal

Always has a class named {Language}IssueProposal

**Examples**
- SheepDogIssueProposal

### {Type}IssueTypes

Might have one class per {Type} named {Type}IssueTypes

**Examples**
- TestStepIssueTypes
- TextIssueTypes

### {Type}IssueDetector

Might have one class per {Type} named {Type}IssueDetector

**Examples**
- TestStepIssueDetector
- TextIssueDetector

### {Type}IssueResolver

Might have one class per {Type} named {Type}IssueResolver

**Examples**
- TestStepIssueResolver
- TextIssueResolver

### LoggerFactory

Always has a class named LoggerFactory that provides loggers to all classes in this package.

**Examples**
- LoggerFactory

### LoggerProvider

Always has an interface named LoggerProvider that allows external systems to inject custom logger implementations.

**Examples**
- LoggerProvider

## org.farhan.dsl.lang

### IResourceRepository

Always has an interface named IResourceRepository

**Examples**
- IResourceRepository

### ITestProject

Always has an interface named ITestProject

**Examples**
- ITestProject

### {Language}Builder

Always has a class named {Language}Builder

**Examples**
- SheepDogBuilder

### {Language}Factory

Always has a class named {Language}Factory

**Examples**
- SheepDogFactory

### I{Type}

Always has one interface per {Type} named I{Type}

**Examples**
- ITestStep
- IText

### {Type}Utility

Might have one class per {Type} named {Type}Utility

**Examples**
- TestStepUtility
- StepDefinitionUtility

### {TypeAspect}Types

Might have multiple classes per {Type} named {TypeAspect}Types

**Examples**
- TestStepComponentTypes
- TestStepObjectEdgeTypes
- TestStepObjectVertexTypes
