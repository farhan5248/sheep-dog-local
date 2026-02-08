# {Type}IssueResolver

Quick fix proposal generator for validation issues. Provides corrections (when value exists but is wrong) and suggestions (when value is missing).

## suggest{Assignment}{Issue}(I{Type})

Resolver public API methods generate quick fix proposals for validation issues.

**Rule**: SOME method names follow suggest{Assignment}{Issue} pattern

**Regex**: `^public\s+static\s+ArrayList<{Language}IssueProposal>\s+suggest{Assignment}{Issue}\(I{Type}\s+[a-z]\w+\)$`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep)`

## correct{Assignment}{Issue}(I{Type})

Resolver public API methods generate quick fix proposals for validation issues.

**Rule**: SOME method names follow correct{Assignment}{Issue} pattern

**Regex**: `^public\s+static\s+ArrayList<{Language}IssueProposal>\s+correct{Assignment}{Issue}\(I{Type}\s+[a-z]\w+\)$`
 - `public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep theTestStep)`
