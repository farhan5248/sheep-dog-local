# I{Type}

Grammar element interface contracts. Separates interface definitions from implementations, allowing multiple backends (EMF, POJO) for the same grammar model.

**Grammar-to-Interface Mapping**

| Grammar construct | Interface pattern |
|---|---|
| `name=Phrase` | `getName(): String` + `setName(String)` |
| `description=Description?` | `getDescription(): IDescription` + `setDescription(IDescription)` + `addLine(ILine): boolean` |
| `table=Table` | `getTable(): ITable` + `setTable(ITable)` |
| `xxxList+=Type*` | `getType(int): IType` + `getType(String): IType` + `getTypeList(): List<IType>` + `addType(IType): boolean` |
| parent-child relationship | `getParent(): IParentType` |

Note: `addLine()` is a convenience method — it auto-creates the Description if null, then appends the Line. All types with `description=Description?` should have it.

## {Assignment}

**Desc**: Provides access to grammar attributes and child elements using standard JavaBeans conventions.

**Rule**: SOME method names follow accessor patterns.
 - **Name**: `^(get|set|add|is){Assignment}$`

**Examples**:
 - `String getName()`
 - `void setName(String value)`
 - `List<ICell> getCellList()`

## {Type}

**Desc**: Provides indexed and named access to specific child elements within collections.

**Rule**: SOME method names follow accessor patterns.
 - **Name**: `^(get|add){Type}$`

**Examples**:
 - `ICell getCell(int index)`
 - `ICell getCell(String name)`
 - `boolean addCell(ICell value)`

## FullName

**Desc**: Provides fully qualified name for elements requiring unique workspace identification.

**Rule**: SOME method names include FullName.
 - **Name**: `^(get|set)FullName$`

**Examples**:
 - `String getFullName()` (in ITestDocument - with setter)
 - `String getFullName()` (in ITestStep - with setter, parses into stepObjectName + stepDefinitionName)
 - `String getFullName()` (in IStepDefinition - computed, no setter)

## Parent

**Desc**: Provides navigation to containing element for traversing the grammar tree upward.

**Rule**: SOME method names include Parent.
 - **Name**: `^getParent$`

**Examples**:
 - `IRow getParent()`

## Content

**Desc**: Provides access to the raw file content for grammar elements backed by files.

**Rule**: SOME method names include get or set Content.
 - **Name**: `^(get|set)Content$`

**Examples**:
 - `String getContent()`

## FileExtension

**Desc**: Returns the file extension for determining the grammar syntax (asciidoc vs feature).

**Rule**: SOME method names include getting the file extension.
 - **Name**: `^getFileExtension$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`

**Examples**:
 - `String getFileExtension()`
