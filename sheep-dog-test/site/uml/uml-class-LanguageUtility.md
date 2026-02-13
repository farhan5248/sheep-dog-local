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

## get{Type}NameLongFor{Type}

**Desc**: Constructs fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements.

**Rule**: SOME method names follow get{Type}NameLong or get{Type}NameLongFor{Type} pattern.
 - **Name**: `^get{Type}NameLong(For{Type})?$`
 - **Return**: `^String$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getStepObjectNameLongForTestStep(ITestStep theStep)`
 - `public static String getTestStepNameLong(ITestStep theStep)`

## get{Type}ParentFor{Type}

**Desc**: Gets the grand parent or great grand parent etc for a type. The most common usage is getting TestProject from TestStep

**Rule**: SOME method names follow get{Type}Parent or get{Type}ParentFor{Type} pattern.
 - **Name**: `^get{Type}Parent(For{Type})?$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ITestProject getTestProjectParentForTestStep(ITestStep theStep)`
 - `public static ITestProject getTestProjectParentForRow(IRow theRow)`
 - `public static ITestProject getTestProjectParentForText(IText theText)`

## get{Assignment}UpTo{Type}

**Desc**: Gets a list of elements up to (but not including) the specified element. Returns elements in reverse chronological order (most recent first) for context inference.

**Rule**: SOME method names follow get{Assignment}UpTo{Type} pattern.
 - **Name**: `^get{Assignment}UpTo{Type}$`
 - **Return**: `^ArrayList<I{Type}>$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<ITestStep> getTestStepListUpToTestStep(ITestStep theTestStep)`
 - Future: `public static ArrayList<ITestStepContainer> getTestStepContainerListUpToTestCase(ITestCase theTestCase)`
