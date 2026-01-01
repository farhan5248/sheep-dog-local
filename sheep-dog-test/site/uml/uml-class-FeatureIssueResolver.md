# FeatureIssueResolver

All resolver classes follow the `proposeISSUENAME` pattern.
Not all issues have a resolution, some have no corresponding propose* method.
Method names match the grammar attributes they validate like `proposeNameOnly` or `proposeCellListWorkspace`

## TestStepIssueResolver

```java
public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep testStep)
```

## RowIssueResolver

```java
public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep testStep)
public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep testStep)
```
