# {Language}QuickfixProvider

## {Language}QuickfixProvider extends DefaultQuickfixProvider

Extends DefaultQuickfixProvider from Xtext framework.

Uses @Fix annotations referencing {Language}Validator constants.

Manually created fix methods delegate to {Feature}IssueResolver classes.

### {Language}QuickfixProvider

```java
public class {Language}QuickfixProvider extends DefaultQuickfixProvider
```

## {Language}QuickfixProvider has fix{Issue} methods for each check{Issue}

There doesn't need to be a fix{Issue} method for every check{Issue} method.

If a fix{Issue} method exists, there must be a corresponding check{Issue} method.

Just because there is a check{Issue} method, doesn't mean a fix{Issue} method has to exist.

### {Language}QuickfixProvider

```java
@Fix({Language}Validator.{FEATURE}_{ASPECT}_{ISSUE})
public void fix{Feature}{Aspect}{Issue}(final Issue issue, IssueResolutionAcceptor acceptor)
```

## All @Fix annotations in QuickfixProvider exist in {Language}Validator

There can be multiple @Fix annotations for one fix{Issue} method.

Each of those annotations must exist in {Language}Validator.

Method names follow the convention fix{CamelCase} corresponding to @Fix annotation constants in {UPPER_SNAKE_CASE} format.

### {Language}QuickfixProvider

```java
@Fix({Language}Validator.{FEATURE}_{ASPECT}_{ISSUE})
public void fix{Feature}{Aspect}{Issue}(final Issue issue, IssueResolutionAcceptor acceptor)
```

## fix{Issue} methods invoke {Feature}IssueResolver.correct{Issue} methods

Each fix method delegates to the appropriate IssueResolver.correct* method to generate proposals.

### {Language}QuickfixProvider

```java
public void fix{Feature}{Aspect}{Issue}(final Issue issue, IssueResolutionAcceptor acceptor)
// Calls: {Feature}IssueResolver.correct{Aspect}{Issue}(new {Feature}Impl(({Feature}) getEObject(issue)))
```
