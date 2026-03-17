# {Type}IssueResolver

Quick fix proposal generation for validation errors. Separates fix proposal logic from detection and application, enabling IDE-independent validation tooling.

## suggest{Assignment}{Scope}(I{Type}, I{Type})

**Desc**: Generates proposals suggesting values when an assignment is missing or empty.

**Rule**: SOME method names follow suggest{Assignment}{Scope} pattern.
 - **Name**: `^suggest{Assignment}{Scope}$`
 - **Return**: `^ArrayList<{Language}IssueProposal>$`
 - **Parameters**: `^\(I{Type}\s+[a-z]\w+,\s*I{Type}\s+[a-z]\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep, ITestProject workspace)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep, ITestProject workspace)`
 - `public static ArrayList<SheepDogIssueProposal> suggestStepParametersWorkspace(IRow theRow, ITestProject workspace)`
 - `public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(ITestStep theTestStep, ITestProject workspace)`

## correct{Assignment}{Scope}(I{Type}, I{Type})

**Desc**: Generates proposals correcting values when an assignment exists but is invalid.

**Rule**: SOME method names follow correct{Assignment}{Scope} pattern.
 - **Name**: `^correct{Assignment}{Scope}$`
 - **Return**: `^ArrayList<{Language}IssueProposal>$`
 - **Parameters**: `^\(I{Type}\s+[a-z]\w+,\s*I{Type}\s+[a-z]\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep, ITestProject workspace)`
 - `public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep, ITestProject workspace)`
 - `public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(ITestStep theTestStep, ITestProject workspace)`
