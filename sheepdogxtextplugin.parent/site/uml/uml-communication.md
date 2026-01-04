# UML Communication Patterns

Collaboration patterns for sheepdogxtextplugin IDE integration. Business logic patterns are documented in sheep-dog-test/site/uml/uml-communication.md.

## IDE Integration

This collaboration applies when Xtext IDE needs to validate, propose, or correct grammar elements. IDE integration classes wrap EMF objects and delegate to business logic. Business logic classes (Detector/Resolver) are in sheep-dog-test, not sheepdogxtextplugin.

**Methods**
- Grammar element validation workflows
- Content assist proposal generation
- Quick fix correction workflows
- EMF object wrapping and delegation

### {Language}Validator

Validates grammar elements in the IDE by wrapping EMF objects and delegating to business logic detectors.

**Methods**
- `check{Feature}{Aspect}({Feature} eObject)`
- `initProject(Resource resource)`
- `logError(Exception e, String name)`

### {Language}ProposalProvider

Provides content assist proposals by delegating to business logic resolvers.

**Methods**
- `complete{Feature}_{Attribute}({FeatureType} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)`
- `complete{Attribute}({Feature} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)`
- `initProject(Resource resource)`

### {Language}QuickfixProvider

Provides quick fix corrections by delegating to business logic resolvers and applying modifications to EMF objects.

**Methods**
- `fix{Feature}{Aspect}(Issue issue, IssueResolutionAcceptor acceptor)`
- `createAcceptor(Issue issue, IssueResolutionAcceptor acceptor, ArrayList<{Language}IssueProposal> proposals)`
- `getEObject(Issue issue)`

### {Feature}Impl

Wrapper class that adapts EMF objects to business logic interfaces by delegating attribute access.

**Methods**
- `{Feature}Impl({Feature} eObject)`
- `get{Attribute}()`
- `getParent()`

### {Feature}IssueDetector

Business logic class from sheep-dog-test (not in sheepdogxtextplugin) that provides pure validation logic for grammar elements.

**Methods**
- `validate{Aspect}(I{Feature} feature)`

### {Feature}IssueResolver

Business logic class from sheep-dog-test (not in sheepdogxtextplugin) that generates proposals and corrections for grammar elements.

**Methods**
- `suggest{Attribute}(I{Feature} feature)`
- `correct{Aspect}(I{Feature} feature)`

### {Language}Factory

Singleton from sheep-dog-test (not in sheepdogxtextplugin) that creates and manages project instances.

**Methods**
- `createTestProject()`

### {Language}IssueProposal

Data container from sheep-dog-test (not in sheepdogxtextplugin) that holds proposal information for content assist and quick fixes.

**Properties:** id, description, value, qualifiedName
