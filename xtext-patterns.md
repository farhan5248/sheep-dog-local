# Xtext Patterns in Sheep Dog Project

This document provides a comprehensive analysis of patterns, conventions, and architectural decisions in the sheep-dog-local Xtext implementation.

## Table of Contents
1. [File Structure and Organization](#file-structure-and-organization)
2. [Naming Conventions](#naming-conventions)
3. [Architectural Patterns](#architectural-patterns)
4. [Component Relationships](#component-relationships)
5. [Code Conventions](#code-conventions)
6. [Key Architectural Decisions](#key-architectural-decisions)
7. [Pattern Relationship Matrix](#pattern-relationship-matrix)
8. [Key Takeaways](#key-takeaways)

---

## File Structure and Organization

### Grammar Layer (1 file)
- **SheepDog.xtext**: Defines the complete DSL grammar
  - Two main model types: `StepObject` and `TestSuite`
  - Hierarchical structure: `TestSuite` → `TestStepContainer` → `TestStep` → `Table`/`Text`

### Interface Layer - org.farhan.dsl.lang (18 files)
Core domain model interfaces defining the language API:
- **Core Elements**: `ITestProject`, `ITestSuite`, `ITestStepContainer`, `ITestCase`, `ITestSetup`
- **Step Elements**: `ITestStep`, `IStepObject`, `IStepDefinition`, `IStepParameters`
- **Data Elements**: `ITable`, `IRow`, `ICell`, `IStatement`, `ITestData`
- **Utilities**: `TestStepUtility`, `StatementUtility`, `StepObjectBuilder`
- **Support**: `IResourceRepository`

### Implementation Layer - org.farhan.dsl.sheepdog.impl (14 files)
Xtext-specific implementations wrapping generated EMF objects:
- `TestStepImpl`, `TestSuiteImpl`, `TestStepContainerImpl`, `CellImpl`, `RowImpl`
- `TestProjectImpl`, `StepObjectImpl`, `StepDefinitionImpl`
- `TableImpl`, `StatementImpl`, `TestCaseImpl`, `TestSetupImpl`
- `SourceFileRepository` (file system access)

### Issues/Validation Layer - org.farhan.dsl.issues (13 files)
Semantic validation organized by grammar element:
- **Detectors** (5): `TestStepIssueDetector`, `TestSuiteIssueDetector`, `TestStepContainerIssueDetector`, `RowIssueDetector`, `CellIssueDetector`
- **Resolvers** (3): `TestStepIssueResolver`, `RowIssueResolver`
- **Types** (5): `TestStepIssueTypes`, `TestSuiteIssueTypes`, `TestStepContainerIssueTypes`, `CellIssueTypes`, `RowIssueTypes`
- **Support**: `SheepDogIssueProposal` (DTO for IDE proposals)

### IDE Integration Layer (3 files)
- **SheepDogValidator.java**: Custom validation rules using `@Check` annotations
- **SheepDogProposalProvider.java**: Content assist/autocomplete
- **SheepDogQuickfixProvider.java**: Quick fixes using `@Fix` annotations

---

## Naming Conventions

### Consistent Suffix Pattern
- `*Impl` - Implementation classes wrapping EMF objects
- `*IssueDetector` - Validation logic classes
- `*IssueResolver` - Proposal generation logic
- `*IssueTypes` - Enum defining issue codes and descriptions
- `*Utility` - Static helper methods
- `I*` prefix - Interface definitions

### Grammar Element to Class Mapping
```
Grammar: TestStep
  ↓ Interface: ITestStep
  ↓ Implementation: TestStepImpl
  ↓ Validation: TestStepIssueDetector
  ↓ Resolution: TestStepIssueResolver
  ↓ Issue Types: TestStepIssueTypes
```

### Examples
| Grammar Element | Interface | Implementation | Detector | Resolver | Types |
|----------------|-----------|----------------|----------|----------|-------|
| `TestStep` | `ITestStep` | `TestStepImpl` | `TestStepIssueDetector` | `TestStepIssueResolver` | `TestStepIssueTypes` |
| `Cell` | `ICell` | `CellImpl` | `CellIssueDetector` | - | `CellIssueTypes` |
| `Row` | `IRow` | `RowImpl` | `RowIssueDetector` | `RowIssueResolver` | `RowIssueTypes` |

---

## Architectural Patterns

### 1. Bridge Pattern (Interface + Implementation)

**Consistent Bridge Structure:**
```java
// Interface (framework-independent)
public interface ITestStep {
    String getName();
    ITestStepContainer getParent();
    ITable getTable();
    void setParent(ITestStepContainer parent);
}

// Implementation (Xtext wrapper)
public class TestStepImpl implements ITestStep {
    private TestStep eObject;  // EMF-generated object
    private ITestStepContainer parent;

    public TestStepImpl(TestStep eObject) {
        this.eObject = eObject;
    }

    @Override
    public String getName() {
        return eObject.getName().getValue();
    }

    @Override
    public ITestStepContainer getParent() {
        if (parent == null) {
            // Lazy initialization using EMF containment
            if (eObject.eContainer() instanceof TestCase) {
                parent = new TestCaseImpl((TestCase) eObject.eContainer());
            } else {
                parent = new TestSetupImpl((TestSetup) eObject.eContainer());
            }
        }
        return parent;
    }
}
```

**Key Characteristics:**
- Interfaces define domain model independent of Xtext/EMF
- Implementations wrap Xtext-generated EMF objects
- Parent relationships managed through interfaces (bidirectional navigation)
- Lazy initialization pattern for parent relationships using `eContainer()`

### 2. Three-Tier Validation Architecture

**Structure:**
```
1. Detector Classes (Pure validation logic)
   ↓
2. Issue Types Enums (Error codes and messages)
   ↓
3. Validator Class (Xtext integration with @Check)
```

**Example:**
```java
// 1. Detector - Pure validation logic
public class TestStepIssueDetector {
    public static String validateName(ITestStep step) {
        if (!TestStepUtility.hasComponent(step.getName())) {
            return TestStepIssueTypes.TESTSTEP_NAME_COMPONENT.getValue();
        }
        return "";  // Empty = valid
    }
}

// 2. Issue Types - Error definitions
public enum TestStepIssueTypes {
    TESTSTEP_NAME_COMPONENT(
        "TESTSTEP_NAME_COMPONENT",
        "The component 'The <name>,' is missing"
    );

    private String value;
    private String description;

    // Constructor, getters...
}

// 3. Validator - Xtext integration
public class SheepDogValidator extends AbstractSheepDogValidator {
    public static final String TESTSTEP_NAME_COMPONENT = "TESTSTEP_NAME_COMPONENT";

    @Check(CheckType.EXPENSIVE)
    public void checkTestStep(TestStep step) {
        ITestStep iStep = new TestStepImpl(step);
        String problems = TestStepIssueDetector.validateName(iStep);
        if (!problems.isEmpty()) {
            warning(problems, SheepDogPackage.Literals.TEST_STEP__NAME,
                    TESTSTEP_NAME_COMPONENT);
        }
    }
}
```

**NOTE**
Problems should be passed on warning(problems, SheepDogPackage.Literals.TEST_STEP__NAME, problems);

**Validation Levels (CheckType):**
- `CheckType.FAST` - Element validation (e.g., Cell capitalization)
- `CheckType.NORMAL` - File validation (e.g., TestStepContainer names)
- `CheckType.EXPENSIVE` - Workspace validation involving cross-references (e.g., TestStep reference validation)

### 3. Two-Stage Proposal System

**Structure:**
```
1. Resolver Classes (Business logic for proposals)
   ↓
2. Proposal Provider (Xtext content assist integration)
```

**Example:**
```java
// 1. Resolver - Generate proposals
public class TestStepIssueResolver {
    public static ArrayList<SheepDogIssueProposal> proposeName(
            ITestStep testStep, ITestProject testProject) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        for (IStepObject stepObject : testProject.getStepObjects()) {
            for (IStepDefinition stepDef : stepObject.getStepDefinitions()) {
                SheepDogIssueProposal p = new SheepDogIssueProposal();
                p.setId(stepObject.getName() + "." + stepDef.getName());
                p.setValue(buildStepName(stepObject, stepDef));
                p.setDescription("Use step: " + p.getValue());
                proposals.add(p);
            }
        }

        return proposals;
    }
}

// 2. Proposal Provider - IDE integration
public class SheepDogProposalProvider extends AbstractSheepDogProposalProvider {
    @Override
    public void completeGiven_Name(EObject model, Assignment assignment,
            ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        super.completeGiven_Name(model, assignment, context, acceptor);
        completeName((TestStep) model, assignment, context, acceptor);
    }

    private void completeName(TestStep step, Assignment assignment,
            ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        ITestStep iTestStep = new TestStepImpl(step);
        ITestProject testProject = /* ... get project ... */;

        for (SheepDogIssueProposal p : TestStepIssueResolver.proposeName(iTestStep, testProject)) {
            ConfigurableCompletionProposal proposal =
                (ConfigurableCompletionProposal) createCompletionProposal(
                    p.getValue(), p.getDescription(), null, context);
            acceptor.accept(proposal);
        }
    }
}
```

**Proposal Data Structure:**
```java
public class SheepDogIssueProposal {
    private String id;          // Unique identifier
    private String description; // Detailed explanation for user
    private String value;       // Actual text to insert

    // Getters and setters...
}
```

### 4. Quick Fix Pattern

**Structure:**
```
1. Define constant in Validator
   ↓
2. Use constant in validation
   ↓
3. Create fix method with @Fix annotation
   ↓
4. Implement IModification to modify document
```

**Example:**
```java
// 1. Constant definition
public class SheepDogValidator extends AbstractSheepDogValidator {
    public static final String TESTSTEP_REFERENCE_STEP_OBJECT =
        "TESTSTEP_REFERENCE_STEP_OBJECT";

    // 2. Use in validation
    @Check(CheckType.EXPENSIVE)
    public void checkTestStep(TestStep step) {
        String problems = TestStepIssueDetector.validateReference(iStep);
        if (!problems.isEmpty()) {
            warning(problems, SheepDogPackage.Literals.TEST_STEP__NAME,
                    TESTSTEP_REFERENCE_STEP_OBJECT);
        }
    }
}

// 3. Fix method with @Fix annotation
public class SheepDogQuickfixProvider extends DefaultQuickfixProvider {
    @Fix(SheepDogValidator.TESTSTEP_REFERENCE_STEP_OBJECT)
    @Fix(SheepDogValidator.TESTSTEP_REFERENCE_STEP_DEFINITION)
    public void fixTestStepReference(final Issue issue, IssueResolutionAcceptor acceptor) {
        // 4. Implement modifications
        IModificationContext context = /* ... */;
        IXtextDocument document = context.getXtextDocument();

        TestStep step = /* ... get element ... */;
        ArrayList<SheepDogIssueProposal> proposals =
            TestStepIssueResolver.proposeReference(new TestStepImpl(step));

        for (SheepDogIssueProposal p : proposals) {
            acceptor.accept(issue, p.getDescription(), p.getDescription(), null,
                new IModification() {
                    @Override
                    public void apply(IModificationContext context) {
                        // Replace text in document
                        document.replace(offset, length, p.getValue());
                    }
                });
        }
    }
}
```

**Two Fix Types:**
- **Selected file updates**: Capitalize names, rename references
- **Workspace file updates**: Create missing step definitions using `SheepDogGenerator`

---

## Component Relationships

### Grammar → Validation → IDE Features Flow

```
SheepDog.xtext (Grammar Definition)
    ↓
Generated EMF Model (TestStep, Cell, Row, etc.)
    ↓
Implementation Layer (*Impl classes) ← Interface Layer (I* interfaces)
    ↓
Issue Detection Layer (*IssueDetector, *IssueTypes)
    ↓
Issue Resolution Layer (*IssueResolver, SheepDogIssueProposal)
    ↓
IDE Integration (Validator, ProposalProvider, QuickfixProvider)
```

### Dependency Relationships (Bottom-Up)

1. **Grammar Layer**: No dependencies (pure Xtext)
2. **Interface Layer**: No Xtext dependencies (framework-independent)
3. **Implementation Layer**: Depends on interfaces + generated Xtext/EMF code
4. **Issues Layer**: Depends on interfaces only
5. **IDE Layer**: Depends on implementations, issues, and Xtext UI APIs

**Cross-Cutting Utilities:**
- `TestStepUtility`: Complex regex parsing of test step syntax
- `StatementUtility`: Tag and documentation extraction
- Both used by detectors, resolvers, and implementations

### Grammar Element Hierarchy

```
Model
├── StepObject
│   ├── Statement[]
│   └── StepDefinition[]
│       ├── Statement[]
│       └── StepParameters[]
│           ├── StatementList
│           └── Table
└── TestSuite
    ├── Statement[]
    └── TestStepContainer[] (TestSetup | TestCase)
        ├── Statement[]
        ├── TestStep[] (Given | When | Then | And)
        │   ├── name: Title
        │   ├── table?: Table
        │   └── text?: Text
        └── TestData[] (TestCase only)
            ├── StatementList
            └── Table
                └── Row[]
                    └── Cell[]
```

---

## Code Conventions

### Package Organization

```
org.farhan.dsl.sheepdog/           # Xtext-specific code
├── sheepdog/                      # Grammar and generated code
│   ├── SheepDog.xtext            # Grammar definition
│   ├── validation/               # Xtext validator integration
│   ├── impl/                     # EMF wrapper implementations
│   └── generator/                # Code generation
├── ui.contentassist/             # Content assist providers
└── ui.quickfix/                  # Quick fix providers

org.farhan.dsl/                    # Framework-independent code
├── lang/                         # Domain model interfaces
├── issues/                       # Validation and proposals
└── types/                        # Enums for DSL keywords
```

### Method Naming Patterns

**Validation Methods:**
- Pattern: `validate<Aspect>(I<Element>)` returns `String`
- Empty string = valid, error description = invalid
- Examples: `validateName()`, `validateReference()`

**Proposal Methods:**
- Pattern: `propose<Aspect>(I<Element>)` returns `ArrayList<SheepDogIssueProposal>`
- Examples: `proposeName()`, `proposeReference()`, `proposeCellList()`

**Utility Methods:**
- `get<Property>(String text)` - Extract part from text
- `has<Property>(String text)` - Check if property exists
- `is<Type>(String text)` - Check type/category

**Content Assist Hooks:**
- Pattern: `complete<Rule>_<Feature>()`
- Override Xtext-generated stubs
- Examples: `completeGiven_Name()`, `completeRow_CellList()`

**Quick Fix Hooks:**
- Pattern: `fix<ProblemType>()` with `@Fix(ISSUE_CONSTANT)`
- Examples: `fixTestStepReference()`, `fixTestStepName()`, `fixCellName()`

### Constant Naming

**Issue Code Constants (in Validator):**
- Uppercase with underscores
- Pattern: `<ELEMENT>_<ASPECT>`
- Examples: `TESTSTEP_REFERENCE_STEP_OBJECT`, `CELL_NAME`, `TEST_SUITE_NAME`

**Enum Values:**
- `value` field - User-facing string (matches constant name)
- `description` field - Detailed help text

### Logging Pattern

**Consistent throughout:**
```java
private static final Logger logger = LoggerFactory.getLogger(ClassName.class);

public String validateName(ITestStep step) {
    logger.debug("Entering validateName for step: {}",
                 step != null ? step.getName() : "null");
    try {
        // ... validation logic ...
        logger.debug("Exiting validateName");
        return result;
    } catch (Exception e) {
        logger.error("Failed in validateName for '{}': {}",
                     step.getName(), e.getMessage(), e);
        throw e;
    }
}
```

---

## Key Architectural Decisions

### 1. Interface-Based Domain Model

**Decision:** Create framework-independent interfaces (`I*`) separate from Xtext implementation.

**Benefits:**
- Domain logic in `org.farhan.dsl.lang` and `org.farhan.dsl.issues` has no Xtext dependencies
- Same validation/resolution logic can be reused across different contexts (Eclipse, CLI, cloud)
- Easier testing without Xtext infrastructure
- Clear separation of concerns

**Evidence:** All `*IssueDetector` and `*IssueResolver` classes work with interfaces, never EMF objects directly.

### 2. String-Based Error Returns

**Decision:** Validation methods return empty string for success, error description for failure.

**Rationale:**
- Simple to understand and implement
- Error message doubles as success indicator
- Easy integration with Xtext validation API

**Note:** Code contains TODOs suggesting migration to enum-based return types for better type safety.

### 3. Regex-Based DSL Parsing

**Decision:** Use complex regex patterns in `TestStepUtility` to parse test step syntax.

**Key Regex:**
```java
public static final String REGEX =
    "The" + "(" + COMPONENT_REGEX + ")?" + OBJECT_REGEX + PREDICATE_REGEX;
```

**Parsed Structure:**
- **Component**: "The Application service,"
- **Object**: "Home page"
- **Predicate**: "Section fragment will be present"
  - Details: "Section fragment" (optional)
  - State: "will be present" (mandatory)
  - Time: (optional)

**Trade-offs:**
- **Pro**: Flexible syntax, powerful parsing
- **Con**: Complex regex, harder to maintain
- **Evidence**: 18 regex group extractions with specific indexes

**NOTE**
Update this after name into 3 regex

### 4. Lazy Parent Initialization

**Decision:** Parent relationships initialized lazily using `eContainer()`.

**Pattern in *Impl classes:**
```java
public ITestStepContainer getParent() {
    if (parent == null) {
        if (eObject.eContainer() instanceof TestCase) {
            parent = new TestCaseImpl((TestCase) eObject.eContainer());
        } else {
            parent = new TestSetupImpl((TestSetup) eObject.eContainer());
        }
    }
    return parent;
}
```

**Benefits:**
- Avoids circular initialization issues
- Works with EMF's containment hierarchy
- Memory efficient

### 5. Three-Level Validation Strategy

**Decision:** Separate validation into three concern levels.

**Structure:**
1. **Syntax Validation** (Fast) - Grammar enforces basic structure
2. **Semantic Validation** (Normal/Expensive) - Custom validators check business rules
3. **Reference Validation** (Expensive) - Cross-file references, requires full project model

**Examples:**
- **Fast**: Cell names must start with uppercase
- **Normal**: TestStepContainer names must start with uppercase
- **Expensive**: TestStep must reference existing StepObject/StepDefinition

**Performance:** CheckType guides when validation runs (on-type vs. on-save vs. on-demand).

### 6. Dual-Purpose Issue Classes

**Decision:** Same classes serve both validation and content assist.

**Pattern:**
- `*IssueDetector` - Used by Validator to find problems
- `*IssueResolver` - Used by ProposalProvider to suggest fixes AND by QuickfixProvider

**Benefits:**
- Validation errors automatically have associated fixes
- Content assist suggests valid values, preventing errors
- Centralized business logic

**Example:** `TestStepIssueResolver.proposeName()` used by both:
1. Content assist while typing
2. Quick fix when reference is invalid

**NOTE**
Confirm if this is true. The class is used but not the method

### 7. Component-Based Code Organization

**Decision:** Organize validation by grammar component, not by validation type.

**Pattern:**
```
TestStep validation:
  - TestStepIssueDetector (all TestStep validations)
  - TestStepIssueResolver (all TestStep proposals)
  - TestStepIssueTypes (all TestStep error codes)
```

**Not Used:**
```
Validation type organization:
  - IssueDetector (all detectors)
  - IssueResolver (all resolvers)
  - IssueTypes (all types)
```

**Benefits:**
- High cohesion - all TestStep concerns in one place
- Easy to find related code
- Natural alignment with grammar structure

---

## Pattern Relationship Matrix

| Grammar Element | Interface | Implementation | Detector | Resolver | Types | Validator Check |
|----------------|-----------|----------------|----------|----------|-------|----------------|
| TestSuite | ITestSuite | TestSuiteImpl | TestSuiteIssueDetector | - | TestSuiteIssueTypes | checkTestSuite (FAST) |
| TestStepContainer | ITestStepContainer | TestStepContainerImpl | TestStepContainerIssueDetector | - | TestStepContainerIssueTypes | checkTestStepContainer (NORMAL) |
| TestStep | ITestStep | TestStepImpl | TestStepIssueDetector | TestStepIssueResolver | TestStepIssueTypes | checkTestStep (EXPENSIVE) |
| Row | IRow | RowImpl | RowIssueDetector | RowIssueResolver | RowIssueTypes | - |
| Cell | ICell | CellImpl | CellIssueDetector | - | CellIssueTypes | checkCell (FAST) |

---

## Key Takeaways

1. **Separation of Concerns**: Grammar → Interface → Implementation → Validation → IDE
2. **Framework Independence**: Core domain logic has no Xtext dependencies
3. **Validation Levels**: Fast (syntax) → Normal (semantics) → Expensive (references)
4. **Dual-Purpose Classes**: Issue classes serve both validation and content assist
5. **Bridge Pattern**: Interfaces abstract EMF-generated code
6. **Component Organization**: All concerns for a grammar element grouped together
7. **Regex-Based Parsing**: Complex test step syntax parsed via regex utilities
8. **Lazy Initialization**: Parent relationships loaded on-demand
9. **String-Based Validation**: Empty string = success, description = error (with TODO to improve)
10. **Proposal System**: Structured proposals with id, description, and value fields

---

This analysis provides a comprehensive foundation for understanding and extending the Xtext implementation in the sheep-dog-local project. The patterns are consistent, well-organized, and follow clear architectural principles throughout the codebase.
