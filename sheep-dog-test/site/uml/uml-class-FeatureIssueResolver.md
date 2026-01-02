# {Feature}IssueResolver

## Resolver methods follow correct{Issue} or suggest{Issue} naming pattern

All resolver classes follow the `correct{Issue}` or `suggest{Issue}` pattern.
Not all issues have a resolution, some have no corresponding correct* or suggest* method.
Method names match the grammar attributes they validate.

**Method Signature Rules**:
- **Parameter Type**: MUST accept interface type I{Feature}, never EMF type {Feature}
- **Return Type**: MUST return `ArrayList<{Language}IssueProposal>`

### TestStepIssueResolver

```java
public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep testStep)
```

### RowIssueResolver

```java
public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep testStep)
```
