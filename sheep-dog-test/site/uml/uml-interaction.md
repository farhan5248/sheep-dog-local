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
    String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
    IStepObject theStepObject = theTestStep.getParent().getParent().getParent()
            .getStepObject(qualifiedName);
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

### get{Type}NameLongFor{Type}

Utility methods construct fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements. These methods navigate the parent hierarchy and apply domain-specific formatting rules.

**Example: Getting step object qualified name**
```java
public static String getStepObjectNameLongForTestStep(ITestStep theStep) {
    // entry/exit logging omitted
    if (theStep != null) {
        String stepNameLong = SheepDogUtility.getTestStepNameLong(theStep);
        if (stepNameLong != null && !stepNameLong.isEmpty()) {
            String component = StepObjectRefFragments.getComponent(stepNameLong);
            String object = StepObjectRefFragments.getObject(stepNameLong);
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

**Example: Getting test step qualified name with context inference**

When component or object is missing from the current step, infer from previous steps by iterating `getPreviousSteps(theStep)` and matching via `StepObjectRefFragments`. Returns `"The " + component + " " + object + " " + stepDefinitionName`.

```java
public static String getTestStepNameLong(ITestStep theStep) {
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
    IStepObject clone = SheepDogBuilder.createStepObject(null, original.getNameLong());
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
public static String getComponent(String text) {
    return getGroup("(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 2);
}
```

### is{Fragment}

Boolean methods check for the presence of specific fragments by testing if extraction returns a non-empty result.

**Example: Checking for tags and todos**
```java
public static boolean isTag(String text) {
    return !getGroup(TAG, text, 0).isEmpty();
}
```

**Example: Checking for object types**
```java
public static boolean isObjectEdgeType(String text) {
    return !getObjectEdgeType(text).isEmpty();
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
public enum TestStepComponentTypes {
    APPLICATION("application", "GUI web application");

    public final String value;
    public final String description;

    TestStepComponentTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
```

**Example: Using fragments in regex matching**
```java
// Match component type in test step
String stepText = "The customer application";
for (TestStepComponentTypes component : TestStepComponentTypes.values()) {
    if (stepText.contains(component.value)) {
        // Found component type
        return component;
    }
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

### NameLong

Methods that return qualified or full path names use 'NameLong' suffix. Some are computed properties without setters.

**Example: Stored qualified name (with setter)**
```java
public interface IStepObject {
    String getName();        // Just the name
    String getNameLong();    // Full qualified path
    void setNameLong(String value);
}

// Usage
IStepObject obj = createStepObject(project, "components/HomePage.obj");
obj.getNameLong(); // Returns "components/HomePage.obj"
```

**Example: Computed qualified name (no setter)**
```java
public interface ITestStep {
    String getName();        // Step definition name only
    String getNameLong();    // Full step text (computed)
    // No setNameLong() - computed from stepObjectName + stepDefinitionName
}

// Usage
ITestStep step = createTestStep(parent, "The HomePage is loaded");
step.getNameLong(); // Returns "The HomePage is loaded" (computed)
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
        String component = TestStepUtility.getComponent(theTestStep.getNameLong());
        proposals.addAll(getComponentObjects(theTestStep, component));

        // Or create a new one
        String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
        IStepObject theStepObject = SheepDogBuilder.createStepObject(null, qualifiedName);
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Generate " + theStepObject.getName() + " - " +
                theStepObject.getNameLong());
        proposal.setDescription(theStepObject.getDescription() != null ? SheepDogUtility.getLineListAsString(theStepObject.getDescription().getLineList()) : "");
        proposal.setValue(theStepObject.getContent());
        proposal.setQualifiedName(theStepObject.getNameLong());
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
