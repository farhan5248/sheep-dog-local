# I{Language}Factory

Interface for creating language-specific grammar elements. Defines parameterless create{Type}() methods that return empty instances.

## ALL method names follow create{Type} pattern

Factory interface methods create empty instances of grammar types. Return type I{Type} must match method name create{Type}(). Methods are parameterless and return interface types. The {Language}Builder is responsible for setting attributes and adding instances to parent containers.

**Regex**: `^I{Type}\s+create{Type}\(\)$`
 - `IStepDefinition createStepDefinition()`
 - `IStepObject createStepObject()`
 - `IStepParameters createStepParameters()`
 - `ITestCase createTestCase()`
 - `ITestProject createTestProject()`
 - `ITestSetup createTestSetup()`
 - `ITestStep createTestStep()`
 - `ITestSuite createTestSuite()`
 - `IStatement createStatement()`
 - `ITable createTable()`
 - `IRow createRow()`
 - `ICell createCell()`
