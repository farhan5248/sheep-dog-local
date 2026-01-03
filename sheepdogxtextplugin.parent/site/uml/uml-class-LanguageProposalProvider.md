# {Language}ProposalProvider

## {Language}ProposalProvider extends Abstract{Language}ProposalProvider

Extends Xtext-generated Abstract{Language}ProposalProvider base class.

Overrides complete{Feature}_{Attribute} methods.

Manually created proposal methods delegate to {Feature}IssueResolver classes.

### {Language}ProposalProvider

```java
public class {Language}ProposalProvider extends Abstract{Language}ProposalProvider
```

## complete{Feature}_{Attribute} methods invoke helper complete{Attribute} methods

All `complete{Feature}_{Attribute}` methods either invoke a helper method or directly invoke the IssueResolver.

The pattern is consistently followed - the goal is to avoid duplicating business logic across multiple complete methods.

### {Language}ProposalProvider

```java
public void complete{Feature}_{Attribute}({FeatureType} model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor)
// Calls: complete{Attribute}(model, assignment, context, acceptor)
```

## complete{Attribute} helper methods invoke {Feature}IssueResolver.suggest{Attribute} methods

Both helper/complete methods properly delegate to their corresponding `IssueResolver.suggest*` methods.

The pattern ensures that proposal logic is centralized in Resolver classes and reused across content assist and quick fixes.

### {Language}ProposalProvider

```java
private void complete{Attribute}({Feature} model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor)
// Calls: {Feature}IssueResolver.suggest{Attribute}Workspace(new {Feature}Impl(model))
```
