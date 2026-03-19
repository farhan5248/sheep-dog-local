# {Type}Impl

**Directory**: `src/test/java/org/farhan/impl/ide`

**Implements**: I{Type}

## {Assignment}

**Desc**: Provides access to grammar attributes and child elements. Getters return package-private fields. Setters cast interface types to impl types and wire parent references.

**Rule**: ALL method names follow accessor patterns.
 - **Name**: `^(get|set|add|is){Assignment}$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getName()`
 - `public ITable getTable()`
 - `public List<ITestStepContainer> getTestStepContainerList()`
 - `public void setName(String value)`
 - `public void setTable(ITable value)`
 - `public void setDescription(IDescription value)`

## {Type}

**Desc**: Provides indexed and named access to child elements within collections, and adds children with impl casting and parent wiring.

**Rule**: SOME method names follow accessor patterns.
 - **Name**: `^(get|add){Type}$`
 - **Modifier**: `^public$`

**Examples**:
 - `public IStepDefinition getStepDefinition(int index)`
 - `public IStepDefinition getStepDefinition(String name)`
 - `public ITestDocument getTestDocument(int index)`
 - `public boolean addCell(ICell value)`
 - `public boolean addTestCase(ITestCase value)`
 - `public boolean addLine(ILine value)`

## FullName

**Desc**: Provides fully qualified name access. Some setFullName implementations parse the value to extract sub-fields.

**Rule**: SOME method names follow FullName pattern.
 - **Name**: `^(get|set)FullName$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getFullName()`
 - `public void setFullName(String value)`

## Parent

**Desc**: Returns the containing parent element for upward tree traversal.

**Rule**: SOME method names follow Parent pattern.
 - **Name**: `^getParent$`
 - **Modifier**: `^public$`

**Examples**:
 - `public IRow getParent()`
 - `public ITestStepContainer getParent()`
 - `public Object getParent()`

## Content

**Desc**: Provides access to raw file content for grammar elements backed by files.

**Rule**: SOME method names follow Content pattern.
 - **Name**: `^(get|set)Content$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getContent() throws Exception`
 - `public void setContent(String text) throws Exception`

## FileExtension

**Desc**: Returns the file extension for determining the grammar syntax.

**Rule**: SOME method names follow FileExtension pattern.
 - **Name**: `^getFileExtension$`
 - **Return**: `^String$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getFileExtension()`

## toString

**Desc**: Returns a string representation, typically the name or fullName field.

**Rule**: ALL method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
