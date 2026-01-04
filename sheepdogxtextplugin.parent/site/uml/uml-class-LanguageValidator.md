# {Language}Validator

## {Language}Validator extends Abstract{Language}Validator

**Content**

Extends Xtext-generated Abstract{Language}Validator base class.

Uses @Check annotations with CheckType (FAST, NORMAL, EXPENSIVE).

Manually created validation methods delegate to {Feature}IssueDetector classes.

**Examples**

```java
public class {Language}Validator extends Abstract{Language}Validator
```

## {Language}Validator has check{Feature} for every validate{Issue}

**Content**

Only elements with validation infrastructure (Detector/Types) have check methods.

There should be one check method for each validate method. All check methods use CheckType.FAST regardless of issue type (ONLY, FILE, or WORKSPACE).

**Examples**

```java
@Check(CheckType.FAST)
public void check{Feature}{Aspect}({Feature} element)
```

## {Language}Validator constants match {Feature}IssueTypes enums

**Content**

The Validator contains constants for issues that have quick fixes.

Missing constants are for warnings/informational messages that don't require fixes.

The pattern is: only create constants for issues that will have @Fix annotations.

**Examples**

```java
public static final String {FEATURE}_{ASPECT}_{ISSUE} = "{FEATURE}_{ASPECT}_{ISSUE}"
```
