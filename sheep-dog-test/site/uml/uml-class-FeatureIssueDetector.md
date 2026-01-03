# {Feature}IssueDetector

## Detector methods follow validate{Issue} naming pattern

All detector classes follow the `validate{Issue}` pattern.
Method names match the grammar attributes they validate.

**Method Signature Rules**:
- **Parameter Type**: MUST accept interface type I{Feature}, never EMF type {Feature}
- **Return Type**: MUST return String (empty string = valid, error description = invalid)

**Examples**

- TestStepIssueDetector

```java
public static String validateStepObjectNameOnly(ITestStep step)
public static String validateStepObjectNameWorkspace(ITestStep step)
public static String validateStepDefinitionNameOnly(ITestStep step)
public static String validateStepDefinitionNameWorkspace(ITestStep step)
```

- RowIssueDetector

```java
public static String validateCellListWorkspace(IRow row)
```
