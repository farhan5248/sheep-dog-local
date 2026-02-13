# UML Interaction Patterns

**References**

1. `sheep-dog-main/site/impl/impl-xtext-logging.md` - SLF4J logging patterns specific to sheep-dog-test that supplement

## All

These patterns define which classes have loggers and which operations should be logged.

### Entry/Exit Logging Pattern

All public methods in Detector, Resolver, and Builder classes MUST have entry and exit logging.

**Rules**
- Entry log is the first statement in each public method
- Exit log is placed before each return statement

### No Logger Pattern

Utility classes, interfaces, and factory classes do not declare loggers to keep them lightweight and focused on their single responsibility.

**Examples**

- {Language}Utility classes have no logger
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

**Examples**

- No try-catch:
```java
// Not allowed
try {
    riskyOperation();
} catch (Exception e) {
    // handle
}
```

- No custom exceptions:
```java
// Not allowed
class CustomException extends Exception { }
```

- No null returns for errors:
```java
// Not allowed
public Object loadFile() {
    try {
        return readFile();
    } catch (Exception e) {
        return null; // Bad - use throws Exception instead
    }
}
```

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

### {TYPE}{ASSIGNMENT}{ISSUE}

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

### validate{Assignment}{Issue}

Detector methods validate grammar assignments at different scopes: Only (element-level), File (file-level), or Workspace (cross-file).

**Example: Element-level validation (Only)**
```java
public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
    logger.debug("Entering validateStepObjectNameOnly");
    String text = theTestStep.getStepObjectName();
    if (text != null) {
        if (!TestStepUtility.isValid(text)) {
            if (TestStepUtility.getStepObjectName(text).isEmpty()) {
                logger.debug("Exiting validateStepObjectNameOnly");
                return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
            }
        }
    }
    logger.debug("Exiting validateStepObjectNameOnly");
    return "";
}
```

**Example: Cross-file validation (Workspace)**
```java
public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
    logger.debug("Entering validateStepObjectNameWorkspace");
    String message = "";
    String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
    IStepObject theStepObject = theTestStep.getParent().getParent().getParent()
            .getStepObject(qualifiedName);
    if (theStepObject == null) {
        message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
    }
    logger.debug("Exiting validateStepObjectNameWorkspace");
    return message;
}
```

## {Language}Builder

### create{Type}

Builder methods create instances via the factory, set attributes, and add to parent collections. They handle both creation and initialization.

**Example: Simple creation with parent**
```java
public static ICell createCell(IRow parent, String name) {
    logger.debug("Entering createCell for name: {}", name);
    ICell cell = SheepDogFactory.instance.createCell();
    cell.setName(name);
    if (parent != null)
        parent.addCell(cell);
    logger.debug("Exiting createCell");
    return cell;
}
```

**Example: Creation with deduplication**
```java
public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
    logger.debug("Entering createStepDefinition for name: {}", name);
    IStepDefinition stepDefinition = null;
    if (parent != null)
        stepDefinition = parent.getStepDefinition(name);
    if (stepDefinition == null) {
        stepDefinition = SheepDogFactory.instance.createStepDefinition();
        stepDefinition.setName(name);
        if (parent != null)
            parent.addStepDefinition(stepDefinition);
    }
    logger.debug("Exiting createStepDefinition");
    return stepDefinition;
}
```

**Example: Creation with complex initialization**
```java
public static IStepParameters createStepParameters(IStepDefinition parent, String headers) {
    logger.debug("Entering createStepParameters for IRow");
    IStepParameters stepParameters = null;
    if (parent != null)
        stepParameters = parent.getStepParameters(headers);
    if (stepParameters == null) {
        stepParameters = SheepDogFactory.instance.createStepParameters();
        ITable table = createTable(stepParameters);
        IRow row = createRow(table);
        for (String h : headers.replaceFirst("^\\|\\s+", "").split("\\|")) {
            SheepDogBuilder.createCell(row, h);
        }
        if (parent != null)
            parent.addStepParameters(stepParameters);
    }
    logger.debug("Exiting createStepParameters");
    return stepParameters;
}
```

## {Language}LoggerFactory

### getLogger

Gets a logger for the specified class. Uses SLF4J when available, otherwise delegates to custom {Language}LoggerProvider.

**Example: Standard usage**
```java
private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

public static String validate(ITestStep step) {
    logger.debug("Starting validation");
    // validation logic
    logger.debug("Validation complete");
    return "";
}
```

**Example: Implementation with fallback**
```java
public static Logger getLogger(Class<?> clazz) {
    // Use custom impl if SLF4J has no real provider
    if (org.slf4j.LoggerFactory.getILoggerFactory()
            instanceof org.slf4j.helpers.NOPLoggerFactory) {
        if (provider != null) {
            return provider.getLogger(clazz);
        }
    }
    // Use SLF4J (either real provider exists, or fall back to NOP)
    return org.slf4j.LoggerFactory.getLogger(clazz);
}
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

**Example: Implementation with validation**
```java
public static void setLoggerImplementation(SheepDogLoggerProvider provider) {
    if (provider == null) {
        throw new IllegalArgumentException("Logger implementation cannot be null");
    } else {
        SheepDogLoggerFactory.provider = provider;
    }
}
```

## {Language}Utility

### get{Type}NameLongFor{Type}

Utility methods construct fully qualified or long-form names for grammar elements by combining components, objects, and contextual information from parent elements. These methods navigate the parent hierarchy and apply domain-specific formatting rules.

**Example: Getting step object qualified name**
```java
public static String getStepObjectNameLongForTestStep(ITestStep theStep) {
    if (theStep != null) {
        String stepNameLong = SheepDogUtility.getTestStepNameLong(theStep);
        if (stepNameLong != null && !stepNameLong.isEmpty()) {
            String component = StepObjectRefFragments.getComponent(stepNameLong);
            String object = StepObjectRefFragments.getObject(stepNameLong);

            if (!component.isEmpty() && !object.isEmpty()) {
                // Use utility method to navigate to project
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
```java
public static String getTestStepNameLong(ITestStep theStep) {
    String component = StepObjectRefFragments.getComponent(theStep.getStepObjectName());
    String object = StepObjectRefFragments.getObject(theStep.getStepObjectName());

    if (component.isEmpty() || !object.contains("/")) {
        ArrayList<ITestStep> previousSteps = getPreviousSteps(theStep);
        for (ITestStep previousStep : previousSteps) {
            String previousObject = StepObjectRefFragments.getObject(previousStep.getStepObjectName());
            String previousComponent = StepObjectRefFragments.getComponent(previousStep.getStepObjectName());
            if (previousObject.endsWith("/" + object)) {
                if (!object.contains("/") && previousObject.contains("/")) {
                    object = previousObject;
                }
                if (component.isEmpty() && !previousComponent.isEmpty()) {
                    component = previousComponent;
                }
                if (!component.isEmpty() && object.contains("/")) {
                    break;
                }
            }
        }
        if (component.isEmpty()) {
            String lastComponent = "Unknown service";
            for (ITestStep aStep : previousSteps) {
                if (!StepObjectRefFragments.getComponent(aStep.getStepObjectName()).isEmpty()) {
                    lastComponent = StepObjectRefFragments.getComponent(aStep.getStepObjectName());
                    break;
                }
            }
            component = lastComponent;
        }
    }
    return "The " + component + " " + object + " " + theStep.getStepDefinitionName();
}
```

**Example: Using getStepObjectNameLongForTestStep in validation**
```java
public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
    ...
    String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
    ...
}
```

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

**Example: Extracting component fragments**
```java
public static String getComponent(String text) {
    return getGroup("(The" + StepObjectRefFragments.COMPONENT + "?" + ")", text, 2);
}
```

**Example: Extracting object fragments**
```java
public static String getObject(String text) {
    return getGroup(STEP_OBJECT_REF, text, 5);
}
```

**Example: Extracting state fragments**
```java
public static String getState(String text) {
    return getGroup(STEP_DEFINITION_REF, text, 5);
}
```

**Example: Extracting title fragments**
```java
public static String getTagDesc(String text) {
    return getGroup(TAG, text, 3);
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

### {Type}{Fragment}Types

Private constructor initializes the value and description fields for each enum constant.

**Example: Constructor usage**
```java
TestStepComponentTypes(String value, String description) {
    this.value = value;
    this.description = description;
}
```

## IResourceRepository

### {IO}

Repository methods follow standard CRUD patterns for managing file resources with tagging support.

**Example: Reading and writing files**
```java
public interface IResourceRepository {
    String get(String tags, String path) throws Exception;
    void put(String tags, String path, String content) throws Exception;
    void delete(String tags, String path);
    List<String> list(String tags, String path, String extension);
    boolean contains(String tags, String path);
    void clear(String tags);
}
```

**Example: Using repository in builder**
```java
IResourceRepository repo = getRepository();

// Read file
String content = repo.get("test", "src/test/resources/feature.txt");

// Write file
repo.put("test", "output/result.txt", generatedContent);

// Check existence
if (repo.contains("test", "config.properties")) {
    // Load configuration
}

// List files
List<String> features = repo.list("test", "src/test/resources", ".feature");
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

**Example: Using accessors**
```java
ITestStep step = SheepDogFactory.instance.createTestStep();
step.setStepObjectName("HomePage");
step.setStepDefinitionName("is loaded");

ITable table = SheepDogFactory.instance.createTable();
step.setTable(table);
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

### suggest{Assignment}{Issue}(I{Type})

Resolver methods generate quick fix proposals when values are missing. They suggest valid options from the workspace.

**Example: Suggesting step objects**
```java
public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(
        ITestStep theTestStep) throws Exception {
    logger.debug("Entering suggestStepObjectNameWorkspace");
    ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
    ITestProject theProject = theTestStep.getParent().getParent().getParent();

    // Suggest objects from all components
    for (String componentName : TestProjectUtility.getComponentList(theProject)) {
        proposals.addAll(getComponentObjects(theTestStep, componentName));
    }

    // Suggest objects from previous steps
    for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
        proposals.add(proposal);
    }

    logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals",
            proposals.size());
    return proposals;
}
```

**Example: Suggesting step definitions**
```java
public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(
        ITestStep theTestStep) throws Exception {
    logger.debug("Entering suggestStepDefinitionNameWorkspace");
    ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

    // Get all step definitions from the step object
    for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
        proposals.add(proposal);
    }

    logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals",
            proposals.size());
    return proposals;
}
```

### correct{Assignment}{Issue}(I{Type})

Resolver methods generate quick fix proposals when values exist but are wrong. They correct invalid references or offer to create missing resources.

**Example: Correcting invalid step object**
```java
public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(
        ITestStep theTestStep) throws Exception {
    logger.debug("Entering correctStepObjectNameWorkspace");
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
        proposal.setDescription(StatementUtility.getStatementListAsString(
                theStepObject.getStatementList()));
        proposal.setValue(theStepObject.getContent());
        proposal.setQualifiedName(theStepObject.getNameLong());
        proposals.add(proposal);
    }

    logger.debug("Exiting correctStepObjectNameWorkspace with {} proposals",
            proposals.size());
    return proposals;
}
```

**Example: Correcting invalid step definition**
```java
public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(
        ITestStep theTestStep) throws Exception {
    logger.debug("Entering correctStepDefinitionNameWorkspace");
    ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
    String stepDefinitionName = TestStepUtility.getStepDefinitionName(
            theTestStep.getStepDefinitionName());

    if (!stepDefinitionName.isEmpty()) {
        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        IStepObject theStepObject = theProject.getStepObject(
                TestStepUtility.getStepObjectQualifiedName(theTestStep));

        if (theStepObject != null) {
            IStepDefinition theStepDefinition = theStepObject.getStepDefinition(
                    stepDefinitionName);

            if (theStepDefinition == null) {
                // Valid name but doesn't exist - suggest existing or create new
                for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
                    proposals.add(proposal);
                }

                theStepDefinition = SheepDogBuilder.createStepDefinition(
                        theStepObject, stepDefinitionName);
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setId("Generate " + theStepDefinition.getName());
                proposal.setDescription(StatementUtility.getStatementListAsString(
                        theStepDefinition.getStatementList()));
                proposal.setValue(theStepObject.getContent());
                proposal.setQualifiedName(theStepObject.getNameLong());
                proposals.add(proposal);
            }
        }
    }

    logger.debug("Exiting correctStepDefinitionNameWorkspace with {} proposals",
            proposals.size());
    return proposals;
}
```

## {Language}IssueProposal

### {Language}IssueProposal

Default constructor initializes all attributes to empty strings, ready for population by resolver methods.

**Example: Constructor usage**
```java
public SheepDogIssueProposal() {
    this.id = "";
    this.description = "";
    this.value = "";
    this.qualifiedName = "";
}
```

**Example: Creating proposal in resolver**
```java
SheepDogIssueProposal proposal = new SheepDogIssueProposal();
proposal.setId("HomePage");
proposal.setDescription("Home page for application");
proposal.setValue("The application HomePage");
```

### get{Proposal}

Getters provide read access to proposal attributes following JavaBeans convention.

**Example: Using getters**
```java
ArrayList<SheepDogIssueProposal> proposals = resolver.suggestStepObjectNameWorkspace(step);
for (SheepDogIssueProposal proposal : proposals) {
    System.out.println("ID: " + proposal.getId());
    System.out.println("Description: " + proposal.getDescription());
    System.out.println("Value: " + proposal.getValue());
}
```
