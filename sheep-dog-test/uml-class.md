# UML Class Patterns

## IFeature

### All grammar features have IFeature.java interfaces

All union types in the grammar follow the pattern:
- Base interface contains common attributes
- Child interfaces extend the base
- No discriminator methods (`is*()`, `getAs*()`)
- Type differentiation through inheritance hierarchy. Parent type matches containment hierarchy or Object if there is no common parent like Table or StatementList

### Each non grammar list attribute has a getter/setter

### Each grammar list attribute has up to 3 getters

Every grammar list must have up to 3 helper methods with these signatures:

1. `getX(int index)` - **REQUIRED** for ALL lists (zero-based indexing)
2. `getX(String name)` - For lists of elements with `name=Title` grammar attribute
3. `getX(String qualifiedName)` - For top-level lists (TestSuite, StepObject in ITestProject)

### Navigation Attributes Parent References

Every non-root interface has `getParent()` methods, even though "parent" never appears in the grammar.
Apply lazy parent initialization.

### Top-level interfaces have qualified names

### Derived Name Attributes

Step-like elements have extended name formats:

```xtext
StepDefinition:
    '==' 'Step-Definition:' name=Title EOL
    // No nameLong attribute
```

#### NameLong Attribute Example

```java
// IStepDefinition.java and ITestStep.java
String getNameLong();              // NOT in grammar
void setNameLong(String value);
```

## FeatureUtility

Some language features have derived attributes.
These derived attributes have getters in *Utility classes

## LanguageBuilder

There is a LanguageBuilder class for each language

## FeatureIssueDetector

## FeatureIssueTypes

## FeatureIssueResolver

## LanguageIssueProposal

```java
public class SheepDogIssueProposal {
    private String id;          // Unique identifier
    private String description; // Detailed explanation for user
    private String value;       // Actual text to insert

}
```

## FeatureIssueTypes Naming Convention

All FeatureIssueTypes enums follow the naming convention exactly: constant value matches constant name, and constants correspond to grammar attributes or semantic properties. Descriptions are clear and user-friendly.

All issue constants follow the pattern of the feature followed by child feature followed by an optional ASPECT and then ONLY, FILE, WORKSPACE

Examples are
1. TEST_SUITE_NAME_ONLY for capitalization or regex checks
2. ROW_CELL_LIST_WORKSPACE for references check
3. TEST_STEP_NAME_FILE for first component requirement
4. TESTSTEP_NAME_STEP_DEFINITION_WORKSPACE

The names match the value of id attribute in the constructor

### TestStepContainerIssueTypes

```java
TEST_STEP_CONTAINER_NAME("TEST_STEP_CONTAINER_NAME", "Name should start with a capital")
```

### RowIssueTypes

```java
ROW_REFERENCE_CELL_LIST("ROW_REFERENCE_CELL_LIST", "The step parameters don't exist or the cell names don't match")
```

## FeatureIssueDetector Validation Methods

All detector classes follow the `validateISSUENAME` pattern. 
Method names match the grammar attributes they validate like `validateNameOnly` or `validateCellListWorkspace`

### TestStepIssueDetector

```java
public static String validateNameOnly(ITestStep step)
public static String validateNameWorkspace(ITestStep step)
```

### RowIssueDetector

```java
public static String validateCellListWorkspace(IRow row)
```

## FeatureIssueResolver Proposal Methods

All resolver classes follow the `proposeISSUENAME` pattern. 
Not all issues have a resolution, some have no corresponding propose* method.
Method names match the grammar attributes they validate like `proposeNameOnly` or `proposeCellListWorkspace`

### TestStepIssueResolver

```java
// For validateName(ITestStep)
public static ArrayList<SheepDogIssueProposal> proposeName(ITestStep testStep, ITestProject testProject) ✓

```

### RowIssueResolver

```java
// For validateReference(IRow)
public static ArrayList<SheepDogIssueProposal> proposeCellList(IRow row) ✓
```
