# FeatureIssueResolver Proposal Methods

All resolver classes follow the `proposeISSUENAME` pattern.
Not all issues have a resolution, some have no corresponding propose* method.
Method names match the grammar attributes they validate like `proposeNameOnly` or `proposeCellListWorkspace`

## TestStepIssueResolver

```java
// For validateName(ITestStep)
public static ArrayList<SheepDogIssueProposal> proposeName(ITestStep testStep, ITestProject testProject) ✓

```

## RowIssueResolver

```java
// For validateReference(IRow)
public static ArrayList<SheepDogIssueProposal> proposeCellList(IRow row) ✓
```
