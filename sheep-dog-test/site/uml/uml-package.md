# UML Package Patterns

## src/main/java/org/farhan/dsl/issues

**Desc**: Validation and quick fix infrastructure. Separates detection, resolution, and proposal data structures from grammar model and UI frameworks, enabling IDE-independent validation tooling.

### {Language}IssueProposal

**Desc**: Data transfer object holding quick fix proposal data. Separates proposal data (id, description, value, qualifiedName) from proposal generation and application logic.

**Rule**: ONE class matches {Language}IssueProposal pattern

**Regex**: `^{Language}IssueProposal$`
 - `SheepDogIssueProposal`

### {Type}IssueTypes

**Desc**: Enum constants for validation error types. Separates error type definitions from validation logic, providing stable identifiers for detector-resolver coordination.

**Rule**: SOME class matches {Type}IssueTypes pattern

**Regex**: `^{Type}IssueTypes$`
 - `TestStepIssueTypes`
 - `TextIssueTypes`

### {Type}IssueDetector

**Desc**: Validation logic for grammar elements at different scopes. Separates validation rules from grammar model and UI, enabling reuse across editors and build tools.

**Rule**: SOME class matches {Type}IssueDetector pattern

**Regex**: `^{Type}IssueDetector$`
 - `TestStepIssueDetector`
 - `TextIssueDetector`

### {Type}IssueResolver

**Desc**: Quick fix proposal generation for validation errors. Separates fix proposal logic from detection and application, enabling IDE-independent validation tooling.

**Rule**: SOME class matches {Type}IssueResolver pattern

**Regex**: `^{Type}IssueResolver$`
 - `TestStepIssueResolver`
 - `TextIssueResolver`

### LoggerFactory

**Desc**: Facade for logger creation that abstracts SLF4J vs custom logger providers. Separates logging infrastructure concerns from business logic by hiding provider selection and fallback.

**Rule**: ONE class matches LoggerFactory pattern

**Regex**: `^LoggerFactory$`
 - `LoggerFactory`

### LoggerProvider

**Desc**: Interface for custom logger implementations. Separates logger provider contract from logger usage, enabling dependency injection in environments without SLF4J.

**Rule**: ONE class matches LoggerProvider pattern

**Regex**: `^LoggerProvider$`
 - `LoggerProvider`

## src/main/java/org/farhan/dsl/lang

**Desc**: Grammar model interfaces and creation infrastructure. Separates interface contracts from implementations, initialization logic from factory operations, and persistence contracts from business logic.

### IResourceRepository

**Desc**: Repository interface for file I/O operations. Separates persistence contracts from business logic, allowing different implementations (filesystem, in-memory, Eclipse workspace).

**Rule**: ONE class matches IResourceRepository pattern

**Regex**: `^IResourceRepository$`
 - `IResourceRepository`

### {Language}Builder

**Desc**: Static factory for creating and initializing grammar elements. Separates object construction and initialization logic from factory operations and grammar model definitions.

**Rule**: ONE class matches {Language}Builder pattern

**Regex**: `^{Language}Builder$`
 - `SheepDogBuilder`

### {Language}Factory

**Desc**: Singleton holder that provides global access to the concrete factory instance. Separates factory instance management from factory operations and builder logic.

**Rule**: ONE class matches {Language}Factory pattern

**Regex**: `^{Language}Factory$`
 - `SheepDogFactory`

### I{Language}Factory

**Desc**: Factory interface for creating empty grammar instances. Separates factory contract from initialization logic and concrete implementations (EMF vs POJO).

**Rule**: ONE class matches I{Language}Factory pattern

**Regex**: `^I{Language}Factory$`
 - `ISheepDogFactory`

### I{Type}

**Desc**: Grammar element interface contracts. Separates interface definitions from implementations, allowing multiple backends (EMF, POJO) for the same grammar model.

**Rule**: SOME class matches I{Type} pattern

**Regex**: `^I{Type}$`
 - `ITestStep`
 - `IText`
 - `ICell`
 - `IRow`

### {Language}Utility

**Desc**: Static helper methods for grammar element operations. Separates utility operations from grammar model classes, keeping interfaces focused on data access.

**Rule**: ONE class matches {Language}Utility pattern

**Regex**: `^{Language}Utility$`
 - `SheepDogUtility`

### {Type}Fragments

**Desc**: Parser utilities for extracting typed fragments from formatted text strings. Separates parsing logic from grammar model classes, using regex patterns to extract components based on domain-specific syntax rules.

**Rule**: SOME class matches {Type}Fragments pattern

**Regex**: `^{Type}Fragments$`
 - `StepObjectRefFragments`
 - `StepDefinitionRefFragments`
 - `TitleFragments`

### {Type}{Fragment}Types

**Desc**: Enum constants for test step keyword patterns. Separates keyword definitions from parsing logic, enabling centralized maintenance of domain vocabulary.

**Rule**: SOME class matches {Type}{Fragment}Types pattern

**Regex**: `^{Type}{Fragment}Types$`
 - `TestStepComponentTypes`
 - `TestStepObjectVertexTypes`
 - `TestStepObjectEdgeTypes`
 - `TestStepPartTypes`
 - `TestStepStateTypes`
 - `TestStepTimeTypes`
 - `TestStepAttachmentTypes`
