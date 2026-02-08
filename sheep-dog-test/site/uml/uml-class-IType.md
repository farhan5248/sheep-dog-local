# I{Type}

## {Assignment}

All methods in I{Type} interfaces must follow standard accessor naming conventions: getters start with 'get', setters start with 'set', and adders start with 'add'.

**Rule**: ALL method names follow accessor patterns

**Regex**: `^(get|set|add|is){Assignment}$`
 - `String getName()`
 - `void setName(String value)`
 - `ICell getCell(int index)`
 - `ICell getCell(String name)`
 - `List<ICell> getCellList()`
 - `boolean addCell(ICell value)`
 - `IRow getParent()`
 - `String getNameLong()`

## getNameLong

Methods that return qualified or full path names use 'NameLong' suffix.

**Rule**: SOME method names include NameLong

**Regex**: `^getNameLong$`
 - `String getNameLong()` (in IModel - with setter)
 - `String getNameLong()` (in ITestStep - computed, no setter)
 - `String getNameLong()` (in IStepDefinition - computed, no setter)
