# {Type}IssueResolver

Quick fix proposal generator for validation issues. Provides corrections (when value exists but is wrong) and suggestions (when value is missing).

## (correct|suggest){Assignment}{Issue}(I{Type})

Resolver public API methods generate quick fix proposals for validation issues. Method name pattern is (correct|suggest) + {Assignment} + {Issue}. Not all issues have resolutions - some validation errors have no corresponding resolver methods. Classes may contain private helper methods that don't follow this pattern. Parameter type must be I{Type} interface. Return type must be ArrayList<{Language}IssueProposal>.

**Rule**: SOME method names follow (correct|suggest){Assignment}{Issue} pattern

**Regex**: `^public\s+static\s+ArrayList<{Language}IssueProposal>\s+(correct|suggest){Assignment}{Issue}\(I{Type}\s+[a-z]\w+\)$`
 - `public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep)`
