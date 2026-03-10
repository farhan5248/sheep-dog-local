# TestObject{Language}

Language-specific DSL infrastructure. Manages static state (cursor, test project, dialogs), provides cursor navigation helpers, model query helpers, and builder delegation methods for constructing grammar elements during tests.

## reset

**Desc**: Resets all static state: creates a new test project via {Language}Builder, sets cursor to project root, clears all dialogs.

**Rule**: ALL method names follow reset pattern.
 - **Name**: `^reset$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static void reset()`

## add{Type}With{Assignment}

**Desc**: Creates a grammar element via {Language}Builder with auto-navigation. If cursor is already at the target type, moves up to parent first, then creates the child element and sets cursor to it.

**Rule**: SOME method names follow add{Type}With{Assignment} pattern.
 - **Name**: `^add{Type}With(Name|FullName|Content)$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void addTestSuiteWithFullName(String testSuiteFullName)`
 - `protected void addTestCaseWithName(String testStepContainerName)`
 - `protected void addTestStepWithFullName(String stepName)`
 - `protected void addStepObjectWithFullName(String stepObjectName)`
 - `protected void addStepDefinitionWithName(String name)`
 - `protected void addCellWithName(String name)`
 - `protected void addLineWithContent(String content)`
 - `protected void addRowWithContent(String content)`
 - `protected void addTextWithContent(String content)`

## assert{Type}{Assignment}

**Desc**: Queries the model for a grammar element's attribute value. If cursor is already at the target type, returns directly. Otherwise navigates to the element by name and returns its value. Returns null if not found.

**Rule**: SOME method names follow assert{Type}{Assignment} pattern.
 - **Name**: `^assert{Type}(Name|FullName|Content)$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String assertTestSuiteName(String name)`
 - `protected String assertTestStepContainerName(String name)`
 - `protected String assertTestStepFullName(String fullName)`
 - `protected String assertStepDefinitionName(String name)`
 - `protected String assertStepParametersName(String name)`
 - `protected String assertCellName(String name)`
 - `protected String assertLineContent(String content)`
 - `protected String assertTestDataName(String name)`

## getDescriptionFromCursor

**Desc**: Extracts the IDescription from the current cursor by type-checking against all grammar types that have a description assignment.

**Rule**: ALL method names follow getDescriptionFromCursor pattern.
 - **Name**: `^getDescriptionFromCursor$`
 - **Return**: `^IDescription$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected IDescription getDescriptionFromCursor()`

## getTableFromCursor

**Desc**: Extracts the ITable from the current cursor by type-checking against grammar types that have a table assignment.

**Rule**: ALL method names follow getTableFromCursor pattern.
 - **Name**: `^getTableFromCursor$`
 - **Return**: `^ITable$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected ITable getTableFromCursor()`

## transition

**Desc**: Overrides TestObject.transition(). Navigates cursor to a test document based on "Test Suite Full Name" or "Step Object Full Name" property values.

**Rule**: ALL method names follow transition pattern.
 - **Name**: `^transition$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void transition()`

## getDocumentFromNode

**Desc**: Walks up the grammar tree from any node to find the containing ITestDocument by traversing parent references.

**Rule**: ALL method names follow getDocumentFromNode pattern.
 - **Name**: `^getDocumentFromNode$`
 - **Return**: `^Object$`
 - **Parameters**: `^\(Object\s+\w+\)$`
 - **Modifier**: `^protected\s+static$`

**Examples**:
 - `protected static Object getDocumentFromNode(Object node)`

## setCursorAtNode

**Desc**: Navigates cursor to a specific node using a path string (e.g., "TestStepContainerList/1/TestStepList/2/Table").

**Rule**: ALL method names follow setCursorAtNode pattern.
 - **Name**: `^setCursorAtNode$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void setCursorAtNode(String path)`

## createNodeDependencies

**Desc**: Ensures all intermediate nodes exist along a path, creating them via {Language}Builder if missing.

**Rule**: ALL method names follow createNodeDependencies pattern.
 - **Name**: `^createNodeDependencies$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void createNodeDependencies(String part)`

## cursor

**Desc**: Current position in the grammar tree, used by navigation and query methods.

**Rule**: ALL attribute names follow cursor pattern.
 - **Name**: `^cursor$`

**Examples**:
 - `protected static Object cursor`

## testProject

**Desc**: Root grammar element for the test, created during reset().

**Rule**: ALL attribute names follow testProject pattern.
 - **Name**: `^testProject$`

**Examples**:
 - `protected static ITestProject testProject`

## validateDialog

**Desc**: Accumulated validation messages from validate actions.

**Rule**: ALL attribute names follow validateDialog pattern.
 - **Name**: `^validateDialog$`

**Examples**:
 - `protected static String validateDialog = ""`

## listProposalsDialog

**Desc**: Content assist proposals collected from list proposals actions.

**Rule**: ALL attribute names follow listProposalsDialog pattern.
 - **Name**: `^listProposalsDialog$`

**Examples**:
 - `protected static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>()`

## listQuickfixesDialog

**Desc**: Quick fix proposals collected from list quickfixes actions.

**Rule**: ALL attribute names follow listQuickfixesDialog pattern.
 - **Name**: `^listQuickfixesDialog$`

**Examples**:
 - `protected static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>()`
