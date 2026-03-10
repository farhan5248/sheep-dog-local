# TestObject

Project-independent base class for test automation. Provides centralized assertion dispatch via reflection, input/output processing for DataTable, DocString, and State formats, and common utilities shared across all projects.

## processInputOutputs (DataTable)

**Desc**: Dispatches DataTable rows to get/set methods via reflection. For get operations, performs centralized assertions comparing expected values against actual return values. State fields use Absent/Empty/Present mapping. Skips assertion for Node Path and Tag List fields.

**Rule**: ALL method names follow processInputOutputs pattern.
 - **Name**: `^processInputOutputs$`
 - **Return**: `^void$`
 - **Parameters**: `^\(DataTable\s+\w+,\s*String\s+\w+,\s*String\s+\w+,\s*boolean\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void processInputOutputs(DataTable dataTable, String operation, String sectionName, boolean negativeTest)`

## processInputOutputs (Single value)

**Desc**: Dispatches single key-value pairs to get/set methods via reflection. For get operations, value="true" triggers assertNotNull, non-empty values trigger assertEquals.

**Rule**: ALL method names follow processInputOutputs pattern.
 - **Name**: `^processInputOutputs$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+,\s*String\s+\w+,\s*String\s+\w+,\s*boolean\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void processInputOutputs(String key, String value, String operation, String sectionName, boolean negativeTest)`

## assertInputOutputs{Format}

**Desc**: Public entry points that delegate to processInputOutputs with operation="get". Overloads support optional sectionName and negativeTest parameters.

**Rule**: ALL method names follow assertInputOutputs pattern.
 - **Name**: `^assertInputOutputs(DataTable|DocString|State)$`
 - **Return**: `^void$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void assertInputOutputsDataTable(DataTable dataTable)`
 - `public void assertInputOutputsDataTable(DataTable dataTable, String sectionName)`
 - `public void assertInputOutputsDataTable(DataTable dataTable, String sectionName, boolean negativeTest)`
 - `public void assertInputOutputsDocString(String key, String value)`
 - `public void assertInputOutputsState(String key)`
 - `public void assertInputOutputsState(String key, boolean negativeTest)`
 - `public void assertInputOutputsState(String key, String sectionName)`

## setInputOutputs{Format}

**Desc**: Public entry points that delegate to processInputOutputs with operation="set". Overloads support optional sectionName and negativeTest parameters.

**Rule**: ALL method names follow setInputOutputs pattern.
 - **Name**: `^setInputOutputs(DataTable|DocString|State)$`
 - **Return**: `^void$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setInputOutputsDataTable(DataTable dataTable)`
 - `public void setInputOutputsDataTable(DataTable dataTable, String sectionName)`
 - `public void setInputOutputsDocString(String key, String value)`
 - `public void setInputOutputsState(String key)`
 - `public void setInputOutputsState(String key, String sectionName)`

## listToString

**Desc**: Converts a List to its string representation with null/empty/present semantics: null returns null (Absent), empty list returns "" (Empty), non-empty returns toString() (Present).

**Rule**: ALL method names follow listToString pattern.
 - **Name**: `^listToString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(List<\?>\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String listToString(List<?> list)`

## convertToPascalCase

**Desc**: Converts a space/hyphen/parenthesis/slash-separated string to PascalCase for reflective method name construction.

**Rule**: ALL method names follow convertToPascalCase pattern.
 - **Name**: `^convertToPascalCase$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^private$`

**Examples**:
 - `private String convertToPascalCase(String s)`

## replaceKeyword

**Desc**: Replaces keyword placeholders in expected values. Currently maps "empty" to empty string.

**Rule**: ALL method names follow replaceKeyword pattern.
 - **Name**: `^replaceKeyword$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected String replaceKeyword(String value)`

## transition

**Desc**: Empty default implementation. Overridden by TestObject{Language} to navigate cursor based on properties.

**Rule**: ALL method names follow transition pattern.
 - **Name**: `^transition$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void transition()`

## injector

**Desc**: Guice injector for resolving impl class bindings via reflection.

**Rule**: ALL attribute names follow injector pattern.
 - **Name**: `^injector$`

**Examples**:
 - `protected static Injector injector`

## properties

**Desc**: Key-value store for step parameters such as component, path, and part.

**Rule**: ALL attribute names follow properties pattern.
 - **Name**: `^properties$`

**Examples**:
 - `protected HashMap<String, Object> properties = new HashMap<String, Object>()`
