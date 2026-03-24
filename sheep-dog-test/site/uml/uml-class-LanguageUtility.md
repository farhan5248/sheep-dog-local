# {Language}Utility

**Directory**: `src/main/java/org/farhan/dsl/grammar`

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

## get{Type}FullNameFor{Type}

**Desc**: Constructs fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements.

**Rule**: SOME method names follow get{Type}FullName or get{Type}FullNameFor{Type} pattern.
 - **Name**: `^get{Type}FullName(For{Type})?$`
 - **Return**: `^String$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getStepObjectFullNameForTestStep(ITestStep theStep)`
 - `public static String getTestStepFullName(ITestStep theStep)`

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

## get{Type}List

**Desc**: Filters a parent collection by type, returning only elements matching the target grammar type.

**Rule**: SOME method names follow get{Type}List pattern.
 - **Name**: `^get{Type}List$`
 - **Return**: `^List<I{Type}>$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static List<ITestSuite> getTestSuiteList(ITestProject project)`

## getParent

**Desc**: Gets the parent container of any grammar node. Consolidates typed getParent() calls into a single dispatch point for EMF cutover preparation.

**Rule**: ONE method named getParent.
 - **Name**: `^getParent$`
 - **Return**: `^Object$`
 - **Parameters**: `^\(Object\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static Object getParent(Object node)`

## getAncestor

**Desc**: Walks up the parent chain to find the nearest ancestor of the given type.

**Rule**: ONE method named getAncestor.
 - **Name**: `^getAncestor$`

**Examples**:
 - `public static <T> T getAncestor(Object node, Class<T> type)`

## addSorted

**Desc**: Inserts an element into a sorted list at the correct position using binary search.

**Rule**: ONE method named addSorted.
 - **Name**: `^addSorted$`

**Examples**:
 - `public static <T> void addSorted(List<T> list, T element, java.util.function.Function<T, String> nameExtractor)`

## get{Type}

**Desc**: Looks up a child element by name from a parent's list. Replaces the get(String name) methods on interfaces, preparing for EMF cutover where interfaces only expose getXxxList().

**Rule**: SOME method names follow get{Type} pattern with a parent and name parameter.
 - **Name**: `^get{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(I{Type}\s+\w+,\s+String\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ICell getCell(IRow row, String name)`
 - `public static ILine getLine(IDescription description, String content)`
 - `public static IStepDefinition getStepDefinition(IStepObject stepObject, String name)`
 - `public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String name)`
 - `public static ITestStepContainer getTestStepContainer(ITestSuite testSuite, String name)`
 - `public static ITestStep getTestStep(ITestStepContainer container, String name)`
 - `public static ITestData getTestData(ITestCase testCase, String name)`

## clone{Type}

**Desc**: Creates deep clones of grammar elements to avoid side effects during operations like proposal generation. Clones are created without parent associations to prevent modification of the original element tree.

**Rule**: SOME method names follow clone{Type} pattern.
 - **Name**: `^clone{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(I{Type}\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static IStepObject cloneStepObject(IStepObject original)`
