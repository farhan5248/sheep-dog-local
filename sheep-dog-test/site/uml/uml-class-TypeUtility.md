# {Type}Utility

## All Utility classes are static

All methods are public static. No instance variables or constructors.

**Examples**

- StepDefinitionUtility

```java
public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String pipeDelimitedString)
```

- TestStepUtility

```java
public static String getNameLong(ITestStep theStep)
public static String getStepObjectQualifiedName(ITestStep theStep)
public static boolean isValid(String text)
public static boolean isEdge(String text)
public static boolean isVertex(String text)
public static boolean isNegativeStep(String text)
```

- TestProjectUtility

```java
public static ArrayList<String> getComponentList(ITestProject testProject)
public static ArrayList<IStepObject> getStepObjectList(ITestProject testProject, String component)
```

- StatementUtility

```java
public static boolean isTag(String word)
public static boolean isTodo(String word)
public static TreeSet<String> getTags(String name)
public static String getStatementListAsString(List<IStatement> statementList)
```

## Utility classes provide derived attributes

Methods compute values not stored in grammar.

**Examples**

- TestStepUtility

```java
public static String getNameLong(ITestStep theStep)
```

- TestProjectUtility

```java
public static ArrayList<String> getComponentList(ITestProject testProject)
```

## Utility classes provide parsing methods

Extract parts from composite grammar attributes.

**Examples**

- TestStepUtility

```java
public static String getStepObjectName(String text)
public static String getComponent(String text)
public static String getComponentName(String text)
public static String getComponentType(String text)
public static String getObject(String text)
public static String getObjectName(String text)
public static String getObjectType(String text)
public static String getStepDefinitionName(String text)
```

## Utility classes provide validation methods

Boolean methods for classification.

**Examples**

- TestStepUtility

```java
public static boolean isValid(String text)
public static boolean isEdge(String text)
public static boolean isVertex(String text)
public static boolean isNegativeStep(String text)
```

- StatementUtility

```java
public static boolean isTag(String word)
public static boolean isTodo(String word)
```
