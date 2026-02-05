# I{Type}

## ALL method names follow accessor patterns

All methods in I{Type} interfaces must follow standard accessor naming conventions:
- Getters: start with 'get' + PascalCase attribute name
- Setters: start with 'set' + PascalCase attribute name
- Adders: start with 'add' + PascalCase attribute name

**Regex Filters** (method must match at least one):
1. `^get[A-Z][a-zA-Z0-9]*$` - Getter methods
2. `^set[A-Z][a-zA-Z0-9]*$` - Setter methods
3. `^add[A-Z][a-zA-Z0-9]*$` - Adder methods for list attributes

**Examples**

```java
// Single-value attribute accessors
String getName()
void setName(String value)

// List attribute accessors
ICell getCell(int index)          // By index
ICell getCell(String name)        // By name
List<ICell> getCellList()         // Full list
boolean addCell(ICell value)      // Add to list

// Parent reference accessor
IRow getParent()

// Derived attribute accessor
String getNameLong()
```

## SOME interface names include Test or Step

Interfaces for test-related or step-related types include 'Test' or 'Step' in their name.

**Regex**: `^I.*(Test|Step)[A-Z][a-zA-Z0-9]*$`

**Examples**

```java
// Test-related interfaces
public interface ITestProject { }
public interface ITestSuite { }
public interface ITestCase { }
public interface ITestSetup { }
public interface ITestData { }
public interface ITestStepContainer { }

// Step-related interfaces
public interface ITestStep { }
public interface IStepObject { }
public interface IStepDefinition { }
public interface IStepParameters { }
```

## SOME method names include NameLong

Methods that return qualified or full path names use 'NameLong' suffix.

**Regex**: `^getNameLong$`

**Examples**

```java
// IModel.java - Top-level objects
public interface IModel {
    String getNameLong();
    void setNameLong(String value);
}

// ITestStep.java - Computed full step path
public interface ITestStep {
    String getNameLong();  // Computed, no setter
}

// IStepDefinition.java - Computed qualified name
public interface IStepDefinition {
    String getNameLong();  // Computed, no setter
}
```
