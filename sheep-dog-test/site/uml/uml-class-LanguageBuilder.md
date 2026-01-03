# {Language}Builder

## All Builder methods are static factory methods

All methods follow the pattern `create{Feature}(I{Parent} parent, {params})` and return the created {Feature} instance.

**Examples**

- SheepDogBuilder

```java
public static IStepObject createStepObject(ITestProject parent, String qualifiedName)
public static IStepDefinition createStepDefinition(IStepObject parent, String name)
public static ITestStep createTestStep(ITestStepContainer parent, String name)
```

## Builder methods check for existence before creating

Most methods check if the element already exists in the parent before creating a new instance, except for TestStep which allows duplicates.

**Examples**

- SheepDogBuilder

```java
public static IStepDefinition createStepDefinition(IStepObject parent, String name)
public static ITestStep createTestStep(ITestStepContainer parent, String name)
```

## Builder methods automatically add to parent

After creating an instance via SheepDogFactory, the builder automatically adds it to the parent collection.

**Examples**

- SheepDogBuilder

```java
public static IStepDefinition createStepDefinition(IStepObject parent, String name)
```

## Builder provides convenience methods for complex creation

Some methods create multiple related elements in a single call.

**Examples**

- SheepDogBuilder

```java
public static IStepObject createTestStepReferencedElements(ITestStep theTestStep)
```
