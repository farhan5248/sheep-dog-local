# {Language}Factory

## Factory is a singleton accessed via static instance field

The factory class holds a static instance field that references the concrete implementation. This allows language-independent code to create elements without knowing the specific implementation.

**Examples**

- SheepDogFactory

```java
public static ISheepDogFactory instance;
```

## Factory creates elements without adding to parent

Unlike {Language}Builder which creates and adds elements to parents, the factory creates standalone element instances. The caller is responsible for adding them to the appropriate parent.

**Methods**
- `create{Type}({params})`

**Examples**

- SheepDogFactory (via ISheepDogFactory interface)

```java
IStepDefinition createStepDefinition(String name)
IStepObject createStepObject(String qualifiedName)
IStepParameters createStepParameters(IRow row)
IStepParameters createStepParameters(IText value)
ITestCase createTestCase(String name)
ITestProject createTestProject()
ITestSetup createTestSetup(String name)
ITestStep createTestStep(String name)
ITestSuite createTestSuite(String qualifiedName)
```
