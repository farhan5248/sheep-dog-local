# UML Communication Patterns

These patterns apply to grammar elements (see **Type** definition in Pattern Variables in uml-overview.md). Each non-terminal grammar rule should follow one of these collaboration patterns.

## Interface Definition

This collaboration applies when defining basic grammar element interfaces with simple getters and setters. There is no proposal, validation or correction for the grammar element.

### I{Type}

Interface defining the grammar element with basic accessors and mutators for element properties and relationships.

### {Type}Utility

Static utility class with helper methods that derive properties from grammar elements or validate text formats.

### {Type}IssueTypes

Enum with type constants for grammar element aspects. Each constant represents a valid keyword or type value used by utility methods and test implementations.

## Suggest

This pattern applies when proposing content assist suggestions for absent grammar elements. The element doesn't exist yet, so we suggest alternatives.

### {Type}IssueResolver

Static resolution class that suggests existing alternatives for absent grammar elements.

### {Language}IssueProposal

Data container for suggestion proposals with properties for id, description, value, and optional qualifiedName.

### I{Type}

Interface defining the grammar element used by suggestion methods to access element properties.

### {Type}Utility

Static utility class with helper methods that derive properties for proposal generation.

## Validate

This pattern applies when validating existing grammar elements. The element exists, so we validate its content.

### {Type}IssueDetector

Static validation class that validates grammar element aspects and returns issue descriptions.

### {Type}IssueTypes

Enum with issue type constants. Each constant has a description field (String) used by validation methods.

### I{Type}

Interface defining the grammar element used by issue detection to access element properties.

### {Type}Utility

Static utility class with helper methods that derive properties for validation.

## Correct

This pattern applies when proposing corrections for invalid grammar elements. The element exists but is invalid, so we propose corrections.

### {Type}IssueResolver

Static resolution class that generates correction proposals for invalid grammar elements.

### {Type}IssueTypes

Enum with issue type constants. Each constant has a description field (String) used by validation methods.

### SheepDogIssueProposal

Data container for correction proposals with properties for id, description, value, and optional qualifiedName.

### I{Type}

Interface defining the grammar element used by issue detection and resolution to access element properties.

### {Type}Utility

Static utility class with helper methods that derive properties for validation and proposal generation.

### {Language}Builder

Static factory class for creating and managing elements, adding them to parent elements during correction workflows.

### {Language}Factory

Singleton factory for creating element instances without adding them to parent elements.
