# {Type}IssueTypes

Enum constants for validation error types. Separates error type definitions from validation logic, providing stable identifiers for detector-resolver coordination.

## {TYPE}(_{ASSIGNMENT})*_{ISSUE}

**Desc**: Defines a validation error type with unique identifier and user-facing description.

**Rule**: ALL constant names follow {TYPE}_{ASSIGNMENT}_{ISSUE} pattern.
 - **Name**: `^{TYPE}(_{ASSIGNMENT})*_{ISSUE}$`

**Examples**:
 - `TEST_SUITE_NAME_ONLY`
 - `ROW_CELL_LIST_WORKSPACE`
 - `TEST_STEP_NAME_FILE`
 - `TEST_STEP_CONTAINER_NAME_ONLY`
 - `TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE`

## id

**Desc**: Unique identifier matching the enum name, used to link detectors with resolvers.

**Rule**: ONE attribute is the identifier.
 - **Name**: `^id$`

**Examples**:
 - `id`

## description

**Desc**: Human-readable error message displayed to users when validation fails.

**Rule**: ONE attribute is the description explaining the problem.
 - **Name**: `^description$`

**Examples**:
 - `description`