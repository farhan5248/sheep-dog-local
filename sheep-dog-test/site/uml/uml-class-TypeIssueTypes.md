# {Type}IssueTypes

Enum class defining validation issue types for grammar elements. Each constant represents a specific validation error with an ID and description.

## {TYPE}(_{ASSIGNMENT})*_{ISSUE}

All enum constants follow the pattern {TYPE} prefix, one or more middle parts (assignment/child type names), and {ISSUE} suffix.

**Rule**: ALL constant names follow {TYPE}_{ASSIGNMENT}_{ISSUE} pattern

**Regex**: `^{TYPE}(_{ASSIGNMENT})*_{ISSUE}$`
 - `TEST_SUITE_NAME_ONLY`
 - `ROW_CELL_LIST_WORKSPACE`
 - `TEST_STEP_NAME_FILE`
 - `TEST_STEP_CONTAINER_NAME_ONLY`
 - `TEST_STEP_CONTAINER_TEST_STEP_LIST_FILE`
