# UML Package Patterns

## org.farhan.dsl.issues

### {Language}IssueProposal

Always has a class named {Language}IssueProposal

**Examples**
- SheepDogIssueProposal

### {Feature}IssueTypes

Might have one class per {Feature} named {Feature}IssueTypes

**Examples**
- TestStepIssueTypes
- TextIssueTypes

### {Feature}IssueDetector

Might have one class per {Feature} named {Feature}IssueDetector

**Examples**
- TestStepIssueDetector
- TextIssueDetector

### {Feature}IssueResolver

Might have one class per {Feature} named {Feature}IssueResolver

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

### I{Feature}

Always has one interface per {Feature} named I{Feature}

**Examples**
- ITestStep
- IText

### {Feature}Utility

Might have one class per {Feature} named {Feature}Utility

**Examples**
- TestStepUtility
- StepDefinitionUtility

### {FeatureAspect}Types

Might have multiple classes per {Feature} named {FeatureAspect}Types

**Examples**
- TestStepComponentTypes
- TestStepObjectEdgeTypes
- TestStepObjectVertexTypes
