# FeatureIssueTypes Naming Convention

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
TEST_STEP_CONTAINER_NAME("TEST_STEP_CONTAINER_NAME", "Name should start with a capital")
```

## RowIssueTypes

```java
ROW_REFERENCE_CELL_LIST("ROW_REFERENCE_CELL_LIST", "The step parameters don't exist or the cell names don't match")
```
