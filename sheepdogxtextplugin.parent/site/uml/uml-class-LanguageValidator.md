# {Language}Validator

## {Language}Validator extends Abstract{Language}Validator

Extends Xtext-generated Abstract{Language}Validator base class.

Uses @Check annotations with CheckType (FAST, NORMAL, EXPENSIVE).

Manually created validation methods delegate to {Feature}IssueDetector classes.

### {Language}Validator

```java
public class {Language}Validator extends Abstract{Language}Validator
```

## {Language}Validator has check{Feature} for every validate{Issue}

Only elements with validation infrastructure (Detector/Types) have check methods.

There should be one check method for each validate method: ONLY issues will be FAST checks, FILE will be NORMAL, WORKSPACE will be EXPENSIVE.

### {Language}Validator

```java
@Check(CheckType.FAST)
public void check{Feature}{Aspect}({Feature} element)
```

## {Language}Validator constants match {Feature}IssueTypes enums

The Validator contains constants for issues that have quick fixes.

Missing constants are for warnings/informational messages that don't require fixes.

The pattern is: only create constants for issues that will have @Fix annotations.

### {Language}Validator

```java
public static final String {FEATURE}_{ASPECT}_{ISSUE} = "{FEATURE}_{ASPECT}_{ISSUE}"
```
