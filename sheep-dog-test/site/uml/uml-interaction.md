# UML Interaction Patterns

**References**

1. `sheep-dog-main/site/impl/impl-logging.md` - SLF4J logging patterns
2. `sheep-dog-main/site/impl/impl-xtext-logging.md` - Xtext logging patterns

## All

These patterns define which classes have loggers and which operations should be logged.

### Entry/Exit Logging Pattern

All public methods in Utility, Detector, Resolver, and Builder classes MUST have entry and exit logging.

**Rules**
- Entry log is the first statement in each public method and includes method parameters
- Exit log is placed before each return statement and includes the return value

### No Logger Pattern

Interfaces, and factory classes do not declare loggers to keep them lightweight and focused on their single responsibility.

**Examples**

- I{Type} interfaces have no logger
- {Language}Factory has no logger

### File Operation Logging Pattern

Classes that read or write files through IResourceRepository log these I/O operations for debugging and troubleshooting.

**Examples**

```java
logger.debug("Reading file: {}", path);
repository.get(path);
```

```java
logger.debug("Writing file: {}", path);
repository.put(path, content);
```

### Exception Propagation Pattern

Methods declare throws Exception in signatures and allow all exceptions to propagate naturally without try-catch blocks.

**Examples**

- Method signatures:
```java
public void getContent() throws Exception {
    // Implementation that may throw
}
```

```java
public void setContent(String content) throws Exception {
    // Implementation that may throw
}
```

- Interface methods:
```java
public interface IResourceRepository {
    Object get(String path) throws Exception;
    void put(String path, Object content) throws Exception;
}
```

### No Exception Handling Pattern

No try-catch blocks, custom exceptions, RuntimeException usage, null returns for errors, or graceful degradation. All errors propagate immediately.

## {Language}Factory

### instance

The factory holds a static reference to the concrete factory implementation. This allows the builder and other classes to create grammar elements through a single access point.

**Example: Accessing the factory to create elements**
```java
public class SheepDogFactory {
    public static ISheepDogFactory instance;
}

// Usage in SheepDogBuilder
ICell cell = SheepDogFactory.instance.createCell();
IRow row = SheepDogFactory.instance.createRow();
```

## {Type}IssueTypes

### {TYPE}{ASSIGNMENT}{SCOPE}

Enum constants define validation issue types using a structured naming pattern. Each constant represents a specific validation error with an ID and description message.

**Example: Defining validation issue types**
```java
public enum TestStepIssueTypes {
    TEST_STEP_STEP_OBJECT_NAME_ONLY("TEST_STEP_STEP_OBJECT_NAME_ONLY",
        "Every test step must have the object specified..."),

    TEST_STEP_STEP_DEFINITION_NAME_ONLY("TEST_STEP_STEP_DEFINITION_NAME_ONLY",
        "After specifying the step object name, a step definition name is specified..."),

    TEST_STEP_STEP_OBJECT_NAME_WORKSPACE("TEST_STEP_STEP_OBJECT_NAME_WORKSPACE",
        "The step object file doesn't exist for the component"),

    TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE("TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE",
        "The step definition doesn't exist for the step object");

    public final String id;
    public final String description;

    TestStepIssueTypes(String value, String description) {
        this.id = value;
        this.description = description;
    }
}
```

**Example: Using issue types in validation**
```java
public static String validateStepObjectNameOnly(ITestStep theTestStep) {
    if (TestStepUtility.getStepObjectName(text).isEmpty()) {
        return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
    }
    return "";
}
```

## {Type}IssueDetector

### validate{Assignment}{Scope}

Detector methods validate grammar assignments at different scopes: Only (element-level), File (file-level), or Workspace (cross-file).

**Example: Element-level validation (Only)**
```java
public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
    // entry/exit logging omitted
    String text = theTestStep.getStepObjectName();
    if (text != null) {
        if (!TestStepUtility.isValid(text)) {
            if (TestStepUtility.getStepObjectName(text).isEmpty()) {
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
        }
    }
    return "";
}
```

**Example: Cross-file validation (Workspace)**
```java
public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
    // entry/exit logging omitted
    String message = "";
    String fullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
    IStepObject theStepObject = theTestStep.getParent().getParent().getParent()
            .getStepObject(fullName);
    if (theStepObject == null) {
        message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
    }
    return message;
}
```

## {Language}Builder

### create{Type}

Builder methods create instances via the factory, set attributes, and add to parent collections. They handle both creation and initialization.

**Example: Simple creation with parent**
```java
public static ICell createCell(IRow parent, String name) {
    // entry/exit logging omitted
    ICell cell = SheepDogFactory.instance.createCell();
    cell.setName(name);
    if (parent != null)
        parent.addCell(cell);
    return cell;
}
```

**Example: Creation with deduplication**
```java
public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
    // entry/exit logging omitted
    IStepDefinition stepDefinition = null;
    if (parent != null)
        stepDefinition = parent.getStepDefinition(name);
    if (stepDefinition == null) {
        stepDefinition = SheepDogFactory.instance.createStepDefinition();
        stepDefinition.setName(name);
        if (parent != null)
            parent.addStepDefinition(stepDefinition);
    }
    return stepDefinition;
}
```

## {Language}LoggerFactory

### getLogger

Gets a logger for the specified class. Uses SLF4J when available, otherwise delegates to custom {Language}LoggerProvider.

**Example: Method body**
```java
public static Logger getLogger(Class<?> clazz) {
    if (org.slf4j.LoggerFactory.getILoggerFactory() instanceof org.slf4j.helpers.NOPLoggerFactory) {
        if (provider != null) {
            return provider.getLogger(clazz);
        }
    }
    return org.slf4j.LoggerFactory.getLogger(clazz);
}
```

**Example: Standard usage**
```java
private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);
```

### setLoggerImplementation

Configures a custom logger provider when SLF4J is unavailable (e.g., in Eclipse/OSGi environments).

**Example: Setting custom logger**
```java
// In Eclipse plugin activator
SheepDogLoggerFactory.setLoggerImplementation(new LoggerProvider() {
    @Override
    public Logger getLogger(Class<?> clazz) {
        return new EclipseLogger(clazz);
    }
});
```

## {Language}Utility

### get{Type}FullNameFor{Type}

Utility methods construct fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements. These methods navigate the parent hierarchy and apply domain-specific formatting rules.

**Example: Getting step object full name**
```java
public static String getStepObjectFullNameForTestStep(ITestStep theStep) {
    // entry/exit logging omitted
    if (theStep != null) {
        String stepFullName = SheepDogUtility.getTestStepFullName(theStep);
        if (stepFullName != null && !stepFullName.isEmpty()) {
            String component = StepObjectRefFragments.getComponent(stepFullName);
            String object = StepObjectRefFragments.getObject(stepFullName);
            if (!component.isEmpty() && !object.isEmpty()) {
                ITestProject project = getTestProjectParentForTestStep(theStep);
                if (project != null) {
                    String fileExt = project.getFileExtension();
                    if (fileExt != null && !fileExt.isEmpty()) {
                        return component + "/" + object + fileExt;
                    }
                }
            }
        }
    }
    return "";
}
```

**Example: Getting test step full name with context inference**

When component or object is missing from the current step, infer from previous steps by iterating `getPreviousSteps(theStep)` and matching via `StepObjectRefFragments`. Returns `"The " + component + " " + object + " " + stepDefinitionName`.

```java
public static String getTestStepFullName(ITestStep theStep) {
    // entry/exit logging omitted
    String component = StepObjectRefFragments.getComponent(theStep.getStepObjectName());
    String object = StepObjectRefFragments.getObject(theStep.getStepObjectName());
    if (component.isEmpty() || !object.contains("/")) {
        // Iterate getPreviousSteps(theStep) to infer missing component/object
        // Falls back to "Unknown service" if no component found
    }
    return "The " + component + " " + object + " " + theStep.getStepDefinitionName();
}
```

### clone{Type}

Utility methods create deep clones of grammar elements to avoid side effects during operations like proposal generation. Clones are created without parent associations to prevent modification of the original element tree.

**Example: Cloning a step object**
```java
public static IStepObject cloneStepObject(IStepObject original) {
    // entry/exit logging omitted
    IStepObject clone = SheepDogBuilder.createStepObject(null, original.getFullName());
    if (original.getDescription() != null) {
        for (ILine line : original.getDescription().getLineList()) {
            SheepDogBuilder.createLine(clone, line.getName());
        }
    }
    // Recursively clone stepDefinitions, stepParameters, tables, rows, cells
    // using SheepDogBuilder.create{Type}() for each child element
    return clone;
}
```

**Key Principles:**
- Always clone before modification to avoid unintended side effects
- Create clone with null parent to prevent adding to original tree
- Recursively clone all child elements using SheepDogBuilder for consistency

## {Type}Fragments

### getAll

Extracts the complete matched text from formatted input, returning the entire reference as a single string for full pattern validation or processing.

**Example: Getting full title match**
```java
public static String getAll(String text) {
    return getGroup(TitleFragments.TITLE, text, 0);
}
```

### get{Fragment}

Extracts a specific named fragment from formatted text using predefined regex patterns and group positions. Each getter targets a specific capture group in the composed pattern.

**Example: Extracting a named fragment**

All `get{Fragment}` methods follow this pattern — call `getGroup` with a regex pattern, input text, and capture group index:

```java
public class StepObjectRefFragments {

    private static final String COMPONENT_NAME = "( " + "[^/]" + "+)";
    private static final String COMPONENT_TYPE = getRegexFromTypes(StepObjectRefComponentTypes.values());
    private static final String COMPONENT = "(" + COMPONENT_NAME + COMPONENT_TYPE + ")";

    public static String getComponentType(String text) {
        return getGroup("^(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 4);
    }

    private static String getGroup(String regex, String text, int group) {
        Matcher m = Pattern.compile(regex).matcher(text);
        if (m.find()) {
            String temp = m.group(group);
            if (temp != null) {
                return temp.trim();
            } else {
                return "";
            }
        }
        return "";
    }    

    private static String getRegexFromTypes(Enum<?>[] enumValues) {
        String regex = "(";
        for (Enum<?> enumValue : enumValues) {
            if (enumValue instanceof StepObjectRefComponentTypes) {
                regex += " " + ((StepObjectRefComponentTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectEdgeTypes) {
                regex += " " + ((StepObjectRefObjectEdgeTypes) enumValue).value + "|";
            } else if (enumValue instanceof StepObjectRefObjectVertexTypes) {
                regex += " " + ((StepObjectRefObjectVertexTypes) enumValue).value + "|";
            }
        }
        return regex.replaceAll("\\|$", ")");
    }    
}
```

### get{Fragment}AsList

Specialized methods parse text into collections of structured data, applying domain-specific logic during iteration.

**Example: Extracting tags as list**
```java
public static ArrayList<String> getTagAsList(String name) {
    ArrayList<String> tags = new ArrayList<String>();
    for (String word : name.split(" ")) {
        if (isTag(word)) {
            tags.add(getTagDesc(word));
        }
    }
    return tags;
}
```

## {Type}{Fragment}Types

### {FRAGMENT}

Enum constants follow UPPER_SNAKE_CASE naming and represent keywords or patterns used in test step matching.

**Example: Defining fragment types**
```java
public enum StepObjectRefComponentTypes {
    APPLICATION("application", "GUI web application");

    public final String value;
    public final String description;

    StepObjectRefComponentTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
```

**Example: Using fragments in regex matching**
```java
// Match component type in test step
String stepText = "The customer application";
for (StepObjectRefComponentTypes component : StepObjectRefComponentTypes.values()) {
    if (stepText.contains(component.value)) {
        // Found component type
        return component;
    }
}
```

## TestObject

### processInputOutputs (DataTable)

Reflection-based dispatch that converts DataTable rows into method calls on impl classes. For get operations, performs centralized assertions. State fields use Absent/Empty/Present mapping.

**Example: DataTable dispatch with State mapping**
```java
protected void processInputOutputs(DataTable dataTable, String operation, String sectionName, boolean negativeTest) {
    List<List<String>> data = dataTable.asLists();
    ArrayList<String> headers = new ArrayList<String>();
    for (String cell : data.get(0)) {
        headers.add(cell);
    }
    for (int i = 1; i < data.size(); i++) {
        HashMap<String, String> row = new HashMap<String, String>();
        for (int j = 0; j < headers.size(); j++) {
            row.put(headers.get(j), data.get(i).get(j));
        }
        for (String fieldName : headers) {
            Object returnValue = this.getClass().getMethod(operation + convertToPascalCase(sectionName)
                    + convertToPascalCase(fieldName), HashMap.class).invoke(this, row);
            if (operation.equals("get") && !fieldName.contains("Node Path") && !fieldName.equals("Tag List")) {
                String expected = replaceKeyword(row.get(fieldName));
                String actual = returnValue == null ? null : returnValue.toString();
                if (fieldName.equals("State")) {
                    String mappedActual;
                    if (actual == null) mappedActual = "Absent";
                    else if (actual.isEmpty()) mappedActual = "Empty";
                    else mappedActual = "Present";
                    Assertions.assertEquals(expected, mappedActual);
                } else {
                    Assertions.assertEquals(expected, actual);
                }
            }
        }
    }
}
```

### processInputOutputs (Single value)

Dispatches single key-value pairs to get/set methods via reflection.

**Example: Single value dispatch**
```java
protected void processInputOutputs(String key, String value, String operation, String sectionName, boolean negativeTest) {
    HashMap<String, String> row = new HashMap<String, String>();
    row.put(key, value);
    Object returnValue = this.getClass().getMethod(
            operation + convertToPascalCase(sectionName) + convertToPascalCase(key),
            HashMap.class).invoke(this, row);
    if (operation.equals("get")) {
        String actual = returnValue == null ? null : returnValue.toString();
        if (value.equals("true")) {
            Assertions.assertNotNull(actual);
        } else if (!value.isEmpty()) {
            Assertions.assertEquals(replaceKeyword(value), actual);
        }
    }
}
```

### assertInputOutputs{Format}

Public entry points that delegate to processInputOutputs with operation="get".

**Example: assertInputOutputsDataTable**
```java
public void assertInputOutputsDataTable(DataTable dataTable) {
    processInputOutputs(dataTable, "get", "", false);
}
```

**Example: assertInputOutputsState**
```java
public void assertInputOutputsState(String key) {
    processInputOutputs(key, "true", "get", "", false);
}
```

**Example: assertInputOutputsDocString**
```java
public void assertInputOutputsDocString(String key, String value) {
    processInputOutputs(key, value, "get", "", false);
}
```

### setInputOutputs{Format}

Public entry points that delegate to processInputOutputs with operation="set".

**Example: setInputOutputsDataTable**
```java
public void setInputOutputsDataTable(DataTable dataTable) {
    processInputOutputs(dataTable, "set", "", false);
}
```

**Example: setInputOutputsState**
```java
public void setInputOutputsState(String key) {
    processInputOutputs(key, "true", "set", "", false);
}
```

**Example: setInputOutputsDocString**
```java
public void setInputOutputsDocString(String key, String value) {
    processInputOutputs(key, value, "set", "", false);
}
```

### listToString

Converts a List to a string with null/empty/present semantics for assertion mapping.

**Example: listToString implementation**
```java
protected String listToString(List<?> list) {
    if (list == null) return null;
    if (list.isEmpty()) return "";
    return list.toString();
}
```

### convertToPascalCase

Converts a separated string to PascalCase for reflective method name construction.

**Example: convertToPascalCase implementation**
```java
private String convertToPascalCase(String s) {
    StringBuilder result = new StringBuilder();
    for (String word : s.split("[ \\-\\(\\)/]+")) {
        if (!word.isEmpty()) {
            result.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                result.append(word.substring(1));
            }
        }
    }
    return result.toString();
}
```

### replaceKeyword

Replaces keyword placeholders in expected values.

**Example: replaceKeyword implementation**
```java
protected String replaceKeyword(String value) {
    if (value.contentEquals("empty")) {
        return "";
    } else {
        return value;
    }
}
```

### transition

Empty default implementation, overridden by TestObject{Language}.

**Example: Default transition**
```java
public void transition() {
}
```

## TestObject{Language}

### reset

Resets all static state for a clean test run.

**Example: reset implementation**
```java
public static void reset() {
    testProject = SheepDogBuilder.createTestProject();
    cursor = testProject;
    validateDialog = "";
    listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
    listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
}
```

### add{Type}With{Assignment}

Creates grammar elements with auto-navigation: if cursor is already at the target type, moves up to parent first.

**Example: Creating a test step**
```java
protected void addTestStepWithFullName(String stepName) {
    if (cursor instanceof ITestStep) {
        cursor = ((ITestStep) cursor).getParent();
    }
    cursor = SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepName);
}
```

**Example: Creating a cell**
```java
protected void addCellWithName(String name) {
    if (cursor instanceof ICell) {
        cursor = ((ICell) cursor).getParent();
    }
    cursor = SheepDogBuilder.createCell((IRow) cursor, name);
}
```

### assert{Type}{Assignment}

Queries model elements, navigating to them if needed. Returns the value or null if not found.

**Example: Asserting with navigation**
```java
protected String assertTestStepContainerName(String name) {
    if (cursor instanceof ITestStepContainer) {
        return ((ITestStepContainer) cursor).getName();
    } else {
        cursor = ((ITestSuite) cursor).getTestStepContainer(name);
        return cursor == null ? null : ((ITestStepContainer) cursor).getName();
    }
}
```

**Example: Asserting without navigation**
```java
protected String assertTestStepFullName(String fullName) {
    return ((ITestStep) cursor).getFullName();
}
```

### transition

Navigates cursor to a test document based on property values.

**Example: transition implementation**
```java
public void transition() {
    if (properties.get("Test Suite Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
        properties.remove("Test Suite Full Name");
    } else if (properties.get("Step Object Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Step Object Full Name").toString()));
        properties.remove("Step Object Full Name");
    }
}
```

### getDescriptionFromCursor

Extracts IDescription from cursor by type-checking against grammar types with description assignments.

**Example: getDescriptionFromCursor implementation**
```java
protected IDescription getDescriptionFromCursor() {
    if (cursor instanceof ITestSuite) return ((ITestSuite) cursor).getDescription();
    else if (cursor instanceof ITestStepContainer) return ((ITestStepContainer) cursor).getDescription();
    else if (cursor instanceof IStepObject) return ((IStepObject) cursor).getDescription();
    else if (cursor instanceof IStepDefinition) return ((IStepDefinition) cursor).getDescription();
    else if (cursor instanceof IStepParameters) return ((IStepParameters) cursor).getDescription();
    else if (cursor instanceof ITestData) return ((ITestData) cursor).getDescription();
    return null;
}
```

### getTableFromCursor

Extracts ITable from cursor by type-checking against grammar types with table assignments.

**Example: getTableFromCursor implementation**
```java
protected ITable getTableFromCursor() {
    if (cursor instanceof IStepParameters) return ((IStepParameters) cursor).getTable();
    else if (cursor instanceof ITestData) return ((ITestData) cursor).getTable();
    else if (cursor instanceof ITestStep) return ((ITestStep) cursor).getTable();
    return null;
}
```

### getDocumentFromNode

Walks up the grammar tree from any node to find the containing ITestDocument.

**Example: getDocumentFromNode implementation**
```java
protected static Object getDocumentFromNode(Object node) {
    Object current = node;
    while (current != null && !(current instanceof ITestDocument)) {
        if (current instanceof ICell) {
            current = ((ICell) current).getParent();
        } else if (current instanceof IRow) {
            current = ((IRow) current).getParent();
        } else if (current instanceof ITestStep) {
            current = ((ITestStep) current).getParent();
        } else if (current instanceof ITestStepContainer) {
            current = ((ITestStepContainer) current).getParent();
        } else if (current instanceof ITestProject) {
            return null;
        } else {
            return null;
        }
    }
    return current;
}
```

### setCursorAtNode

Navigates cursor along a path string using element type names and 1-based indices.

**Example: setCursorAtNode implementation**
```java
protected void setCursorAtNode(String path) {
    String[] parts = path.split("/");
    Object current = getDocumentFromNode(cursor);
    int i = 0;
    while (i < parts.length && current != null) {
        String elementType = parts[i];
        if (elementType.equals("Table") || elementType.equals("Text")
                || elementType.equals("Description")) {
            current = getChildNode(current, elementType, 0);
            i++;
        } else {
            int index = Integer.parseInt(parts[i + 1]) - 1;
            current = getChildNode(current, elementType, index);
            i += 2;
        }
        if (current != null)
            cursor = current;
    }
}
```

### createNodeDependencies

Ensures all intermediate nodes exist along a path, creating them via {Language}Builder if missing.

**Example: createNodeDependencies implementation**
```java
protected void createNodeDependencies(String part) {
    String[] parts = part.split("/");
    Object current = getDocumentFromNode(cursor);
    int i = 0;
    while (i < parts.length) {
        String elementType = parts[i];
        if (elementType.equals("Table") || elementType.equals("Description")) {
            current = getOrCreateNode(current, elementType, 0);
            i++;
        } else if (elementType.equals("Text") || elementType.equals("CellList")) {
            break;
        } else {
            if (i + 1 >= parts.length || !parts[i + 1].matches("\\d+")) {
                break;
            }
            int index = Integer.parseInt(parts[i + 1]) - 1;
            current = getOrCreateNode(current, elementType, index);
            i += 2;
        }
    }
    cursor = current;
}
```

## TestObject{ObjectType}

### listToString

TestObjectPopup overrides listToString for ArrayList to format proposals with newline separation.

**Example: Popup listToString override**
```java
protected String listToString(ArrayList<?> proposals) {
    StringBuilder sb = new StringBuilder();
    for (Object p : proposals) {
        sb.append("\n").append(p.toString());
    }
    return sb.toString();
}
```

## {Language}LoggerProvider

### getLogger

Interface method allows external systems to inject custom logger implementations when SLF4J providers are not available.

**Example: Interface definition**
```java
public interface SheepDogLoggerProvider {
    public Logger getLogger(Class<?> clazz);
}
```

**Example: Eclipse plugin implementation**
```java
public class EclipseLoggerProvider implements SheepDogLoggerProvider {
    @Override
    public Logger getLogger(Class<?> clazz) {
        return new Logger() {
            @Override
            public void debug(String msg) {
                Platform.getLog(Activator.getContext().getBundle())
                    .log(new Status(IStatus.INFO, "plugin.id", msg));
            }
            // ... other methods
        };
    }
}
```

## I{Type}

### {Assignment}

All interface methods follow standard accessor naming: getters start with 'get', setters start with 'set', and adders start with 'add'.

**Example: Basic accessors**
```java
public interface ITestStep {
    String getName();
    void setName(String value);

    String getStepObjectName();
    void setStepObjectName(String value);

    String getStepDefinitionName();
    void setStepDefinitionName(String value);

    ITestStepContainer getParent();
}
```

**Example: Collection accessors**
```java
public interface IRow {
    ICell getCell(int index);
    ICell getCell(String name);
    List<ICell> getCellList();
    boolean addCell(ICell value);
}
```

### FullName

Methods that return qualified or full path names use 'FullName' suffix. Some are computed properties without setters.

**Example: Stored full name (with setter)**
```java
public interface IStepObject {
    String getName();        // Just the name
    String getFullName();    // Full qualified path
    void setFullName(String value);
}

// Usage
IStepObject obj = createStepObject(project, "components/HomePage.obj");
obj.getFullName(); // Returns "components/HomePage.obj"
```

**Example: Stored full name (with setter, parses into parts)**
```java
public interface ITestStep {
    String getFullName();    // Full step text
    void setFullName(String value); // Parses into stepObjectName + stepDefinitionName
    String getStepObjectName();
    String getStepDefinitionName();
}

// Usage
ITestStep step = createTestStep(parent, "The HomePage is loaded");
step.getFullName(); // Returns "The HomePage is loaded"
step.getStepObjectName(); // Returns "The HomePage"
step.getStepDefinitionName(); // Returns "is loaded"
```

## {Type}IssueResolver

### suggest{Assignment}{Scope}(I{Type})

Resolver methods generate quick fix proposals when values are missing. They suggest valid options from the workspace.

**Example: Suggesting valid options from workspace**
```java
public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(
        ITestStep theTestStep) throws Exception {
    // entry/exit logging omitted
    ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
    ITestProject theProject = theTestStep.getParent().getParent().getParent();

    for (String componentName : TestProjectUtility.getComponentList(theProject)) {
        proposals.addAll(getComponentObjects(theTestStep, componentName));
    }
    for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
        proposals.add(proposal);
    }
    return proposals;
}
```

### correct{Assignment}{Scope}(I{Type})

Resolver methods generate quick fix proposals when values exist but are wrong. They correct invalid references or offer to create missing resources.

**Example: Correcting invalid references or creating missing resources**
```java
public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(
        ITestStep theTestStep) throws Exception {
    // entry/exit logging omitted
    ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

    if (!theTestStep.getStepObjectName().isEmpty()) {
        // Suggest other component objects
        String component = TestStepUtility.getComponent(theTestStep.getFullName());
        proposals.addAll(getComponentObjects(theTestStep, component));

        // Or create a new one
        String fullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        IStepObject theStepObject = SheepDogBuilder.createStepObject(null, fullName);
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Generate " + theStepObject.getName() + " - " +
                theStepObject.getFullName());
        proposal.setDescription(theStepObject.getDescription() != null ? SheepDogUtility.getLineListAsString(theStepObject.getDescription().getLineList()) : "");
        proposal.setValue(theStepObject.getContent());
        proposal.setFullName(theStepObject.getFullName());
        proposals.add(proposal);
    }
    return proposals;
}
```

## {Language}IssueProposal

### {Language}IssueProposal

Default constructor initializes all attributes (id, description, value) to empty strings.

**Example: Creating proposal in resolver**
```java
SheepDogIssueProposal proposal = new SheepDogIssueProposal();
proposal.setId("HomePage");
proposal.setDescription("Home page for application");
proposal.setValue("The application HomePage");
```

### getId

Provides read access to the proposal identifier for matching and lookup.

**Example: Using getId**
```java
public String getId() {
    return id;
}
```

### setId

Provides write access to the proposal identifier.

**Example: Using setId**
```java
public void setId(String id) {
    this.id = id;
}
```

### getDescription

Provides read access to the proposal description for UI display.

**Example: Using getDescription**
```java
public String getDescription() {
    return description;
}
```

### setDescription

Provides write access to the proposal description.

**Example: Using setDescription**
```java
public void setDescription(String description) {
    this.description = description;
}
```

### getValue

Provides read access to the proposal value. Returns Object to support both String and IStepObject types.

**Example: Using getValue**
```java
public Object getValue() {
    return value;
}
```

### setValue

Provides write access to the proposal value. Accepts Object to support both String and IStepObject types.

**Example: Using setValue**
```java
public void setValue(Object value) {
    this.value = value;
}
```

### toString

Generates formatted string representation for debugging and logging purposes.

**Example: toString implementation**
```java
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("SheepDogIssueProposal [id=").append(id);
    sb.append(", description=").append(description);
    sb.append(", value=").append(value);
    sb.append("]");
    return sb.toString();
}
```
