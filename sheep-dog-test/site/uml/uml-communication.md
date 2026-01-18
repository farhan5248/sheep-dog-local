# UML Communication Patterns

These patterns apply to grammar elements (see **Type** definition in Pattern Variables in uml-overview.md). Each non-terminal grammar rule should follow one of these collaboration patterns.

## Interface Definition

This collaboration applies when defining basic grammar element interfaces with simple getters and setters. There is no proposal, validation or correction for the grammar element.

**Methods**
- Basic interface usage for grammar element access
- Simple property retrieval and modification
- Parent-child relationship navigation

### I{Type}

Interface defining the grammar element with basic accessors and mutators for element properties and relationships.

**Methods**
- `getName()`
- `setName(String value)`
- `getParent()`
- `get{Assignment}List()`
- `add{Assignment}({ElementType} element)`

### {Type}Utility

Static utility class with helper methods that derive properties from grammar elements or validate text formats.

**Methods**
- `get{Property}(I{Type} element)`
- `isValid(String text)`

### {TypeAspect}Types

Enum with type constants for grammar element aspects. Each constant represents a valid keyword or type value used by utility methods and test implementations.

**Methods**
- Enum constants accessed by {Type}Utility methods
- Type validation in test implementations

## Suggest

This pattern applies when proposing content assist suggestions for absent grammar elements. The element doesn't exist yet, so we suggest alternatives.

### {Type}IssueResolver

Static resolution class that suggests existing alternatives for absent grammar elements.

**Methods**
- `suggest{Aspect}(I{Type} element)`

### SheepDogIssueProposal

Data container for suggestion proposals with properties for id, description, value, and optional qualifiedName.

**Methods**
- `setId(String id)`
- `setDescription(String description)`
- `setValue(String value)`
- `setQualifiedName(String qualifiedName)`

### I{Type}

Interface defining the grammar element used by suggestion methods to access element properties.

**Methods**
- `getName()`
- `getParent()`

### {Type}Utility

Static utility class with helper methods that derive properties for proposal generation.

**Methods**
- `get{Property}(I{Type} element)`

## Validate

This pattern applies when validating existing grammar elements. The element exists, so we validate its content.

### {Type}IssueDetector

Static validation class that validates grammar element aspects and returns issue descriptions.

**Methods**
- `validate{Aspect}(I{Type} element)`

### {Type}IssueTypes

Enum with issue type constants. Each constant has a description field (String) used by validation methods.

**Methods**
- Enum constants with description fields
- Accessed by {Type}IssueDetector.validate{Aspect}() methods

### I{Type}

Interface defining the grammar element used by issue detection to access element properties.

**Methods**
- `getName()`
- `getParent()`

### {Type}Utility

Static utility class with helper methods that derive properties for validation.

**Methods**
- `get{Property}(I{Type} element)`
- `isValid(String text)`

## Correct

This pattern applies when proposing corrections for invalid grammar elements. The element exists but is invalid, so we propose corrections.

### {Type}IssueResolver

Static resolution class that generates correction proposals for invalid grammar elements.

**Methods**
- `correct{Aspect}(I{Type} element)`

### {Type}IssueTypes

Enum with issue type constants. Each constant has a description field (String) used by validation methods.

**Methods**
- Enum constants with description fields
- Accessed by {Type}IssueDetector.validate{Aspect}() methods

### SheepDogIssueProposal

Data container for correction proposals with properties for id, description, value, and optional qualifiedName.

**Methods**
- `setId(String id)`
- `setDescription(String description)`
- `setValue(String value)`
- `setQualifiedName(String qualifiedName)`

### I{Type}

Interface defining the grammar element used by issue detection and resolution to access element properties.

**Methods**
- `getName()`
- `getParent()`

### {Type}Utility

Static utility class with helper methods that derive properties for validation and proposal generation.

**Methods**
- `get{Property}(I{Type} element)`
- `isValid(String text)`

### {Language}Builder

Static factory class for creating and managing elements, adding them to parent elements during correction workflows.

**Methods**
- `create{Type}(I{Parent} parent, {params})`

### {Language}Factory

Singleton factory for creating element instances without adding them to parent elements.

**Methods**
- `create{Type}({params})`
