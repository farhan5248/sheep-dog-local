# {Type}IssueDetector

## Detector methods follow validate{Assignment}{Issue} naming pattern

All detector methods validate specific grammar assignments at different validation scopes.

**Naming Pattern**: `validate{Assignment}{Issue}`
- **{Assignment}**: The grammar assignment being validated, converted to PascalCase
  - Grammar: `name=Title` → Method: `Name`
  - Grammar: `testStepList+=TestStep*` → Method: `TestStepList`
  - Grammar: `stepObjectName=ID` → Method: `StepObjectName`
  - Grammar: `cellList+=Cell*` → Method: `CellList`
- **{Issue}**: The validation scope level (defined in {Type}IssueTypes)
  - `Only` = Element-level validation (CheckType.FAST)
  - `File` = File-level validation (CheckType.NORMAL)
  - `Workspace` = Cross-file validation (CheckType.EXPENSIVE)

**Method Signature Rules**:
- **Parameter Type**: MUST accept interface type I{Type}, never EMF type {Type}
- **Return Type**: MUST return String (empty string = valid, error description = invalid)

**Examples**

- CellIssueDetector

```java
// Grammar: Cell: '|' name=Title;
// Validates the 'name' assignment at element scope
public static String validateNameOnly(ICell theCell)
```

- TestStepContainerIssueDetector

```java
// Grammar: TestStepContainer: TestSetup | TestCase;
//          TestCase: ... name=Title EOL ... testStepList+=TestStep* ...
// Validates the 'name' assignment across union subtypes
public static String validateNameOnly(ITestStepContainer theTestStepContainer)
// Validates the 'testStepList' assignment at file scope
public static String validateTestStepListFile(ITestStepContainer theTestStepContainer)
```

- TestStepIssueDetector

```java
// Grammar: TestStep: Given | When | Then | And;
//          Given: ... stepObjectName=ID '.' stepDefinitionName=ID ...
// Validates the 'stepObjectName' assignment at element and workspace scopes
public static String validateStepObjectNameOnly(ITestStep theTestStep)
public static String validateStepObjectNameWorkspace(ITestStep theTestStep)
// Validates the 'stepDefinitionName' assignment at element and workspace scopes
public static String validateStepDefinitionNameOnly(ITestStep theTestStep)
public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep)
```

- RowIssueDetector

```java
// Grammar: Row: cellList+=Cell+;
// Validates the 'cellList' assignment at workspace scope
public static String validateCellListWorkspace(IRow theRow)
```
