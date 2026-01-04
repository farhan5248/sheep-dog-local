# UML Communication Patterns

These patterns apply to grammar elements (see **Feature** definition in Pattern Variables in uml-overview.md). Each non-terminal grammar rule should follow one of these collaboration patterns.

## Interface Definition

This collaboration applies when defining basic grammar element interfaces with simple getters and setters. There is no proposal, validation or correction for the grammar element.

**Methods**
- Basic interface usage for grammar element access
- Simple property retrieval and modification
- Parent-child relationship navigation

### I{Feature}

Interface defining the grammar element with basic accessors and mutators for element properties and relationships.

**Methods**
- `getName()`
- `setName(String value)`
- `getParent()`
- `get{Attribute}List()`
- `add{Attribute}({Type} element)`

### {Feature}Utility

Static utility class with helper methods that derive properties from grammar elements or validate text formats.

**Methods**
- `get{Property}(I{Feature} element)`
- `isValid(String text)`

### {FeatureAspect}Types

Enum with type constants for grammar element aspects. Each constant represents a valid keyword or type value used by utility methods and test implementations.

**Methods**
- Enum constants accessed by {Feature}Utility methods
- Type validation in test implementations

## Content Correction

This collaboration applies when proposing alternatives to non-empty invalid grammar elements. It involves validation, issue detection, and resolution with correction proposals.

**Methods**
- Grammar element validation workflows
- Issue detection and reporting
- Correction proposal generation
- Alternative suggestion workflows

### {Feature}IssueDetector

Static validation class that validates grammar element aspects and returns issue descriptions.

**Methods**
- `validate{Aspect}(I{Feature} element)`

### {Feature}IssueResolver

Static resolution class that generates correction proposals or suggests existing alternatives for invalid grammar elements.

**Methods**
- `correct{Aspect}(I{Feature} element)`
- `suggest{Aspect}(I{Feature} element)`

### {Feature}IssueTypes

Enum with issue type constants. Each constant has a description field (String) used by validation methods.

**Methods**
- Enum constants with description fields
- Accessed by {Feature}IssueDetector.validate{Aspect}() methods

### SheepDogIssueProposal

Data container for correction and suggestion proposals with properties for id, description, value, and optional qualifiedName.

**Methods**
- `setId(String id)`
- `setDescription(String description)`
- `setValue(String value)`
- `setQualifiedName(String qualifiedName)`

### I{Feature}

Interface defining the grammar element used by issue detection and resolution to access element properties.

**Methods**
- `getName()`
- `getParent()`

### {Feature}Utility

Static utility class with helper methods that derive properties for validation and proposal generation.

**Methods**
- `get{Property}(I{Feature} element)`
- `isValid(String text)`

### {Language}Builder

Static factory class for creating and managing elements, adding them to parent elements during correction workflows.

**Methods**
- `create{Feature}(I{Parent} parent, {params})`

### {Language}Factory

Singleton factory for creating element instances without adding them to parent elements.

**Methods**
- `create{Feature}({params})`
