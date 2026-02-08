# I{Type}

## {Assignment}

**Desc**: All methods in I{Type} interfaces must follow standard accessor naming conventions: getters start with 'get', setters start with 'set', and adders start with 'add'.

**Rule**: SOME method names follow accessor patterns.
 - **Name**: `^(get|set|add|is){Assignment}$`

**Examples**:
 - `String getName()`
 - `void setName(String value)`
 - `List<ICell> getCellList()`

## {Type}

**Desc**: Assignments that have children have individual getters for that type

**Rule**: SOME method names follow accessor patterns.
 - **Name**: `^(get|add){Type}$`

**Examples**:
 - `ICell getCell(int index)`
 - `ICell getCell(String name)`
 - `boolean addCell(ICell value)`

## NameLong

**Desc**: Methods that return qualified or full path names use 'NameLong' suffix.

**Rule**: SOME method names include NameLong.
 - **Name**: `^(get|set)NameLong$`

**Examples**:
 - `String getNameLong()` (in IModel - with setter)
 - `String getNameLong()` (in ITestStep - computed, no setter)
 - `String getNameLong()` (in IStepDefinition - computed, no setter)

## Parent

**Desc**: Methods that return the enclosing type

**Rule**: SOME method names include Parent.
 - **Name**: `^getParent$`

**Examples**:
 - `IRow getParent()`

## Content

**Desc**: Methods that return the file contents

**Rule**: SOME method names include get or set Content.
 - **Name**: `^(get|set)Content$`

**Examples**:
 - `String getContent()`

## FileExtension

**Desc**: Returns the project file extension like asciidoc or feature

**Rule**: SOME method names include getting the file extension.
 - **Name**: `^getFileExtension$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`

**Examples**:
 - `String getFileExtension()`
