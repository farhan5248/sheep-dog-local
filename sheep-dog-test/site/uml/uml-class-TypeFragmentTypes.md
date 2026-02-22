# {Type}{Fragment}Types

Enum constants for test step keyword patterns. Separates keyword definitions from parsing logic, enabling centralized maintenance of domain vocabulary.

## {FRAGMENT}

**Desc**: Defines a keyword constant with associated value and description for test step matching.

**Rule**: SOME constant names follow {FRAGMENT} or {FRAGMENT}_{WORD} pattern.
 - **Name**: `^[A-Z][A-Z0-9_]*$`

**Examples**:
 - `APPLICATION`
 - `SERVICE`
 - `PLUGIN`
 - `FILE`
 - `PAGE`
 - `RESPONSE`

## value

**Desc**: Stores the lowercase keyword string that appears in actual test step definitions.

**Rule**: ONE attribute matches this pattern.
 - **Name**: `^value$`
 - **Return**: `^String$`
 - **Modifier**: `^public\s+final$`

**Examples**:
 - `public final String value`

## description

**Desc**: Provides human-readable explanation of the keyword for documentation and UI display.

**Rule**: ONE attribute matches this pattern.
 - **Name**: `^description$`
 - **Return**: `^String$`
 - **Modifier**: `^public\s+final$`

**Examples**:
 - `public final String description`

## {Type}{Fragment}Types

**Desc**: Initializes enum constant with keyword value and description for test step parsing.

**Rule**: ONE constructor matches this pattern.
 - **Name**: `^{Type}{Fragment}(Desc|Type|Name|Edge|Vertex)*Types$`
 - **Parameters**: `^\(String\s+value,\s*String\s+description\)$`

**Examples**:
 - `TestStepComponentTypes(String value, String description)`
 - `TestStepObjectVertexTypes(String value, String description)`
