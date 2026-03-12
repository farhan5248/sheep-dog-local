# TestObject{Language}Impl

**Extends**: TestObject

## reset

**Desc**: Resets all static state (cursor, testProject, dialogs) for a clean test run.

**Rule**: ALL method names follow reset pattern.
 - **Name**: `^reset$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static void reset()`

## add{Type}With{Assignment}

**Desc**: Creates a grammar element via {Language}Builder. If cursor is already at the target type, moves up to parent first.

**Rule**: SOME method names follow add{Type}With{Assignment} pattern.
 - **Name**: `^add{Type}With{Assignment}$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void addTestStepWithFullName(String stepName)`
 - `protected void addCellWithName(String name)`
 - `protected void addTestSuiteWithFullName(String testSuiteFullName)`

## assert{Type}{Assignment}

**Desc**: Queries model elements for assertion. Navigates to element if cursor is not already at the target type.

**Rule**: SOME method names follow assert{Type}{Assignment} pattern.
 - **Name**: `^assert{Type}{Assignment}$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String assertTestStepContainerName(String name)`
 - `protected String assertTestStepFullName(String fullName)`
 - `protected String assertCellName(String name)`

## set{Type}{Assignment}

**Desc**: Sets a value on the current cursor element.

**Rule**: SOME method names follow set{Type}{Assignment} pattern.
 - **Name**: `^set{Type}{Assignment}$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void setStepDefinitionName(String name)`
 - `protected void setTestSuiteName(String name)`

## get{Type}FromCursor

**Desc**: Extracts a grammar element from cursor by type-checking against grammar types that have the target assignment.

**Rule**: SOME method names follow get{Type}FromCursor pattern.
 - **Name**: `^get{Type}FromCursor$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected IDescription getDescriptionFromCursor()`
 - `protected ITable getTableFromCursor()`

## getDocumentFromNode

**Desc**: Walks up the grammar tree from any node to find the containing ITestDocument.

**Rule**: ALL method names follow getDocumentFromNode pattern.
 - **Name**: `^getDocumentFromNode$`
 - **Return**: `^Object$`
 - **Parameters**: `^\(Object\s+\w+\)$`
 - **Modifier**: `^protected\s+static$`

**Examples**:
 - `protected static Object getDocumentFromNode(Object node)`

## setCursorAtNode

**Desc**: Navigates cursor along a path string using element type names and 1-based indices.

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

## getFullNameFromPath

**Desc**: Extracts the document full name from the "object" property, stripping the base path prefix.

**Rule**: ALL method names follow getFullNameFromPath pattern.
 - **Name**: `^getFullNameFromPath$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String getFullNameFromPath()`

## listToString

**Desc**: Converts an ArrayList to a newline-separated string for assertion mapping.

**Rule**: ALL method names follow listToString pattern.
 - **Name**: `^listToString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(ArrayList<\?>\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String listToString(ArrayList<?> list)`
