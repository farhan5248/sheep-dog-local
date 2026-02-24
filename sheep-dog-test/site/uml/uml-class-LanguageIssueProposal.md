# {Language}IssueProposal

Data transfer object holding quick fix proposal data. Separates proposal data (id, description, value) from proposal generation and application logic.

## {Language}IssueProposal

**Desc**: Initializes all proposal fields to empty strings for subsequent population.

**Rule**: ONE constructor names match default constructor pattern.
 - **Name**: `^{Language}IssueProposal$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public SheepDogIssueProposal()`

## getId

**Desc**: Provides read access to the proposal identifier for matching and lookup.

**Rule**: ONE method names follow getId pattern.
 - **Name**: `^getId$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getId()`

## setId

**Desc**: Provides write access to the proposal identifier.

**Rule**: ONE method names follow setId pattern.
 - **Name**: `^setId$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setId(String id)`

## getDescription

**Desc**: Provides read access to the proposal description for UI display.

**Rule**: ONE method names follow getDescription pattern.
 - **Name**: `^getDescription$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getDescription()`

## setDescription

**Desc**: Provides write access to the proposal description.

**Rule**: ONE method names follow setDescription pattern.
 - **Name**: `^setDescription$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setDescription(String description)`

## getValue

**Desc**: Provides read access to the proposal value. Returns Object to support both String and IStepObject types.

**Rule**: ONE method names follow getValue pattern.
 - **Name**: `^getValue$`
 - **Return**: `^Object$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public Object getValue()`

## setValue

**Desc**: Provides write access to the proposal value. Accepts Object to support both String and IStepObject types.

**Rule**: ONE method names follow setValue pattern.
 - **Name**: `^setValue$`
 - **Return**: `^void$`
 - **Parameters**: `^\(Object\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setValue(Object value)`

## toString

**Desc**: Generates formatted string representation for debugging and logging purposes.

**Rule**: ONE method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
