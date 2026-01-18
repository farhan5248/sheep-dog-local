# UML Communication Patterns

Collaboration patterns for sheepdogxtextplugin IDE integration. Business logic patterns are documented in sheep-dog-test/site/uml/uml-communication.md.

## Suggest

This pattern applies when providing content assist proposals for absent grammar elements. The ProposalProvider delegates to business logic resolvers.

### {Language}ProposalProvider

Provides content assist proposals by delegating to business logic resolvers.

**Methods**
- `complete{Type}_{Assignment}({TypeClass} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)`
- `complete{Assignment}({Type} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)`
- `initProject(Resource resource)`

### {Type}Impl

Wrapper class that adapts EMF objects to business logic interfaces by delegating attribute access.

**Methods**
- `{Type}Impl({Type} eObject)`
- `get{Assignment}()`
- `getParent()`

### {Type}IssueResolver

Business logic class from sheep-dog-test (not in sheepdogxtextplugin) that suggests alternatives for absent grammar elements.

**Methods**
- `suggest{Assignment}(I{Type} type)`

### {Language}Factory

Singleton from sheep-dog-test (not in sheepdogxtextplugin) that creates and manages project instances.

**Methods**
- `createTestProject()`

### {Language}IssueProposal

Data container from sheep-dog-test (not in sheepdogxtextplugin) that holds proposal information for content assist.

**Properties:** id, description, value, qualifiedName

## Validate

This pattern applies when validating existing grammar elements. The Validator delegates to business logic detectors.

### {Language}Validator

Validates grammar elements in the IDE by wrapping EMF objects and delegating to business logic detectors.

**Methods**
- `check{Type}{Aspect}({Type} eObject)`
- `initProject(Resource resource)`
- `logError(Exception e, String name)`

### {Type}Impl

Wrapper class that adapts EMF objects to business logic interfaces by delegating attribute access.

**Methods**
- `{Type}Impl({Type} eObject)`
- `get{Assignment}()`
- `getParent()`

### {Type}IssueDetector

Business logic class from sheep-dog-test (not in sheepdogxtextplugin) that provides pure validation logic for grammar elements.

**Methods**
- `validate{Aspect}(I{Type} type)`

### {Language}Factory

Singleton from sheep-dog-test (not in sheepdogxtextplugin) that creates and manages project instances.

**Methods**
- `createTestProject()`

## Correct

This pattern applies when providing quick fixes for invalid grammar elements. The Validator detects issues and QuickfixProvider provides corrections.

### {Language}Validator

Validates grammar elements in the IDE by wrapping EMF objects and delegating to business logic detectors.

**Methods**
- `check{Type}{Aspect}({Type} eObject)`
- `initProject(Resource resource)`
- `logError(Exception e, String name)`

### {Language}QuickfixProvider

Provides quick fix corrections by delegating to business logic resolvers and applying modifications to EMF objects.

**Methods**
- `fix{Type}{Aspect}(Issue issue, IssueResolutionAcceptor acceptor)`
- `createAcceptor(Issue issue, IssueResolutionAcceptor acceptor, ArrayList<{Language}IssueProposal> proposals)`
- `getEObject(Issue issue)`

### {Type}Impl

Wrapper class that adapts EMF objects to business logic interfaces by delegating attribute access.

**Methods**
- `{Type}Impl({Type} eObject)`
- `get{Assignment}()`
- `getParent()`

### {Type}IssueResolver

Business logic class from sheep-dog-test (not in sheepdogxtextplugin) that generates corrections for invalid grammar elements.

**Methods**
- `correct{Aspect}(I{Type} type)`

### {Language}Factory

Singleton from sheep-dog-test (not in sheepdogxtextplugin) that creates and manages project instances.

**Methods**
- `createTestProject()`

### {Language}IssueProposal

Data container from sheep-dog-test (not in sheepdogxtextplugin) that holds proposal information for quick fixes.

**Properties:** id, description, value, qualifiedName
