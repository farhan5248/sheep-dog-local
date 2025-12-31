# UML Class Patterns

## Pattern 1: IFeature.java files in org.farhan.dsl.lang package

All Grammar Elements have IFeature.java interfaces

All union types in the grammar follow the pattern:
- Base interface contains common attributes
- Child interfaces extend the base
- No discriminator methods (`is*()`, `getAs*()`)
- Type differentiation through inheritance hierarchy

TODO
all assignments contain setters and getters

---

## Pattern 2: FeatureUtility.java files in lang package

Some language features have derived attributes.
These derived attributes have getters in *Utility classes

---

## Pattern 3: LanguageBuilder.java file in lang package

There is a LanguageBuilder class for each language

---

## Pattern 4: FeatureIssueDetector, FeatureIssueTypes, FeatureIssueResolver triplets

TODO
Split into 3 for separate classes

---

## Pattern 5: LanguageIssueProposal exists in issues package

TODO put full code snippet here

```java
public class SheepDogIssueProposal {
    private String id;          // Unique identifier
    private String description; // Detailed explanation for user
    private String value;       // Actual text to insert

}
```

---

## Pattern 6: FeatureIssueTypes constants match .xtext attributes

All FeatureIssueTypes enums follow the naming convention exactly: constant value matches constant name, and constants correspond to grammar attributes or semantic properties. Descriptions are clear and user-friendly.

All issue constants follow the pattern of the feature followed by child feature followed by an optional ASPECT and then ONLY, FILE, WORKSPACE

Examples are
1. TEST_SUITE_NAME_ONLY for capitalization or regex checks
2. ROW_CELL_LIST_WORKSPACE for references check
3. TEST_STEP_NAME_FILE for first component requirement
4. TESTSTEP_NAME_STEP_DEFINITION_WORKSPACE

The names match the value of id attribute in the constructor

### TestSuiteIssueTypes

```java
TEST_SUITE_NAME("TEST_SUITE_NAME", "Name should start with a capital")
```
- Grammar attribute: `name=Title` in `TestSuite` ✓
- Constant value matches name: ✓

### TestStepContainerIssueTypes

```java
TEST_STEP_CONTAINER_NAME("TEST_STEP_CONTAINER_NAME", "Name should start with a capital")
```
- Grammar attribute: `name=Title` in `TestStepContainer` ✓
- Constant value matches name: ✓

### TestStepIssueTypes

```java
TESTSTEP_NAME_COMPONENT("TESTSTEP_NAME_COMPONENT", "The component 'The <name>,' is missing")
TESTSTEP_NAME_DETAILS("TESTSTEP_NAME_DETAILS", "The details '<name>' is missing")
TESTSTEP_NAME_OBJECT("TESTSTEP_NAME_OBJECT", "The object '<name>' is missing")
TESTSTEP_NAME_STATE("TESTSTEP_NAME_STATE", "The state '<state>' is missing")
TESTSTEP_NAME_TIME("TESTSTEP_NAME_TIME", "The time '<time>' is optional")
TESTSTEP_REFERENCE_COMPONENT("TESTSTEP_REFERENCE_COMPONENT", "The component doesn't exist...")
TESTSTEP_REFERENCE_STEP_OBJECT("TESTSTEP_REFERENCE_STEP_OBJECT", "The step object doesn't exist...")
TESTSTEP_REFERENCE_STEP_DEFINITION("TESTSTEP_REFERENCE_STEP_DEFINITION", "The step definition doesn't exist...")
```
- Grammar attribute: `name=Title` ✓
- Semantic validation for references ✓
- Constant values match names: ✓

### CellIssueTypes

```java
CELL_NAME("CELL_NAME", "Name should start with a capital")
```
- Grammar attribute: `name=Title` in `Cell` ✓
- Constant value matches name: ✓

### RowIssueTypes

```java
ROW_REFERENCE_CELL_LIST("ROW_REFERENCE_CELL_LIST", "The step parameters don't exist or the cell names don't match")
```
- Grammar attribute: `cellList+=Cell+` in `Row` ✓
- Constant value matches name: ✓

---

## Pattern 7: FeatureIssueDetector has validateISSUENAME methods

All detector classes follow the `validateISSUENAME` pattern. 
Method names match the grammar attributes they validate like `validateNameOnly` or `validateCellListWorkspace`

### TestSuiteIssueDetector

```java
public static String validateNameOnly(ITestSuite testSuite)
```
- Validates: `name` attribute ✓

### TestStepContainerIssueDetector

```java
public static String validateNameOnly(ITestStepContainer testStepContainer)
```
- Validates: `name` attribute ✓

### TestStepIssueDetector

```java
public static String validateNameOnly(ITestStep step)
public static String validateNameWorkspace(ITestStep step)
```
- Validates: `name` attribute and semantic references ✓

### CellIssueDetector

```java
public static String validateName(ICell cell)
```
- Validates: `name` attribute ✓

### RowIssueDetector

```java
public static String validateCellListWorkspace(IRow row)
```
- Validates: `cellList` reference integrity ✓

---

## Pattern 8: FeatureIssueResolver has propose* for some validate*

All resolver classes follow the `proposeISSUENAME` pattern. 
Not all issues have a resolution, some have no corresponding propose* method.
Method names match the grammar attributes they validate like `proposeNameOnly` or `proposeCellListWorkspace`

### TestStepIssueResolver: COMPLETE ✓

```java
// For validateName(ITestStep)
public static ArrayList<SheepDogIssueProposal> proposeName(ITestStep testStep, ITestProject testProject) ✓

// For validateReference(ITestStep)
public static ArrayList<SheepDogIssueProposal> proposeReference(ITestStep testStep) ✓
```

### RowIssueResolver: COMPLETE ✓

```java
// For validateReference(IRow)
public static ArrayList<SheepDogIssueProposal> proposeCellList(IRow row) ✓
```

---

## Pattern 9: SheepDogValidator has check* for every validate*

Only elements with validation infrastructure (Detector/Types) have check methods. 

There should be one check method for each validate method: ONLY issues will be FAST checks, FILE will be NORMAL, WORKSPACE will be EXPENSIVE.

### TODO

- Move Row validation to checkRow

---

## Pattern 10: SheepDogValidator constants match FeatureIssueTypes enums

The Validator contains constants for issues that have quick fixes. 
Missing constants are for warnings/informational messages that don't require fixes. 
The pattern is: only create constants for issues that will have `@Fix` annotations.

---

## Pattern 11: SheepDogQuickfixProvider has fix* methods for each SheepDogValidator check*

There doesn't need to be a fix* method for every check* method.
If a fix* method exists, there must be a corresponding check* method.
Just because there is a check* method, doesn't mean a fix* method has to exist.

---

## Pattern 12: All @Fix annotations in QuickfixProvider exist in SheepDogValidator

There can be multiple @Fix annotations for one fix* method.
Each of those annotations must exist in SheepDogValidator.

Method names follow the convention fix{CamelCase} corresponding to @Fix annotation constants in {UPPER_SNAKE_CASE} format.

---

## Pattern 13: fix* methods invoke FeatureIssueResolver.propose* methods

---

## Pattern 14: completeFeature_Attribute methods invoke helper complete* methods

All `completeFeature_Attribute` methods either invoke a helper method (`completeName`) or directly invoke the IssueResolver (`proposeCellList`). The pattern is consistently followed - the goal is to avoid duplicating business logic across multiple complete methods.

---

## Pattern 15: complete* helper methods invoke FeatureIssueResolver.propose* methods

Both helper/complete methods properly delegate to their corresponding `IssueResolver.propose*` methods. The pattern ensures that proposal logic is centralized in Resolver classes and reused across content assist and quick fixes.

---

## Pattern 16: IFeature.java files in org.farhan.dsl.lang package Meta-Attributes

**Meta-attributes** are interface methods that do NOT correspond to grammar attributes but provide essential functionality for navigation, computation, and metadata management.
**Helper methods** provide factory, lookup, and utility functionality not directly from grammar.

```
Interface Methods = Grammar Attributes + Meta-Attributes + Helper Methods
```

1. **All interfaces have grammar attributes**: Every grammar attribute gets a getter/setter
2. **All interfaces have parent meta-attributes**: Root elements parent is the collection of all root elements TestProject
3. **Top-level interfaces have qualified names**: TestSuite, StepObject
4. **name attributes have long names**: StepDefinition, TestStep
5. **Root interfaces have resource tracking**: Model has resourceName
6. **Setters follow getters**: Every getter has a corresponding setter
7. **Strongly typed parents**: Parent type matches containment hierarchy or Object if there is no common parent like Table or StatementList


### Meta-Attributes

#### 1. **Navigation Attributes** (Parent References)

Every non-root interface has `getParent()`/`setParent()` methods, even though "parent" never appears in the grammar.
Apply lazy parent initialization.

**Examples**:
```java
// ITestSuite.java - Parent is ITestProject
ITestProject getParent();
void setParent(ITestProject value);

// ITestStepContainer.java - Parent is ITestSuite
ITestSuite getParent();
void setParent(ITestSuite value);

// IStepDefinition.java - Parent is IStepObject
IStepObject getParent();
void setParent(IStepObject value);

// ITable.java - Parent is ITestStep
ITestStep getParent();
void setParent(ITestStep value);
```

**Purpose**: Enable bidirectional tree traversal without requiring grammar-level containment references.

#### 2. **Name Attributes** (Derived Values)

Step-like elements have extended name formats:

**Grammar** (StepDefinition has only simple name):
```xtext
StepDefinition:
    '==' 'Step-Definition:' name=Title EOL
    // No nameLong attribute
```
**Examples**:

```java
// IStepDefinition.java and ITestStep.java
String getNameLong();              // NOT in grammar
void setNameLong(String value);
```

### Helper Methods

#### 1. **Factory Methods** (create* pattern)

Create child elements programmatically:

```java
// ITestSuite.java
ITestCase createTestCase(String name);
ITestStepContainer createTestSetup(String name);
```

#### 2. **Lookup Methods** (get* pattern)

Every grammar list must have up to 3 helper methods with these signatures:

1. `getX(int index)` - **REQUIRED** for ALL lists (zero-based indexing)
2. `getX(String name)` - For lists of elements with `name=Title` grammar attribute
3. `getX(String qualifiedName)` - For top-level lists (TestSuite, StepObject in ITestProject)

---