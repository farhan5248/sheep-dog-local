# I{Language}Factory

## Factory interface defines create{Type}() methods

All factory interfaces follow the `create{Type}()` pattern where each grammar type has a corresponding create method.

**Method Naming Pattern**: `create{Type}()`
- **{Type}**: The grammar type to create (e.g., StepDefinition, TestCase, Cell)
- Methods have NO parameters - they create empty instances
- Caller is responsible for setting attributes and adding to parent

**Method Signature Rules**:
- **Return Type**: MUST return interface type I{Type}, never EMF type {Type}
- **Parameters**: MUST have no parameters (parameterless)
- **Modifier**: Interface methods have no modifiers (implicitly public abstract)

**Examples**

- ISheepDogFactory

```java
// Creates empty instances of grammar types
IStepDefinition createStepDefinition()
IStepObject createStepObject()
IStepParameters createStepParameters()
ITestCase createTestCase()
ITestProject createTestProject()
ITestSetup createTestSetup()
ITestStep createTestStep()
ITestSuite createTestSuite()
IStatement createStatement()
ITable createTable()
IRow createRow()
ICell createCell()
```

## Factory creates empty instances without setting attributes

Factory methods create standalone element instances with no attributes set. This follows the EMF factory pattern where factories create empty instances and builders set attributes.

The {Language}Builder is responsible for:
- Setting attributes on created instances
- Adding instances to their parent containers

**Examples**

- Typical usage pattern

```java
// Factory creates empty instance
ITestCase testCase = SheepDogFactory.instance.createTestCase();

// Builder sets attributes and adds to parent
SheepDogBuilder.createTestCase(testSuite, "My Test Case");
```
