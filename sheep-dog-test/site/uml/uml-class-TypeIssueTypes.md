# {Type}IssueTypes

## Enum constants follow naming convention pattern

All {Type}IssueTypes enums follow the naming convention exactly: constant value matches constant name.
The names match the value of id attribute in the constructor.

**Examples**

- TestStepContainerIssueTypes

```java
TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital")
TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE("TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE", "The first step must have a component")
```

- RowIssueTypes

```java
ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE", "The step parameters don't exist for the step definition")
```

## Issue constants follow {Type}_{Aspect}_{Issue} pattern

All issue constants follow the pattern of the {Type} followed by child {Type} followed by an optional {Aspect} and then {Issue} (ONLY, FILE, WORKSPACE).

**Examples**

```
TEST_SUITE_NAME_ONLY
ROW_CELL_LIST_WORKSPACE
TEST_STEP_NAME_FILE
TESTSTEP_NAME_STEP_DEFINITION_WORKSPACE
```
