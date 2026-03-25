# UML Interaction Patterns

**References**

## TestConfig

### configure

binds a `src-gen/test/java/org/farhan/objects` interface to `src/test/java/org/farhan/impl` class

**Example: configure method body**
```java
package org.farhan.impl;

import org.farhan.impl.AppInputFileAsciidocFileImpl;

public final class TestConfig extends AbstractModule implements InjectorSource {
    @Override
    protected void configure() {
        bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile.class)
                .to(AppInputFileAsciidocFileImpl.class);
    }
}
```

### getInjector

Creates a Guice injector with DEVELOPMENT stage, Cucumber scenario module, and this TestConfig module.

**Example: getInjector method body**
```java
@Override
public Injector getInjector() {
    return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new TestConfig());
}
```

### resetTestProject

Cucumber @Before hook that resets TestObject and TestObjectSheepDogImpl static state before each scenario.

**Example: resetTestProject method body**
```java
@Before
public void resetTestProject() throws Exception {
    TestObject.reset();
    TestObjectSheepDogImpl.reset();
}
```

## TestObject{Language}Impl

### reset

Resets all static state for a clean test run. Initializes factory, creates workspace, and clears all dialog properties.

**Example: reset implementation**
```java
public static void reset() {
    SheepDogFactory.instance = new SheepDogFactoryImpl();
    ITestProject workspace = SheepDogBuilder.createTestProject();
    setProperty("workspace", workspace);
    setProperty("cursor", workspace);
    setProperty("validate annotation.Content", "");
    setProperty("list proposals popup", new ArrayList<SheepDogIssueProposal>());
    setProperty("list quickfixes popup", new ArrayList<SheepDogIssueProposal>());
}
```

### add{Type}With{Assignment}

Creates grammar elements with auto-navigation: if cursor is already at the target type, moves up to parent first. Updates cursor via `setProperty("cursor", ...)`.

**Example: Creating a test step**
```java
protected void addTestStepWithFullName(String stepName) {
    Object cursor = getProperty("cursor");
    if (cursor instanceof ITestStep) {
        cursor = ((ITestStep) cursor).getParent();
    }
    setProperty("cursor", SheepDogBuilder.createTestStep((ITestStepContainer) cursor, stepName));
}
```

**Example: Creating a cell**
```java
protected void addCellWithName(String name) {
    Object cursor = getProperty("cursor");
    if (cursor instanceof ICell) {
        cursor = ((ICell) cursor).getParent();
    }
    setProperty("cursor", SheepDogBuilder.createCell((IRow) cursor, name));
}
```

**Example: Creating a test suite**
```java
protected void addTestSuiteWithFullName(String testSuiteFullName) {
    Object cursor = getProperty("cursor");
    if (cursor instanceof ITestSuite) {
        cursor = ((ITestSuite) cursor).getParent();
    }
    setProperty("cursor",
            SheepDogBuilder.createTestSuite((ITestProject) getProperty("workspace"), testSuiteFullName));
}
```

### assert{Type}{Assignment}

Queries model elements, navigating to them if needed. Returns the value or null if not found. Updates cursor via `setProperty("cursor", ...)` when navigating.

**Example: Asserting with navigation**
```java
protected String assertTestStepContainerName(String name) {
    Object cursor = getProperty("cursor");
    if (cursor instanceof ITestStepContainer) {
        return ((ITestStepContainer) cursor).getName();
    } else {
        Object tsc = ((ITestSuite) cursor).getTestStepContainer(name);
        setProperty("cursor", tsc);
        return tsc == null ? null : ((ITestStepContainer) tsc).getName();
    }
}
```

**Example: Direct assertion without navigation**
```java
protected String assertTestStepFullName(String fullName) {
    return ((ITestStep) getProperty("cursor")).getFullName();
}
```

### get{Type}FromCursor

Extracts a grammar element from `getProperty("cursor")` by type-checking against grammar types.

**Example: getDescriptionFromCursor**
```java
protected IDescription getDescriptionFromCursor() {
    Object cursor = getProperty("cursor");
    if (cursor instanceof ITestSuite)
        return ((ITestSuite) cursor).getDescription();
    else if (cursor instanceof ITestStepContainer)
        return ((ITestStepContainer) cursor).getDescription();
    else if (cursor instanceof IStepObject)
        return ((IStepObject) cursor).getDescription();
    else if (cursor instanceof IStepDefinition)
        return ((IStepDefinition) cursor).getDescription();
    else if (cursor instanceof IStepParameters)
        return ((IStepParameters) cursor).getDescription();
    else if (cursor instanceof ITestData)
        return ((ITestData) cursor).getDescription();
    return null;
}
```

### getOrCreateNode

Returns existing child node or creates via SheepDogBuilder when missing. Implemented in TestObjectSheepDogImpl.

**Example: getOrCreateNode implementation**
```java
protected Object getOrCreateNode(Object parent, String elementType, int index) {
    switch (elementType) {
    case "Table": {
        Object child = getChildNode(parent, elementType, index);
        if (child != null)
            return child;
        if (parent instanceof ITestStep)
            return SheepDogBuilder.createTable((ITestStep) parent);
        if (parent instanceof ITestData)
            return SheepDogBuilder.createTable((ITestData) parent);
        return SheepDogBuilder.createTable((IStepParameters) parent);
    }
    case "Description": {
        Object child = getChildNode(parent, elementType, index);
        if (child != null)
            return child;
        if (parent instanceof ITestSuite)
            return SheepDogBuilder.createDescription((ITestSuite) parent);
        if (parent instanceof ITestStepContainer)
            return SheepDogBuilder.createDescription((ITestStepContainer) parent);
        if (parent instanceof IStepObject)
            return SheepDogBuilder.createDescription((IStepObject) parent);
        if (parent instanceof IStepDefinition)
            return SheepDogBuilder.createDescription((IStepDefinition) parent);
        if (parent instanceof IStepParameters)
            return SheepDogBuilder.createDescription((IStepParameters) parent);
        return SheepDogBuilder.createDescription((ITestData) parent);
    }
    default:
        try {
            return getChildNode(parent, elementType, index);
        } catch (IndexOutOfBoundsException e) {
            switch (elementType) {
            case "TestStepContainerList":
                return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
            case "TestStepList":
                return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
            case "RowList":
                return SheepDogBuilder.createRow((ITable) parent);
            case "CellList":
                return SheepDogBuilder.createCell((IRow) parent, "");
            case "StepDefinitionList":
                return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
            case "StepParametersList":
                return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
            case "LineList":
                return SheepDogBuilder.createLine((IDescription) parent, "");
            case "TestDataList":
                return SheepDogBuilder.createTestData((ITestCase) parent, "");
            default:
                throw new IllegalArgumentException("Unknown element type: " + elementType);
            }
        }
    }
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
    return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
}
```

**Example: Pattern 1 — get + State → return state/listToCsvString**
```java
@Override
public String getDescriptionNodeState(HashMap<String, String> keyMap) {
    IDescription desc = getDescriptionFromCursor();
    return desc == null ? null : desc.toString();
}
```

**Example: Pattern 1 — get + State → return listToCsvString for collection**
```java
@Override
public String getStepDefinitionListNodeState(HashMap<String, String> keyMap) {
    if (getProperty("cursor") == null)
        return null;
    return listToCsvString(((IStepObject) getProperty("cursor")).getStepDefinitionList());
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

Edge classes buffer into properties via `setProperty()` (pattern 7). Vertex classes operate directly on model (patterns 1, 2).

**Example: Pattern 7 — Edge property buffer**
```java
@Override
public void setTestSuiteFullName(HashMap<String, String> keyMap) {
    setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
}
```

**Example: Pattern 7 — Edge property buffer (Node Path)**
```java
@Override
public void setNodePath(HashMap<String, String> keyMap) {
    setProperty("Node Path", keyMap.get("Node Path"));
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

**Example: Pattern 2 — Document get via getProperty("workspace")**
```java
@Override
public String getCreatedAsFollows(HashMap<String, String> keyMap) {
    setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
    return getProperty("cursor") == null ? null : getProperty("cursor").toString();
}
```

**Example: Pattern 5 — Dialog read, return string (Annotation)**
```java
@Override
public String getEmpty(HashMap<String, String> keyMap) {
    return (String) getProperty("validate annotation.Content");
}
```

**Example: Pattern 5 — Dialog read, return listToCsvString (Popup)**
```java
@Override
public String getEmpty(HashMap<String, String> keyMap) {
    return listToCsvString(((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup")));
}
```

**Example: Pattern 6 — Proposal read, iterate dialog, match by Id**
```java
@Override
public String getProposalId(HashMap<String, String> keyMap) {
    for (SheepDogIssueProposal p : ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup"))) {
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
    for (SheepDogIssueProposal p : ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup"))) {
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
    setProperty("cursor", getProperty("workspace"));
    if (getProperty("Test Suite Full Name") != null) {
        addTestSuiteWithFullName(replaceKeyword(getProperty("Test Suite Full Name").toString()));
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
    if (getProperty("Test Step Full Name") != null) {
        addTestStepWithFullName(replaceKeyword(getProperty("Test Step Full Name").toString()));
        properties.remove("Test Step Full Name");
    }
}
```

**Example: Pattern 3 — Edge add text action**
```java
@Override
public void setPerformedToAddTextAt(HashMap<String, String> keyMap) {
    if (getProperty("Test Suite Full Name") != null) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
        properties.remove("Test Suite Full Name");
    }
    if (getProperty("Node Path") != null) {
        setCursorAtNode(getProperty("Node Path").toString());
        addTextWithContent("Text");
        properties.remove("Node Path");
    }
}
```

**Example: Pattern 4 — Edge validate via instanceof → {Type}IssueDetector.validate{Assignment}{Scope}**
```java
@Override
public void setPerformedAsFollows(HashMap<String, String> keyMap) {
    if (getProperty("Test Suite Full Name") != null) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
        properties.remove("Test Suite Full Name");
    }
    if (getProperty("Node Path") != null) {
        setCursorAtNode(getProperty("Node Path").toString());
        properties.remove("Node Path");
    }
    try {
        String validateDialog = (String) getProperty("validate annotation.Content");
        if (getProperty("cursor") instanceof ICell) {
            ICell cell = (ICell) getProperty("cursor");
            if (validateDialog == null || validateDialog.isEmpty()) {
                validateDialog = CellIssueDetector.validateNameOnly(cell);
                if (validateDialog == null) {
                    validateDialog = "";
                }
            }
        } else if (getProperty("cursor") instanceof ITestStep) {
            ITestStep testStep = (ITestStep) getProperty("cursor");
            if (validateDialog == null || validateDialog.isEmpty()) {
                validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(testStep);
                // ... cascading validation checks ...
            }
        }
        // ... instanceof chain for each grammar type
        setProperty("validate annotation.Content", validateDialog);
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
        String validateDialog = (String) getProperty("validate annotation.Content");
        Object cursor = getProperty("cursor");
        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                applyProposal(CellIssueResolver.correctNameOnly(cell));
            }
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            if (validateDialog
                    .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
            } else if (validateDialog
                    .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
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
        Object cursor = getProperty("cursor");
        @SuppressWarnings("unchecked")
        ArrayList<SheepDogIssueProposal> listProposalsDialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            ITestStep testStep = (ITestStep) row.getParent().getParent();
            listProposalsDialog.addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) testStep));
        } else if (cursor instanceof ITestStep) {
            listProposalsDialog
                    .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) cursor));
            listProposalsDialog.addAll(
                    TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) cursor));
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
        String validateDialog = (String) getProperty("validate annotation.Content");
        Object cursor = getProperty("cursor");
        @SuppressWarnings("unchecked")
        ArrayList<SheepDogIssueProposal> listQuickfixesDialog = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
        if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(cell));
            }
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            if (validateDialog
                    .contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                listQuickfixesDialog
                        .addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
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
    setProperty("validate annotation.Content", keyMap.get("Content"));
}
```

**Example: Pattern 5 — Vertex dialog write with keyword replacement (Annotation)**
```java
@Override
public void setEmpty(HashMap<String, String> keyMap) {
    setProperty("validate annotation.Content", replaceKeyword("empty"));
}
```

**Example: Pattern 6 — Vertex append new proposal to dialog list**
```java
@Override
public void setProposalId(HashMap<String, String> keyMap) {
    ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).add(new SheepDogIssueProposal());
    ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setId(keyMap.get("Proposal Id"));
}
```

**Example: Pattern 6 — Vertex set field on last proposal**
```java
@Override
public void setProposalDescription(HashMap<String, String> keyMap) {
    ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setDescription(keyMap.get("Proposal Description"));
}
```

### navigateToDocument

Navigates cursor to a document by consuming Test Suite Full Name or Step Object Full Name from properties. Private helper in Edge action impls.

**Example: navigateToDocument implementation**
```java
private void navigateToDocument() {
    if (getProperty("Test Suite Full Name") != null) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
        properties.remove("Test Suite Full Name");
    } else if (getProperty("Step Object Full Name") != null) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Step Object Full Name").toString())));
        properties.remove("Step Object Full Name");
    }
}
```

### navigateToNode

Navigates cursor to a node position by consuming Node Path from properties. Private helper in Edge action impls.

**Example: navigateToNode implementation**
```java
private void navigateToNode() {
    if (getProperty("Node Path") != null) {
        setCursorAtNode(getProperty("Node Path").toString());
        properties.remove("Node Path");
    }
}
```

### applyProposal

Static helper that applies issue fix proposals to the current cursor element. Uses `getProperty("workspace")` and `getProperty("cursor")`.

**Example: applyProposal implementation**
```java
private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
    for (SheepDogIssueProposal p : proposals) {
        if (p.getValue() instanceof IStepObject) {
            ((ITestProject) getProperty("workspace")).addStepObject((IStepObject) p.getValue());
        } else {
            Object cursor = getProperty("cursor");
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

