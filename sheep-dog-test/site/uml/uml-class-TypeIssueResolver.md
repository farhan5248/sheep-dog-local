# {Type}IssueResolver

Quick fix proposal generator for validation issues. Provides corrections (when value exists but is wrong) and suggestions (when value is missing).

## suggest{Assignment}{Issue}(I{Type})

**Desc**: Resolver public API methods generate quick fix proposals for validation issues.

**Rule**: SOME method names follow suggest{Assignment}{Issue} pattern.
 - **Name**: `^suggest{Assignment}{Issue}$`
 - **Return**: `^ArrayList<{Language}IssueProposal>$`
 - **Parameters**: `^\(I{Type}\s+[a-z]\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep)`

## correct{Assignment}{Issue}(I{Type})

**Desc**: Resolver public API methods generate quick fix proposals for validation issues.

**Rule**: SOME method names follow correct{Assignment}{Issue} pattern.
 - **Name**: `^correct{Assignment}{Issue}$`
 - **Return**: `^ArrayList<{Language}IssueProposal>$`
 - **Parameters**: `^\(I{Type}\s+[a-z]\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep theTestStep)`
