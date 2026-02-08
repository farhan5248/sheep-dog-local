# {Language}Builder

Static factory class for creating and initializing grammar elements. Builder methods create instances via {Language}Factory, set attributes, and add to parent collections.

## create{Type}

Builder methods are static factory methods that create instances of grammar types. Return type I{Type} must match method name create{Type}(). Most methods accept a parent interface as first parameter and additional initialization parameters.

**Rule**: ALL method names follow create{Type} pattern

**Regex**: `^public\s+static\s+I{Type}\s+create{Type}\((I{Type}\s+parent(,\s*String\s+[a-z]\w*)?)?\)$`
 - `public static ICell createCell(IRow parent, String name)`
 - `public static IRow createRow(ITable parent)`
 - `public static IStatement createStatement(IStepDefinition parent, String name)`
 - `public static IStepDefinition createStepDefinition(IStepObject parent, String name)`
 - `public static IStepObject createStepObject(ITestProject parent, String qualifiedName)`
 - `public static IStepParameters createStepParameters(IStepDefinition parent, String headers)`
 - `public static ITable createTable(IStepParameters parent)`
 - `public static IText createText(ITestStep parent, String name)`
 - `public static ITestCase createTestCase(ITestSuite parent, String name)`
 - `public static ITestSetup createTestSetup(ITestSuite parent, String name)`
 - `public static ITestStep createTestStep(ITestStepContainer parent, String name)`
 - `public static ITestSuite createTestSuite(ITestProject parent, String qualifiedName)`
 - `public static ITestProject createTestProject()`
