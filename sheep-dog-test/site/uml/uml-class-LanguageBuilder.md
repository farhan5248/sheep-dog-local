# {Language}Builder

Static factory for creating and initializing grammar elements. Separates object construction and initialization logic from factory operations and grammar model definitions.

## create{Type}

**Desc**: Creates grammar element using factory, initializes attributes, establishes parent-child relationships, and handles singleton lookups where needed.

**Rule**: ALL method names follow create{Type} pattern.
 - **Name**: `^create{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\((I{Type}\s+parent(,\s*String\s+[a-z]\w*)?)?\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ICell createCell(IRow parent, String name)`
 - `public static IRow createRow(ITable parent)`
 - `public static IStatement createStatement(IStepDefinition parent, String name)`
 - `public static IStepDefinition createStepDefinition(IStepObject parent, String name)`
 - `public static IStepObject createStepObject(ITestProject parent, String fullName)`
 - `public static IStepParameters createStepParameters(IStepDefinition parent, String headers)`
 - `public static ITable createTable(IStepParameters parent)`
 - `public static IText createText(ITestStep parent, String name)`
 - `public static ITestCase createTestCase(ITestSuite parent, String name)`
 - `public static ITestSetup createTestSetup(ITestSuite parent, String name)`
 - `public static ITestStep createTestStep(ITestStepContainer parent, String name)`
 - `public static ITestSuite createTestSuite(ITestProject parent, String fullName)`
 - `public static ITestProject createTestProject()`
