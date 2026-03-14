# UML Communication Patterns

These patterns describe the communication sequence for steps in test cases. Each pattern shows the classes involved in processing a step, starting from the auto-generated interface. Step definitions, TestSteps, and TestObject are generated infrastructure and not included.

## Validate Action

**Regex**: `^The {componentName} {componentType} validate action is performed as follows$`

This pattern applies when a step performs validation on a grammar element at a node position. The action navigates to a document and node, then delegates to the appropriate {Type}IssueDetector based on the cursor's grammar type. The validation result is stored in shared state for the corresponding vertex (annotation) to assert.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited base class providing `setCursorAtNode()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [I{Type}](uml-class-IType.md) | Grammar element interfaces for instanceof type-checking |
| 5 | [{Type}Impl](uml-class-TypeImpl.md) | Concrete POJO implementations behind I{Type} |
| 6 | [{Type}IssueDetector](uml-class-TypeIssueDetector.md) | Validates the grammar element via `validate{Assignment}{Scope}()` |
| 7 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Enum constants providing the validation error description string |
| 8 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers for entry/exit logging in {Type}IssueDetector |
| 9 | [{Language}Utility](uml-class-LanguageUtility.md) | Parsing/utility methods used by some {Type}IssueDetectors |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() → **{Type}Impl** getters for navigation
   - 2.3. instanceof **I{Type}** chain
   - 2.4. → **{Type}IssueDetector**.validate{Assignment}{Scope}(**I{Type}**)
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)
     - → **{Type}IssueTypes**.description

## List Quickfixes Action

**Regex**: `^The {componentName} {componentType} list quickfixes action is performed as follows$`

This pattern applies when a step generates correction proposals for an already-validated grammar element. The action navigates to a document and node, reads the prior validation result from `validate annotation.Content`, matches it against {Type}IssueTypes to select the appropriate {Type}IssueResolver, and stores the correction proposals in `list quickfixes popup`.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited base class providing `setCursorAtNode()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [I{Type}](uml-class-IType.md) | Grammar element interfaces for instanceof type-checking |
| 5 | [{Type}Impl](uml-class-TypeImpl.md) | Concrete POJO implementations behind I{Type} |
| 6 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Enum constants matched against `validate annotation.Content` to select resolver |
| 7 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Generates correction proposals via `correct{Assignment}{Scope}()` |
| 8 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects stored in `list quickfixes popup` |
| 9 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers for entry/exit logging in {Type}IssueResolver |
| 10 | [{Language}Utility](uml-class-LanguageUtility.md) | Parsing/utility methods used by some {Type}IssueResolvers |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() → **{Type}Impl** getters for navigation
   - 2.3. matches validateDialog against **{Type}IssueTypes**.description
   - 2.4. instanceof **I{Type}** chain
   - 2.5. → **{Type}IssueResolver**.correct{Assignment}{Scope}(**I{Type}**) → returns ArrayList<**{Language}IssueProposal**>
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)

## Apply Quickfix Action

**Regex**: `^The {componentName} {componentType} apply quickfix action is performed as follows$`

This pattern applies when a step applies correction proposals to fix an invalid grammar element. The action navigates to a document and node, reads the prior validation result, generates corrections via {Type}IssueResolver, then applies the proposals by modifying the model directly via I{Type} setters or adding elements to ITestProject.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited base class providing `setCursorAtNode()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` + `addStepObject()` in applyProposal |
| 4 | [I{Type}](uml-class-IType.md) | Grammar element interfaces for instanceof type-checking + setters in applyProposal |
| 5 | [{Type}Impl](uml-class-TypeImpl.md) | Concrete POJO implementations behind I{Type} |
| 6 | [{Type}IssueTypes](uml-class-TypeIssueTypes.md) | Enum constants matched against `validate annotation.Content` to select resolver |
| 7 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Generates correction proposals via `correct{Assignment}{Scope}()` |
| 8 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects iterated in `applyProposal()` |
| 9 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers for entry/exit logging in {Type}IssueResolver |
| 10 | [{Language}Utility](uml-class-LanguageUtility.md) | Parsing/utility methods used by some {Type}IssueResolvers |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() → **{Type}Impl** getters for navigation
   - 2.3. matches validateDialog against **{Type}IssueTypes**.description
   - 2.4. instanceof **I{Type}** chain
   - 2.5. → **{Type}IssueResolver**.correct{Assignment}{Scope}(**I{Type}**) → returns ArrayList<**{Language}IssueProposal**>
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)
   - 2.6. → applyProposal(ArrayList<**{Language}IssueProposal**>)
     - → **{Language}IssueProposal**.getValue()
     - → **I{Type}**.setName() or **ITestProject**.addStepObject()

## List Proposals Action

**Regex**: `^The {componentName} {componentType} list proposals action is performed as follows$`

This pattern applies when a step generates content assist suggestions for a grammar element. The action navigates to a document and node, then delegates to {Type}IssueResolver.suggest to generate suggestions without requiring prior validation. The proposals are stored in `list proposals popup`.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited base class providing `setCursorAtNode()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [I{Type}](uml-class-IType.md) | Grammar element interfaces for instanceof type-checking |
| 5 | [{Type}Impl](uml-class-TypeImpl.md) | Concrete POJO implementations behind I{Type} |
| 6 | [{Type}IssueResolver](uml-class-TypeIssueResolver.md) | Generates suggestion proposals via `suggest{Assignment}{Scope}()` |
| 7 | [{Language}IssueProposal](uml-class-LanguageIssueProposal.md) | Proposal data objects stored in `list proposals popup` |
| 8 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers for entry/exit logging in {Type}IssueResolver |
| 9 | [{Language}Utility](uml-class-LanguageUtility.md) | Parsing/utility methods used by some {Type}IssueResolvers |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedAsFollows(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode() → **{Type}Impl** getters for navigation
   - 2.3. instanceof **I{Type}** chain
   - 2.4. → **{Type}IssueResolver**.suggest{Assignment}{Scope}(**I{Type}**) → returns ArrayList<**{Language}IssueProposal**>
     - → **{Language}LoggerFactory**.getLogger()
     - → **{Language}Utility**.get{Type}FullNameFor{Type}() (optional)

## Add Document Action

**Regex**: `^The {componentName} {componentType} add document action is performed to create a (TestSuite|StepObject) with$`

This pattern applies when a step creates a new top-level document (TestSuite or StepObject) in the workspace. The action sets cursor to workspace, then creates the document element via {Language}Builder.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited `add{Type}WithFullName()` helpers |
| 3 | [{Language}Builder](uml-class-LanguageBuilder.md) | Creates grammar elements via `create{Type}()` |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedToCreateA{Type}With(keyMap)
   - 2.1. → **TestObject{Language}Impl**.add{Type}WithFullName()
     - → **{Language}Builder**.create{Type}()

## Add Document Node Action

**Regex**: `^The {componentName} {componentType} add document node action is performed to add (Text|Table) at$`

This pattern applies when a step adds a Text or Table child element to an existing node. The action navigates to a document and node, then creates the child element via {Language}Builder.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited `setCursorAtNode()`, `addTextWithContent()`, `addTable()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [{Language}Builder](uml-class-LanguageBuilder.md) | Creates grammar elements via `createText()`, `createTable()` |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedToAdd{Type}At(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
   - 2.2. → **TestObject{Language}Impl**.setCursorAtNode()
   - 2.3. → **TestObject{Language}Impl**.addTextWithContent() or addTable()
     - → **{Language}Builder**.createText() or createTable()

## Edit Document Node Action

**Regex**: `^The {componentName} {componentType} edit document node action is performed to modify {Assignment} with$`

This pattern applies when a step adds a child element to a list within an existing node. The action navigates to a document and node, then creates the child element via {Language}Builder.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited `setCursorAtNode()`, `add{Type}With{Assignment}()` helpers |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [{Language}Builder](uml-class-LanguageBuilder.md) | Creates grammar elements via `create{Type}()` |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column
2. **{ObjectName}{ObjectType}Impl**.setPerformedToModify{Assignment}With(keyMap)
   - 2.1. → navigateToDocument() → **ITestProject**.getTestDocument()
   - 2.2. → navigateToNode() → **TestObject{Language}Impl**.setCursorAtNode()
   - 2.3. → **TestObject{Language}Impl**.add{Type}With{Assignment}()
     - → **{Language}Builder**.create{Type}()

## Decompose Fragment

**Regex**: `^The {componentName} file {componentName} {componentType} fragment will be decomposed as follows$`

This pattern applies when a step decomposes a grammar element's text into typed fragments using regex-based parsing. The impl creates a document via {Language}Builder, then delegates to the appropriate {Fragment}Fragments class to extract named groups. For fragments with typed values, the corresponding {Fragment}{Aspect}Types enum provides the description string.

| # | Class | Role |
|---|---|---|
| 1 | [{ObjectName}{ObjectType}Impl](uml-class-ObjectNameObjectTypeImpl.md) | Implementation in `src/test/java/org/farhan/impl/objects/`, extends TestObject{Language}Impl |
| 2 | [TestObject{Language}Impl](uml-class-TestObjectLanguageImpl.md) | Inherited `addTestSuiteWithFullName()`, `getFullNameFromPath()` |
| 3 | [ITestProject](uml-class-IType.md) | Navigate from workspace to document via `getTestDocument()` |
| 4 | [{Fragment}Fragments](uml-class-FragmentFragments.md) | Regex-based parsing class extracting named groups from text |
| 5 | [{Fragment}{Aspect}Types](uml-class-FragmentAspectTypes.md) | Enum constants providing description strings for typed fragment values |
| 6 | [{Language}Builder](uml-class-LanguageBuilder.md) | Creates grammar elements via `createTestProject()`, `createTestSuite()` |
| 7 | [{Language}LoggerFactory](uml-class-LanguageLoggerFactory.md) | Provides loggers for entry/exit logging in {Language}Builder |

### Sequence

1. **{ObjectName}{ObjectType}Impl**.set{CellName}(keyMap) — for each non-action column (stores input as property)
2. **{ObjectName}{ObjectType}Impl**.get{Fragment}{Aspect}FragmentDecomposedAsFollows(keyMap)
   - 2.1. → **ITestProject**.getTestDocument()
3. **{ObjectName}{ObjectType}Impl**.get{Fragment}{Aspect}Fragment{Column}(keyMap) — for each assertion column
   - 3.1. → **{Fragment}Fragments**.get{Aspect}() or get{Aspect}Desc()
   - 3.2. → **{Fragment}{Aspect}Types**.description (optional, when column is a type description)
