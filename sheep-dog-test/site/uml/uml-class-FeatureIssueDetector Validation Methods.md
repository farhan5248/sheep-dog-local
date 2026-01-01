# FeatureIssueDetector Validation Methods

All detector classes follow the `validateISSUENAME` pattern.
Method names match the grammar attributes they validate like `validateNameOnly` or `validateCellListWorkspace`

## TestStepIssueDetector

```java
public static String validateNameOnly(ITestStep step)
public static String validateNameWorkspace(ITestStep step)
```

## RowIssueDetector

```java
public static String validateCellListWorkspace(IRow row)
```
