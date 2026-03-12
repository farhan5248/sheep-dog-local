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

## {Language}FactoryImpl

### create{Type}

Creates a new POJO implementation of a grammar element interface.

**Example: Factory method body**
```java
@Override
public ICell createCell() {
    return new CellImpl();
}
```

## {Type}Impl

### set{Assignment}

Setters for child elements cast to impl type and wire the parent reference. Some setFullName implementations parse the value to extract sub-fields.

**Example: Setting a child with parent wiring**
```java
@Override
public void setTable(ITable value) {
    table = (TableImpl) value;
    table.parent = this;
}
```

**Example: Parsing fullName into parts**
```java
@Override
public void setFullName(String value) {
    stepObjectName = StepObjectRefFragments.getAll(value);
    stepDefinitionName = StepDefinitionRefFragments.getAll(value.replace(stepObjectName, ""));
}
```

### add{Type}

Adders cast to impl type, add to the internal list, and wire the parent reference.

**Example: Adding a child to a collection**
```java
@Override
public boolean addTestCase(ITestCase value) {
    TestCaseImpl impl = (TestCaseImpl) value;
    testStepContainerList.add(impl);
    impl.parent = this;
    return true;
}
```

### toString

Returns a string representation, typically the name or fullName field.

**Example: toString implementation**
```java
@Override
public String toString() {
    return name != null ? name : "";
}
```

## TestObject{Language}Impl

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

### get{Type}FromCursor

Extracts a grammar element from cursor by type-checking against grammar types.

**Example: getDescriptionFromCursor**
```java
protected IDescription getDescriptionFromCursor() {
    if (cursor instanceof ITestSuite) return ((ITestSuite) cursor).getDescription();
    else if (cursor instanceof ITestStepContainer) return ((ITestStepContainer) cursor).getDescription();
    else if (cursor instanceof ITestData) return ((ITestData) cursor).getDescription();
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

### getFullNameFromPath

Extracts the document full name from the "object" property.

**Example: getFullNameFromPath implementation**
```java
protected String getFullNameFromPath() {
    String path = (String) properties.get("object");
    return path.replace("src/test/resources/asciidoc/", "");
}
```

### listToString

Converts an ArrayList to a newline-separated string for assertion mapping.

**Example: listToString implementation**
```java
protected String listToString(ArrayList<?> list) {
    StringBuilder sb = new StringBuilder();
    for (Object item : list) {
        sb.append("\n").append(item.toString());
    }
    return sb.toString();
}
```

## {ObjectName}{ObjectType}Impl

Seven implementation patterns from `arch-test.md` map to the method patterns below. Edge (Action) classes use patterns 3, 4, 7. Vertex (File, Popup, Annotation) classes use patterns 1, 2, 5, 6.

### get{Type}{Assignment}

Vertex getter that operates directly on the document model (patterns 1, 2).

**Example: Pattern 1 — get + NodePath → setCursorAtNode**
```java
@Override
public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
    setCursorAtNode(keyMap.get("Node Path"));
    return cursor == null ? null : cursor.toString();
}
```

**Example: Pattern 1 — get + State → return state/listToString**
```java
@Override
public String getDescriptionNodeState(HashMap<String, String> keyMap) {
    IDescription desc = getDescriptionFromCursor();
    return desc == null ? null : desc.toString();
}
```

**Example: Pattern 1 — get + State → return listToString for collection**
```java
@Override
public String getStepDefinitionListNodeState(HashMap<String, String> keyMap) {
    if (cursor == null) return null;
    return listToString(((IStepObject) cursor).getStepDefinitionList());
}
```

**Example: Pattern 1 — get + {Assignment} → assert{Type}{Assignment}**
```java
@Override
public String getCellListNodeCellName(HashMap<String, String> keyMap) {
    return assertCellName(replaceKeyword(keyMap.get("Cell Name")));
}
```

### set{Type}{Assignment}

Edge classes buffer into properties (pattern 7). Vertex classes operate directly on model (patterns 1, 2).

**Example: Pattern 7 — Edge property buffer**
```java
@Override
public void setTestSuiteFullName(HashMap<String, String> keyMap) {
    properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
}
```

**Example: Pattern 7 — Edge property buffer (Node Path)**
```java
@Override
public void setNodePath(HashMap<String, String> keyMap) {
    properties.put("Node Path", keyMap.get("Node Path"));
}
```

**Example: Pattern 1 — Vertex set + NodePath → createNodeDependencies**
```java
@Override
public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
    createNodeDependencies(keyMap.get("Node Path"));
}
```

**Example: Pattern 1 — Vertex set + {Assignment} → add{Type}With{Assignment}**
```java
@Override
public void setCellListNodeCellName(HashMap<String, String> keyMap) {
    addCellWithName(keyMap.get("Cell Name"));
}
```

### get{StateDesc}

Vertex getter for document-level or dialog-level state (patterns 2, 5, 6).

**Example: Pattern 2 — Document get via testProject**
```java
@Override
public String getCreatedAsFollows(HashMap<String, String> keyMap) {
    cursor = testProject.getTestDocument(getFullNameFromPath());
    return cursor == null ? null : cursor.toString();
}
```

**Example: Pattern 5 — Dialog read, return string (Annotation)**
```java
@Override
public String getEmpty(HashMap<String, String> keyMap) {
    return validateDialog;
}
```

**Example: Pattern 5 — Dialog read, return listToString (Popup)**
```java
@Override
public String getEmpty(HashMap<String, String> keyMap) {
    return listToString(listProposalsDialog);
}
```

**Example: Pattern 6 — Proposal read, iterate dialog, match by Id**
```java
@Override
public String getProposalId(HashMap<String, String> keyMap) {
    for (SheepDogIssueProposal p : listProposalsDialog) {
        if (p.getId().equals(keyMap.get("Proposal Id"))) {
            return p.getId();
        }
    }
    return null;
}
```

**Example: Pattern 6 — Proposal read, match by Id and value**
```java
@Override
public String getProposalValue(HashMap<String, String> keyMap) {
    for (SheepDogIssueProposal p : listProposalsDialog) {
        if (p.getId().equals(keyMap.get("Proposal Id"))
                && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
            return p.getValue().toString();
        }
    }
    return null;
}
```

### set{StateDesc}

Edge classes consume buffered properties to execute actions (patterns 3, 4). Vertex File classes create documents (pattern 2). Vertex Popup/Annotation classes write dialog state (patterns 5, 6).

**Example: Pattern 2 — Vertex create TestSuite document**
```java
@Override
public void setCreated(HashMap<String, String> keyMap) {
    addTestSuiteWithFullName(getFullNameFromPath());
}
```

**Example: Pattern 2 — Vertex create StepObject document**
```java
@Override
public void setCreated(HashMap<String, String> keyMap) {
    addStepObjectWithFullName(getFullNameFromPath());
}
```

**Example: Pattern 3 — Edge create document action**
```java
@Override
public void setPerformedToCreateATestSuiteWith(HashMap<String, String> keyMap) {
    cursor = testProject;
    if (properties.get("Test Suite Full Name") != null) {
        addTestSuiteWithFullName(replaceKeyword(properties.get("Test Suite Full Name").toString()));
        properties.remove("Test Suite Full Name");
    }
}
```

**Example: Pattern 3 — Edge modify list action (navigateToDocument + navigateToNode + add)**
```java
@Override
public void setPerformedToModifyTestStepListWith(HashMap<String, String> keyMap) {
    navigateToDocument();
    navigateToNode();
    if (properties.get("Test Step Full Name") != null) {
        addTestStepWithFullName(replaceKeyword(properties.get("Test Step Full Name").toString()));
        properties.remove("Test Step Full Name");
    }
}
```

**Example: Pattern 3 — Edge add text/table action**
```java
@Override
public void setPerformedToAddTextAt(HashMap<String, String> keyMap) {
    if (properties.get("Test Suite Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
        properties.remove("Test Suite Full Name");
    }
    if (properties.get("Node Path") != null) {
        setCursorAtNode(properties.get("Node Path").toString());
        addTextWithContent("Text");
        properties.remove("Node Path");
    }
}
```

**Example: Pattern 4 — Edge validate via instanceof → {Type}IssueDetector.validate{Assignment}{Scope}**
```java
@Override
public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    if (properties.get("Test Suite Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
        properties.remove("Test Suite Full Name");
    }
    if (properties.get("Node Path") != null) {
        setCursorAtNode(properties.get("Node Path").toString());
        properties.remove("Node Path");
    }
    try {
        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (validateDialog == null || validateDialog.isEmpty()) {
                validateDialog = CellIssueDetector.validateNameOnly(cell);
                if (validateDialog == null) {
                    validateDialog = "";
                }
            }
        } else if (cursor instanceof IText) {
            IText text = (IText) cursor;
            if (validateDialog == null || validateDialog.isEmpty()) {
                validateDialog = TextIssueDetector.validateNameWorkspace(text);
                if (validateDialog == null) {
                    validateDialog = "";
                }
            }
        }
        // ... instanceof chain for each grammar type
    } catch (Exception e) {
        Assertions.fail(e);
    }
}
```

**Example: Pattern 4 — Edge apply quickfix via instanceof → {Type}IssueResolver.correct{Assignment}{Scope} + applyProposal**
```java
@Override
public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    // ... navigate (same as validate) ...
    try {
        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (!CellIssueDetector.validateNameOnly(cell).isEmpty()) {
                applyProposal(CellIssueResolver.correctNameOnly(cell));
            }
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            if (!TestStepIssueDetector.validateStepObjectNameWorkspace(testStep).isEmpty()) {
                applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
            }
        }
        // ... instanceof chain
    } catch (Exception e) {
        Assertions.fail(e);
    }
}
```

**Example: Pattern 4 — Edge list proposals via instanceof → {Type}IssueResolver.suggest{Assignment}{Scope}**
```java
@Override
public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    // ... navigate (same as validate) ...
    try {
        if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            ITestStep testStep = (ITestStep) row.getParent().getParent();
            listProposalsDialog.addAll(RowIssueResolver.suggestCellListWorkspace(testStep));
        } else if (cursor instanceof ITestStep) {
            listProposalsDialog.addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) cursor));
            listProposalsDialog.addAll(TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) cursor));
        }
        // ... instanceof chain
    } catch (Exception e) {
        Assertions.fail(e);
    }
}
```

**Example: Pattern 4 — Edge list quickfixes via instanceof → validateDialog check + {Type}IssueResolver.correct{Assignment}{Scope}**
```java
@Override
public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    // ... navigate (same as validate) ...
    try {
        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(cell));
            }
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            if (validateDialog.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                listQuickfixesDialog.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
            }
        }
        // ... instanceof chain
    } catch (Exception e) {
        Assertions.fail(e);
    }
}
```

**Example: Pattern 5 — Vertex dialog write (Annotation)**
```java
@Override
public void setContent(HashMap<String, String> keyMap) {
    validateDialog = keyMap.get("Content");
}
```

**Example: Pattern 5 — Vertex dialog write with keyword replacement (Annotation)**
```java
@Override
public void setEmpty(HashMap<String, String> keyMap) {
    validateDialog = replaceKeyword("empty");
}
```

**Example: Pattern 6 — Vertex append new proposal to dialog list**
```java
@Override
public void setProposalId(HashMap<String, String> keyMap) {
    listQuickfixesDialog.add(new SheepDogIssueProposal());
    listQuickfixesDialog.getLast().setId(keyMap.get("Proposal Id"));
}
```

**Example: Pattern 6 — Vertex set field on last proposal**
```java
@Override
public void setProposalDescription(HashMap<String, String> keyMap) {
    listQuickfixesDialog.getLast().setDescription(keyMap.get("Proposal Description"));
}
```

### navigateToDocument

Navigates cursor to a document by consuming Test Suite Full Name or Step Object Full Name from properties.

**Example: navigateToDocument implementation**
```java
private void navigateToDocument() {
    if (properties.get("Test Suite Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
        properties.remove("Test Suite Full Name");
    } else if (properties.get("Step Object Full Name") != null) {
        cursor = testProject.getTestDocument(replaceKeyword(properties.get("Step Object Full Name").toString()));
        properties.remove("Step Object Full Name");
    }
}
```

### navigateToNode

Navigates cursor to a node position by consuming Node Path from properties.

**Example: navigateToNode implementation**
```java
private void navigateToNode() {
    if (properties.get("Node Path") != null) {
        setCursorAtNode(properties.get("Node Path").toString());
        properties.remove("Node Path");
    }
}
```

### applyProposal

Static helper that applies issue fix proposals to the current cursor element.

**Example: applyProposal implementation**
```java
private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
    for (SheepDogIssueProposal p : proposals) {
        if (p.getValue() instanceof IStepObject) {
            testProject.addStepObject((IStepObject) p.getValue());
        } else {
            if (cursor instanceof ICell) {
                ((ICell) cursor).setName(p.getValue().toString());
            } else if (cursor instanceof ITestSuite) {
                ((ITestSuite) cursor).setName(p.getValue().toString());
            } else if (cursor instanceof ITestStepContainer) {
                ((ITestStepContainer) cursor).setName(p.getValue().toString());
            }
        }
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
