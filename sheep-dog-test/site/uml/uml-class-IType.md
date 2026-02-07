# I{Type}

## (get|set|add)[A-Z][a-zA-Z0-9]*

All methods in I{Type} interfaces must follow standard accessor naming conventions: getters start with 'get', setters start with 'set', and adders start with 'add'.

**Rule**: ALL method names follow accessor patterns

**Regex**: `^(get|set|add)[A-Z][a-zA-Z0-9]*$`
 - `String getName()`
 - `void setName(String value)`
 - `ICell getCell(int index)`
 - `ICell getCell(String name)`
 - `List<ICell> getCellList()`
 - `boolean addCell(ICell value)`
 - `IRow getParent()`
 - `String getNameLong()`

## I.*(Test|Step)[A-Z][a-zA-Z0-9]*

Interfaces for test-related or step-related types include 'Test' or 'Step' in their name.

**Rule**: SOME interface names include Test or Step

**Regex**: `^I.*(Test|Step)[A-Z][a-zA-Z0-9]*$`
 - `ITestProject`
 - `ITestSuite`
 - `ITestCase`
 - `ITestSetup`
 - `ITestData`
 - `ITestStepContainer`
 - `ITestStep`
 - `IStepObject`
 - `IStepDefinition`
 - `IStepParameters`

## getNameLong

Methods that return qualified or full path names use 'NameLong' suffix.

**Rule**: SOME method names include NameLong

**Regex**: `^getNameLong$`
 - `String getNameLong()` (in IModel - with setter)
 - `String getNameLong()` (in ITestStep - computed, no setter)
 - `String getNameLong()` (in IStepDefinition - computed, no setter)
