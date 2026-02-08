# {Type}{Fragment}Types

Enum classes defining regex constants for test step fragments. Each enum constant represents a keyword or pattern used in test step matching.

## {FRAGMENT}(_{WORD})*

**Desc**: All enum constants follow UPPER_SNAKE_CASE naming pattern.

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

**Desc**: Each enum constant has a public final String field named 'value' containing the lowercase keyword used in test steps.

**Rule**: ONE field matches this pattern.
 - **Name**: `^value$`
 - **Return**: `^String$`
 - **Modifier**: `^public\s+final$`

**Examples**:
 - `public final String value`

## description

**Desc**: Each enum constant has a public final String field named 'description' providing human-readable explanation.

**Rule**: ONE field matches this pattern.
 - **Name**: `^description$`
 - **Return**: `^String$`
 - **Modifier**: `^public\s+final$`

**Examples**:
 - `public final String description`

## {Type}{Fragment}Types

**Desc**: Private constructor that initializes the value and description fields for each enum constant.

**Rule**: ONE constructor matches this pattern.
 - **Name**: `^{Type}{Fragment}Types$`
 - **Parameters**: `^\(String\s+value,\s*String\s+description\)$`

**Examples**:
 - `TestStepComponentTypes(String value, String description)`
 - `TestStepObjectVertexTypes(String value, String description)`
