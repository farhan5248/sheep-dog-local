# I{Type}

## All grammar types have I{Type} interfaces

All union types in the grammar follow the pattern:
- Base interface contains common attributes child interfaces extend the base.
- Type differentiation through inheritance hierarchy, not discriminator methods (`is*()`, `getAs*()`). Parent type matches containment hierarchy or Object if there is no common parent like Table or StatementList.

**Examples**

- Base Interface Example

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
    // ...
}
```

- Child Interface Example

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

**Examples**

- Single Value Attribute Example

```java
// ICell.java - 'name' attribute from grammar
package org.farhan.dsl.lang;

public interface ICell {
    String getName();
    void setName(String value);
    IRow getParent();
}
```

- Object Reference Attribute Example

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

**Examples**

- Index-Only Getter Example

Lists where elements have no name attribute only require the index-based getter.

```java
// ITable.java - rowList from grammar (Row has no name attribute)
package org.farhan.dsl.lang;

import java.util.List;

public interface ITable {
    IRow getRow(int index);
    List<IRow> getRowList();
}
```

Grammar reference:
```xtext
Table: ... rowList+=Row+ ...
```

- Index and Name Getter Example

Lists where elements have `name=Title` in grammar require both index and name getters.

```java
// IRow.java - cellList from grammar (Cell has name=Title)
package org.farhan.dsl.lang;

import java.util.List;

public interface IRow {
    ICell getCell(int index);
    ICell getCell(String name);
    List<ICell> getCellList();
}
```

Grammar reference:
```xtext
Cell: ... name=Title ...
```

- Top-Level Qualified Name Getter Example

Top-level lists in ITestProject require index and qualifiedName getters.

```java
// ITestProject.java - stepObjectList (top-level Model type)
package org.farhan.dsl.lang;

import java.util.List;

public interface ITestProject {
    IStepObject getStepObject(int index);
    IStepObject getStepObject(String qualifiedName);
    List<IStepObject> getStepObjectList();
}
```

Grammar reference:
```xtext
StepObject: ... stepDefinitionList+=StepDefinition* ...
```

- Nested List Getter Example

Lists within non-top-level types require index and name getters when elements have name attribute.

```java
// IStepObject.java - stepDefinitionList (StepDefinition has name=Title)
package org.farhan.dsl.lang;

import java.util.List;

public interface IStepObject extends IModel {
    IStepDefinition getStepDefinition(int index);
    IStepDefinition getStepDefinition(String name);
    List<IStepDefinition> getStepDefinitionList();
}
```

Grammar reference:
```xtext
StepDefinition: ... stepParameterList+=StepParameters* ...
```

## All grammar types have Parent References

Every non-root interface has `getParent()` methods, even though "parent" never appears in the grammar.
Apply lazy parent initialization.

**Parent Return Type Rule**: getParent() methods MUST return interface types (I*), never EMF types. This maintains framework independence.

**Examples**

- Root Interface Example

The root interface (ITestProject) has NO getParent() method.

```java
// ITestProject.java - Root interface, no parent
package org.farhan.dsl.lang;

import java.util.List;

public interface ITestProject {
    String getName();
    // ...
    // NO getParent() method
}
```

- Direct Parent Reference Example

Non-root interfaces have explicit getParent() methods returning the appropriate parent type.

```java
// IStepDefinition.java - Parent is IStepObject
package org.farhan.dsl.lang;

import java.util.List;

public interface IStepDefinition {
    // ...
    IStepObject getParent();
}
```

- Inherited Parent Reference Example

Child interfaces inherit getParent() from their base interface.

```java
// IGiven.java - Inherits getParent() from ITestStep
package org.farhan.dsl.lang;

public interface IGiven extends ITestStep {
    // Pure inheritance - getParent() inherited from ITestStep
}
```

- Object Parent Type Example

When there is no common parent type, getParent() returns Object.

```java
// ITable.java - Returns Object (can be in TestData or StepParameters)
package org.farhan.dsl.lang;

import java.util.List;

public interface ITable {
    Object getParent();
    IRow getRow(int index);
    List<IRow> getRowList();
}
```

## Some grammar types have NameLong attribute

This applies to type names beginning with **Test** or **Step**.
For top level objects, this is the qualified name. For steps it's the full step with component and object path.

**Examples**

- Top-Level NameLong Example

Top-level Model features (IStepObject, ITestSuite) have both getter and setter through IModel.

```java
// IModel.java - Base interface for StepObject | TestSuite
package org.farhan.dsl.lang;

public interface IModel {
    String getNameLong();
    void setNameLong(String value);  // TODO: Should be derived, not settable
    ITestProject getParent();
}
```

```java
// IStepObject.java - Extends IModel, inherits getNameLong()
package org.farhan.dsl.lang;

public interface IStepObject extends IModel {
    String getNameLong();  // Inherited from IModel
    // ...
}
```

Grammar reference:
```xtext
StepObject: ... name=Title ... // No nameLong in grammar
```

- Step-Related NameLong Example

Step-related features have only getter (no setter) - it's a computed attribute.

```java
// ITestStep.java - Base interface for test steps
package org.farhan.dsl.lang;

public interface ITestStep {
    String getNameLong();  // Full step path, no setter
    // ...
}
```

```java
// IStepDefinition.java - Step definition within StepObject
package org.farhan.dsl.lang;

public interface IStepDefinition {
    String getNameLong();  // Computed, no setter
    // ...
}
```

- Test-Related NameLong Example

Test-related features have only getter (no setter) - it's a computed attribute.

```java
// ITestStepContainer.java - Base for TestSetup | TestCase
package org.farhan.dsl.lang;

public interface ITestStepContainer {
    String getNameLong();  // Computed, no setter
    // ...
}
```

```java
// ITestData.java - Test data within TestCase
package org.farhan.dsl.lang;

public interface ITestData {
    String getNameLong();  // Computed, no setter
    // ...
}
```
