# {Type}{Fragment}Types

Enum classes defining regex constants for test step fragments. Each enum constant represents a keyword or pattern used in test step matching.

## {FRAGMENT}(_{WORD})*

All enum constants follow UPPER_SNAKE_CASE naming pattern.

**Rule**: SOME constant names follow {FRAGMENT} or {FRAGMENT}_{WORD} pattern

**Regex**: `^[A-Z][A-Z0-9_]*$`
 - `APPLICATION`
 - `SERVICE`
 - `PLUGIN`
 - `FILE`
 - `PAGE`
 - `RESPONSE`

## value

Each enum constant has a public final String field named 'value' containing the lowercase keyword used in test steps.

**Rule**: ONE field matches this pattern

**Regex**: `^public\s+final\s+String\s+value$`
 - `public final String value`

## description

Each enum constant has a public final String field named 'description' providing human-readable explanation.

**Rule**: ONE field matches this pattern

**Regex**: `^public\s+final\s+String\s+description$`
 - `public final String description`

## {Type}{Fragment}Types

Private constructor that initializes the value and description fields for each enum constant.

**Rule**: ONE constructor matches this pattern

**Regex**: `^{Type}{Fragment}Types\(String\s+value,\s*String\s+description\)$`
 - `TestStepComponentTypes(String value, String description)`
 - `TestStepObjectVertexTypes(String value, String description)`
