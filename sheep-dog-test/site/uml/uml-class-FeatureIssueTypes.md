# FeatureIssueTypes

All FeatureIssueTypes enums follow the naming convention exactly: constant value matches constant name, and constants correspond to grammar attributes or semantic properties. Descriptions are clear and user-friendly.

All issue constants follow the pattern of the feature followed by child feature followed by an optional ASPECT and then ONLY, FILE, WORKSPACE

Examples are
1. TEST_SUITE_NAME_ONLY for capitalization or regex checks
2. ROW_CELL_LIST_WORKSPACE for references check
3. TEST_STEP_NAME_FILE for first component requirement
4. TESTSTEP_NAME_STEP_DEFINITION_WORKSPACE

The names match the value of id attribute in the constructor

## TestStepContainerIssueTypes

```java
TEST_STEP_CONTAINER_NAME_ONLY("TEST_STEP_CONTAINER_NAME_ONLY", "Name should start with a capital")
TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE("TEST_STEP_CONTAINER_TEST_STEP_FILE_LIST_FILE", "The first step must have a component")
```

## RowIssueTypes

```java
ROW_CELL_LIST_WORKSPACE("ROW_CELL_LIST_WORKSPACE", "The step parameters don't exist for the step definition")
```
