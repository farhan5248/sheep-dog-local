# IFeature

## All grammar features have IFeature.java interfaces

All union types in the grammar follow the pattern:
- Base interface contains common attributes
- Child interfaces extend the base
- No discriminator methods (`is*()`, `getAs*()`)
- Type differentiation through inheritance hierarchy. Parent type matches containment hierarchy or Object if there is no common parent like Table or StatementList

### Base Interface Example

```java
// IModel.java - Base interface for union type (StepObject | TestSuite)
package org.farhan.dsl.lang;

public interface IModel {
    String getNameLong();
    void setNameLong(String value);
    ITestProject getParent();
}
```

```java
// ITestStep.java - Base interface for union type (Given | When | Then | And)
package org.farhan.dsl.lang;

public interface ITestStep {
    String getName();
    String getNameLong();
    String getStepObjectName();
    String getStepDefinitionName();
    ITestStepContainer getParent();
    ITable getTable();
    IText getText();
    void setStepObjectName(String value);
    void setStepDefinitionName(String value);
    void setTable(ITable value);
    void setText(IText value);
}
```

### Child Interface Example

```java
// IGiven.java - Child interface extends ITestStep
package org.farhan.dsl.lang;

public interface IGiven extends ITestStep {
    // Pure inheritance - no additional methods
}
```

```java
// IStepObject.java - Child interface extends IModel
package org.farhan.dsl.lang;

public interface IStepObject extends IModel {
    // Additional methods specific to StepObject
}
```

## Each non grammar list attribute has a getter/setter

### Single Value Attribute Example

```java
// ICell.java - 'name' attribute from grammar
package org.farhan.dsl.lang;

public interface ICell {
    String getName();
    void setName(String value);
    IRow getParent();
}
```

### Object Reference Attribute Example

```java
// IStepParameters.java - 'table' attribute from grammar
package org.farhan.dsl.lang;

public interface IStepParameters {
    String getName();
    void setName(String value);

    ITable getTable();
    void setTable(ITable value);

    IStepDefinition getParent();
}
```

## Each grammar list attribute has up to 3 getters

Every grammar list must have up to 3 helper methods with these signatures:

1. `getX(int index)` - **REQUIRED** for ALL lists (zero-based indexing)
2. `getX(String name)` - For lists of elements with `name=Title` grammar attribute
3. `getX(String qualifiedName)` - For top-level lists (TestSuite, StepObject in ITestProject)

## Navigation Attributes Parent References

Every non-root interface has `getParent()` methods, even though "parent" never appears in the grammar.
Apply lazy parent initialization.

## Top-level interfaces have qualified names

## Derived Name Attributes

Step-like elements have extended name formats:

```xtext
StepDefinition:
    '==' 'Step-Definition:' name=Title EOL
    // No nameLong attribute
```

### NameLong Attribute Example

```java
// IStepDefinition.java and ITestStep.java
String getNameLong();              // NOT in grammar
void setNameLong(String value);
```
