# UML Communication Patterns

These patterns apply to grammar elements (see **Feature** definition in Pattern Variables in uml-overview.md). Each non-terminal grammar rule should follow one of these collaboration patterns.

## Interface Definition

**Rules**
- There is no proposal, validation or correction for the grammar element.

### I{Feature}

Interface defining the grammar element.

- `getName()` - Returns element name
  - **Returns:** String

- `setName(String value)` - Sets element name
  - **Returns:** void

- `getParent()` - Returns parent element
  - **Returns:** Parent interface type

- `get{Attribute}List()` - Returns child element list
  - **Returns:** ArrayList

- `add{Attribute}({Type} element)` - Adds child element to list
  - **Returns:** void

### {Feature}Utility

Static utility class with helper methods.

- `get{Property}(I{Feature} element)` - Derives property from element
  - **Calls:** I{Feature}.getName(), I{Feature}.getParent(), I{Feature}.get{Attribute}List()
  - **Returns:** Computed values or boolean validation results

- `isValid(String text)` - Validates text format
  - **Returns:** boolean

### {FeatureAspect}Types

Enum with type constants for grammar element aspects. Each constant represents a valid keyword or type value.

**Accessed by:** {Feature}Utility methods, test implementations

## Content Correction

**Rules**
- Applies when proposing alternatives to non-empty invalid grammar elements.

### {Feature}IssueDetector

Static validation class.

- `validate{Aspect}(I{Feature} element)` - Validates grammar element
  - **Calls:** I{Feature}.getName(), I{Feature}.getParent(), other I{Feature} methods
  - **Returns:** {Feature}IssueTypes.{ISSUE_TYPE}.description (String, empty if valid)

### {Feature}IssueResolver

Static resolution class.

- `correct{Aspect}(I{Feature} element)` - Generates correction proposal
  - **Creates:** SheepDogIssueProposal instances
  - **Calls:** I{Feature}.getName(), I{Feature}.getParent(), {Feature}Utility methods, {Language}Builder.create{Feature}(), {Language}Factory.create{Feature}(), SheepDogIssueProposal.setId(), .setDescription(), .setValue()
  - **Returns:** ArrayList<SheepDogIssueProposal>

- `suggest{Aspect}(I{Feature} element)` - Suggests existing alternatives
  - **Creates:** SheepDogIssueProposal instances
  - **Calls:** I{Feature} methods, {Feature}Utility methods, SheepDogIssueProposal.setId(), .setDescription(), .setValue()
  - **Returns:** ArrayList<SheepDogIssueProposal>

### {Feature}IssueTypes

Enum with issue type constants. Each constant has a `description` field (String).

**Accessed by:** {Feature}IssueDetector.validate{Aspect}() methods

### SheepDogIssueProposal

Data container for correction/suggestion proposals.

**Properties:** id (String), description (String), value (String), qualifiedName (String, optional)

**Methods:** setId(), setDescription(), setValue(), setQualifiedName()

**Created by:** All {Feature}IssueResolver classes

### I{Feature}

Interface defining the grammar element.

- `getName()` - Returns element name
  - **Returns:** String

- `getParent()` - Returns parent element
  - **Returns:** Parent interface type

**Called by:** {Feature}IssueDetector, {Feature}IssueResolver

### {Feature}Utility

Static utility class with helper methods.

- `get{Property}(I{Feature} element)` - Derives properties for validation/proposal generation
  - **Calls:** I{Feature}.getName(), I{Feature}.getParent(), I{Feature}.get{Attribute}List()
  - **Returns:** Computed values or boolean validation results

- `isValid(String text)` - Validates text format
  - **Returns:** boolean

**Called by:** {Feature}IssueResolver

### {Language}Builder

Static factory class for creating and managing elements.

- `create{Feature}(I{Parent} parent, {params})` - Creates element and adds to parent
  - **Calls:** {Language}Factory.create{Feature}(), I{Parent}.add{Feature}()
  - **Returns:** Created I{Feature} instance

**Called by:** {Feature}IssueResolver.correct{Aspect}()

### {Language}Factory

Singleton factory for creating element instances.

- `create{Feature}({params})` - Creates element instance without parent
  - **Returns:** Created I{Feature} instance (not yet added to parent)

**Called by:** {Feature}IssueResolver.correct{Aspect}(), {Language}Builder.create{Feature}()
