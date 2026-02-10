# {Language}Utility

Static helper methods for grammar element operations. Separates utility operations from grammar model classes, keeping interfaces focused on data access.

## get{Assignment}AsString

**Desc**: Converts a list of grammar elements into a formatted string representation for display or comparison purposes.

**Rule**: SOME method names follow get{Assignment}AsString pattern.
 - **Name**: `^get{Assignment}AsString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(List<I{Type}>\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getCellListAsString(List<ICell> list)`

## get{Type}NameLong(For{Type})?

**Desc**: Constructs fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements.

**Rule**: SOME method names follow get{Type}NameLong or get{Type}NameLongFor{Type} pattern.
 - **Name**: `^get{Type}NameLong(For{Type})?$`
 - **Return**: `^String$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getStepObjectNameLongForTestStep(ITestStep theStep)`
 - `public static String getTestStepNameLong(ITestStep theStep)`
