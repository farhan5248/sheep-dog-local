# {Feature}IssueTypes

## Enum constants follow naming convention pattern

All {Feature}IssueTypes enums follow the naming convention exactly: constant value matches constant name.
The names match the value of id attribute in the constructor.

## Issue constants follow {Feature}_{Aspect}_{Issue} pattern

All issue constants follow the pattern of the {Feature} followed by child {Feature} followed by an optional {Aspect} and then {Issue} (ONLY, FILE, WORKSPACE).

Examples:
- TEST_SUITE_NAME_ONLY for capitalization or regex checks
- ROW_CELL_LIST_WORKSPACE for references check
- TEST_STEP_NAME_FILE for first component requirement
- TESTSTEP_NAME_STEP_DEFINITION_WORKSPACE

### TestStepContainerIssueTypes

```java
TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital")
TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE("TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE", "The first step must have a component")
```

### RowIssueTypes

```java
ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE", "The step parameters don't exist for the step definition")
```
