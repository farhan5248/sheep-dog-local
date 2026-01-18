# UML Activity Patterns

These patterns correspond to cucumber scenario paths. Each scenario follows one pattern.
Pattern names match the collaboration names in uml-communication.md.

Structure:
- Level 2 = Pattern name (Suggest/Validate/Correct)
- Level 3 = Business object name pattern (StepObjectRef - the domain object)
- Step Patterns = Actions on that object (StepDefinitionRef)

## Suggest

When the grammar element doesn't exist, propose content assist suggestions.

### The xtext plugin propose .* action

**Step Patterns**
- `is performed`

### The xtext plugin propose content dialog

**Step Patterns**
- `will be set as follows`
- `will be empty`

## Validate

When the grammar element exists, validate the content (validation passes or fails).

### The xtext plugin validate .* action

**Step Patterns**
- `is performed`
- `is performed as follows`

### The xtext plugin validate .* dialog

**Step Patterns**
- `will be empty`
- `will be set as follows`

## Correct

When the grammar element is invalid, generate corrections.

### The xtext plugin generate step definition action

**Step Patterns**
- `is performed`

### The .* project .* file

**Step Patterns**
- `will be created as follows`
