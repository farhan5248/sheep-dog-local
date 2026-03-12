# {Type}Impl

**Extends**: I{Type}

## get{Assignment}

**Desc**: Returns the value of a package-private field. Implements I{Type} getter contract.

**Rule**: ALL method names follow get{Assignment} pattern.
 - **Name**: `^get{Assignment}$`
 - **Return**: `^(String|I{Type}|List<I{Type}>)$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getName()`
 - `public IRow getParent()`
 - `public ITable getTable()`
 - `public List<ITestStepContainer> getTestStepContainerList()`

## set{Assignment}

**Desc**: Sets a package-private field. Casts interface types to impl types and wires parent reference.

**Rule**: ALL method names follow set{Assignment} pattern.
 - **Name**: `^set{Assignment}$`
 - **Return**: `^void$`
 - **Parameters**: `^(String|I{Type})$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setName(String value)`
 - `public void setFullName(String value)`
 - `public void setTable(ITable value)`
 - `public void setDescription(IDescription value)`

## add{Type}

**Desc**: Adds a child element to the parent's collection. Casts to impl type, adds to list, and wires parent reference.

**Rule**: SOME method names follow add{Type} pattern.
 - **Name**: `^add{Type}$`
 - **Return**: `^boolean$`
 - **Parameters**: `^I{Type}$`
 - **Modifier**: `^public$`

**Examples**:
 - `public boolean addCell(ICell value)`
 - `public boolean addTestCase(ITestCase value)`
 - `public boolean addLine(ILine value)`

## toString

**Desc**: Returns a string representation, typically the name or fullName field.

**Rule**: ALL method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
