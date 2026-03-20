# UML Communication Patterns

These patterns describe the communication sequence for steps in test cases. Each pattern shows the classes involved in processing a step, starting from the auto-generated interface. Step definitions, TestSteps, and TestObject are generated infrastructure and not included.

## Validate Action

**Regex**: `^The {componentName} {componentType} validate action is performed as follows$`

This pattern applies when a step performs validation on a grammar element at a node position. The action navigates to a document and node, then delegates to the appropriate {Type}IssueDetector based on the cursor's grammar type. The validation result is stored in shared state for the corresponding vertex (annotation) to assert.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `setCursorAtNode()` and model navigation helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., ValidateAction). Invoked by step definitions via Guice binding. |
| 3 | [{Type}IssueDetector](uml-class-TypeIssueDetector.md) | Main code entry point. Invoked by {ObjectName}{ObjectType}Impl to validate a grammar element. Delegates to {Type}IssueTypes for error descriptions and optionally to {Language}Utility for name resolution. |
| 4 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Provides validation error description strings to {Type}IssueDetector. |
| 5 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers to {Type}IssueDetector for entry/exit logging. |
| 6 | [{Language}Utility](uml-class-LanguageUtility.md) | Provides parsing/name-resolution methods to {Type}IssueDetector. |
| 7 | [I{Type}](uml-class-IType.md) | Grammar element interfaces used by {ObjectName}{ObjectType}Impl for instanceof type-checking and by {Type}IssueDetector as parameter types. |
| 8 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() via `getProperty("cursor")`
   - 2.3. instanceof **I{Type}** chain on `getProperty("cursor")`
   - 2.4. → **{Type}IssueDetector**.validate{Assignment}{Scope}(**I{Type}**)
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)
     - → **{Type}IssueTypes**.description
   - 2.5. → `setProperty("validate annotation.Content", validateDialog)`

## List Quickfixes Action

**Regex**: `^The {componentName} {componentType} list quickfixes action is performed as follows$`

This pattern applies when a step generates correction proposals for an already-validated grammar element. The action navigates to a document and node, reads the prior validation result from `getProperty("validate annotation.Content")`, matches it against {Type}IssueTypes to select the appropriate {Type}IssueResolver, and stores the correction proposals in `getProperty("list quickfixes popup")`.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `setCursorAtNode()` and model navigation helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., ListQuickfixesAction). Invoked by step definitions via Guice binding. |
| 3 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Main code entry point. Invoked by {ObjectName}{ObjectType}Impl to generate correction proposals. Delegates to {Language}Utility for name resolution and returns {Language}IssueProposal objects. |
| 4 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Provides validation error description strings matched against prior validation result to select the appropriate {Type}IssueResolver. |
| 5 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects returned by {Type}IssueResolver, stored in `getProperty("list quickfixes popup")`. |
| 6 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers to {Type}IssueResolver for entry/exit logging. |
| 7 | [{Language}Utility](uml-class-LanguageUtility.md) | Provides parsing/name-resolution methods to {Type}IssueResolver. |
| 8 | [I{Type}](uml-class-IType.md) | Grammar element interfaces used by {ObjectName}{ObjectType}Impl for instanceof type-checking and by {Type}IssueResolver as parameter types. |
| 9 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() via `getProperty("cursor")`
   - 2.3. reads `getProperty("validate annotation.Content")` and matches against **{Type}IssueTypes**.description
   - 2.4. instanceof **I{Type}** chain on `getProperty("cursor")`
   - 2.5. → **{Type}IssueResolver**.correct{Assignment}{Scope}(**I{Type}**) → `addAll` to `getProperty("list quickfixes popup")`
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)

## Apply Quickfix Action

**Regex**: `^The {componentName} {componentType} apply quickfix action is performed as follows$`

This pattern applies when a step applies correction proposals to fix an invalid grammar element. The action navigates to a document and node, reads the prior validation result, generates corrections via {Type}IssueResolver, then applies the proposals by modifying the model directly via I{Type} setters or adding elements to ITestProject.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `setCursorAtNode()` and model navigation helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., ApplyQuickfixAction). Invoked by step definitions via Guice binding. |
| 3 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Main code entry point. Invoked by {ObjectName}{ObjectType}Impl to generate correction proposals. Delegates to {Language}Utility for name resolution and returns {Language}IssueProposal objects. |
| 4 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Provides validation error description strings matched against prior validation result to select the appropriate {Type}IssueResolver. |
| 5 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects returned by {Type}IssueResolver, iterated in `applyProposal()` to modify model via I{Type} setters. |
| 6 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers to {Type}IssueResolver for entry/exit logging. |
| 7 | [{Language}Utility](uml-class-LanguageUtility.md) | Provides parsing/name-resolution methods to {Type}IssueResolver. |
| 8 | [I{Type}](uml-class-IType.md) | Grammar element interfaces used by {ObjectName}{ObjectType}Impl for instanceof type-checking and by applyProposal for setters. |
| 9 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()` and by applyProposal via `addStepObject()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() via `getProperty("cursor")`
   - 2.3. reads `getProperty("validate annotation.Content")` and matches against **{Type}IssueTypes**.description
   - 2.4. instanceof **I{Type}** chain on `getProperty("cursor")`
   - 2.5. → **{Type}IssueResolver**.correct{Assignment}{Scope}(**I{Type}**) → returns ArrayList<**{Language}IssueProposal**>
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)
   - 2.6. → applyProposal(ArrayList<**{Language}IssueProposal**>)
     - → **{Language}IssueProposal**.getValue()
     - → **I{Type}**.setName() or `getProperty("workspace")` cast to **ITestProject**.addStepObject()

## List Proposals Action

**Regex**: `^The {componentName} {componentType} list proposals action is performed as follows$`

This pattern applies when a step generates content assist suggestions for a grammar element. The action navigates to a document and node, then delegates to {Type}IssueResolver.suggest to generate suggestions without requiring prior validation. The proposals are stored in `getProperty("list proposals popup")`.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `setCursorAtNode()` and model navigation helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., ListProposalsAction). Invoked by step definitions via Guice binding. |
| 3 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Main code entry point. Invoked by {ObjectName}{ObjectType}Impl to generate suggestion proposals. Returns {Language}IssueProposal objects. |
| 4 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects returned by {Type}IssueResolver, stored in `getProperty("list proposals popup")`. |
| 5 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers to {Type}IssueResolver for entry/exit logging. |
| 6 | [{Language}Utility](uml-class-LanguageUtility.md) | Provides parsing/name-resolution methods to {Type}IssueResolver. |
| 7 | [I{Type}](uml-class-IType.md) | Grammar element interfaces used by {ObjectName}{ObjectType}Impl for instanceof type-checking and by {Type}IssueResolver as parameter types. |
| 8 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() via `getProperty("cursor")`
   - 2.3. instanceof **I{Type}** chain on `getProperty("cursor")`
   - 2.4. → **{Type}IssueResolver**.suggest{Assignment}{Scope}(**I{Type}**) → `addAll` to `getProperty("list proposals popup")`
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)

## Add Document Action

**Regex**: `^The {componentName} {componentType} add document action is performed to create a (TestSuite|StepObject) with$`

This pattern applies when a step creates a new top-level document (TestSuite or StepObject) in the workspace. The action sets cursor to workspace, then creates the document element via {Language}Builder.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `add{Type}WithFullName()` helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., AddDocumentAction). Invoked by step definitions via Guice binding. |
| 3 | [{Language}Builder](uml-class-LanguageBuilder.md) | Main code entry point. Invoked by TestObject{Language}Impl to create grammar elements via `create{Type}()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedToCreateA{Type}With(keyMap)
   - 2.1. → `setProperty("cursor", getProperty("workspace"))`
   - 2.2. → **TestObject{Language}Impl**.add{Type}WithFullName()
     - → **{Language}Builder**.create{Type}()

## Edit Document Action

**Regex**: `^The {componentName} {componentType} edit document action is performed to (add (Text|Table) at|modify {Assignment} with)$`

This pattern applies when a step adds a child element to an existing node. The action navigates to a document and node, then creates the child element via {Language}Builder. This covers both adding Text/Table elements and modifying list assignments within a node.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `setCursorAtNode()`, `addTextWithContent()`, `addTable()`, `add{Type}With{Assignment}()` helpers to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface (e.g., EditDocumentAction). Invoked by step definitions via Guice binding. |
| 3 | [{Language}Builder](uml-class-LanguageBuilder.md) | Main code entry point. Invoked by TestObject{Language}Impl to create grammar elements via `createText()`, `createTable()`, `create{Type}()`. |
| 4 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer column value
2. **{ObjectName}{ObjectType}Impl**.setPerformedToAdd{Type}At(keyMap) or setPerformedToModify{Assignment}With(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode()
   - 2.3. → **TestObject{Language}Impl**.addTextWithContent() or addTable() or add{Type}With{Assignment}()
     - → **{Language}Builder**.createText() or createTable() or create{Type}()

## Decompose Fragment

**Regex**: `^The {componentName} file {componentName} {componentType} fragment will be decomposed as follows$`

This pattern applies when a step decomposes a grammar element's text into typed fragments using regex-based parsing. The impl creates a document via {Language}Builder, then delegates to the appropriate {Fragment}Fragments class to extract named groups. For fragments with typed values, the corresponding {Fragment}{Aspect}Types enum provides the description string.

| # | Class | Role |
|---|---|---|
| 1 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Connects reusable methods in TestObject to any class implementing a test interface. Provides `addTestSuiteWithFullName()`, `getFullNameFromPath()` to {ObjectName}{ObjectType}Impl. |
| 2 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | extends TestObject{Language}Impl, implements generated interface. Invoked by step definitions via Guice binding. |
| 3 | [{Fragment}Fragments](uml-class-TypeFragments.md) | Main code entry point. Invoked by {ObjectName}{ObjectType}Impl to extract named groups from text via regex-based parsing. Delegates to {Fragment}{Aspect}Types for typed values. |
| 4 | [{Fragment}{Aspect}Types](uml-class-TypeFragmentTypes.md) | Provides description strings for typed fragment values to {Fragment}Fragments. |
| 5 | [{Language}Builder](uml-class-LanguageBuilder.md) | Invoked by TestObject{Language}Impl to create grammar elements via `createTestProject()`, `createTestSuite()`. |
| 6 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers to {Language}Builder for entry/exit logging. |
| 7 | [ITestProject](uml-class-IType.md) | Workspace root used by {ObjectName}{ObjectType}Impl to navigate from workspace to document via `getTestDocument()`. |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
   - → `setProperty(key, value)` to buffer input value
2. **{ObjectName}{ObjectType}Impl**.get{Fragment}{Aspect}FragmentDecomposedAsFollows(keyMap)
   - 2.1. → `getProperty("workspace")` cast to **ITestProject**, then `.getTestDocument()` → `setProperty("cursor", ...)`
3. **{ObjectName}{ObjectType}Impl**.get{Fragment}{Aspect}Fragment{Column}(keyMap) — for each assertion column
   - 3.1. → **{Fragment}Fragments**.get{Aspect}() or get{Aspect}Desc()
   - 3.2. → **{Fragment}{Aspect}Types**.description (optional, when column is a type description)
