# UML Communication Patterns

Collaboration patterns for sheepdogxtextplugin IDE integration. Business logic patterns are documented in sheep-dog-test/site/uml/uml-communication.md.

## IDE Integration

**Rules**
- Applies when Xtext IDE needs to validate, propose, or correct grammar elements
- IDE integration classes wrap EMF objects and delegate to business logic
- Business logic classes (Detector/Resolver) are in sheep-dog-test, not sheepdogxtextplugin

### {Language}Validator

- `check{Feature}{Aspect}({Feature} eObject)` - Validates grammar element
  - **Creates:** {Feature}Impl wrapper
  - **Calls:** {Feature}IssueDetector.validate{Aspect}(), initProject(), warning() or error()
  - **Returns:** void

- `initProject(Resource resource)` - Initializes project context
  - **Creates:** ITestProject via {Language}Factory
  - **Calls:** {Language}Factory.instance.createTestProject()
  - **Returns:** void

- `logError(Exception e, String name)` - Logs exceptions
  - **Calls:** logger.error()
  - **Returns:** void

### {Language}ProposalProvider

- `complete{Feature}_{Attribute}({FeatureType} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)` - Content assist entry point
  - **Calls:** super.complete{Feature}_{Attribute}(), complete{Attribute}()
  - **Returns:** void

- `complete{Attribute}({Feature} model, Assignment, ContentAssistContext, ICompletionProposalAcceptor acceptor)` - Helper generates proposals
  - **Creates:** {Feature}Impl wrapper, ConfigurableCompletionProposal
  - **Calls:** {Feature}IssueResolver.suggest{Attribute}(), acceptor.accept()
  - **Returns:** void

- `initProject(Resource resource)` - Initializes project context
  - **Creates:** ITestProject via {Language}Factory
  - **Calls:** {Language}Factory.instance.createTestProject()
  - **Returns:** void

### {Language}QuickfixProvider

- `fix{Feature}{Aspect}(Issue issue, IssueResolutionAcceptor acceptor)` - Quick fix entry point
  - **Creates:** {Feature}Impl wrapper
  - **Calls:** getEObject(), {Feature}IssueResolver.correct{Aspect}(), createAcceptor()
  - **Returns:** void

- `createAcceptor(Issue issue, IssueResolutionAcceptor acceptor, ArrayList<{Language}IssueProposal> proposals)` - Creates fix acceptors
  - **Creates:** IModification instances
  - **Calls:** acceptor.accept()
  - **Returns:** void

- `getEObject(Issue issue)` - Retrieves EMF object
  - **Creates:** ResourceSetImpl, Resource
  - **Calls:** ResourceSetImpl.getResource(), Resource.getEObject()
  - **Returns:** EObject

### {Feature}Impl

- `{Feature}Impl({Feature} eObject)` - Wraps EMF object
  - **Creates:** Wrapper instance
  - **Returns:** N/A (constructor)

- `get{Attribute}()` - Delegates to EMF object
  - **Calls:** eObject.get{Attribute}()
  - **Returns:** Attribute value

- `getParent()` - Lazy parent initialization
  - **Creates:** Parent wrapper (lazy)
  - **Calls:** eObject.eContainer()
  - **Returns:** I{Parent}

### {Feature}IssueDetector

Business logic class from sheep-dog-test (not in sheepdogxtextplugin).

- `validate{Aspect}(I{Feature} feature)` - Pure validation logic
  - **Calls:** {Feature}Utility methods
  - **Returns:** String (empty if valid)

**Called by:** {Language}Validator

### {Feature}IssueResolver

Business logic class from sheep-dog-test (not in sheepdogxtextplugin).

- `suggest{Attribute}(I{Feature} feature)` - Generates proposals
  - **Creates:** {Language}IssueProposal instances
  - **Returns:** ArrayList<{Language}IssueProposal>

- `correct{Aspect}(I{Feature} feature)` - Generates corrections
  - **Creates:** {Language}IssueProposal instances
  - **Returns:** ArrayList<{Language}IssueProposal>

**Called by:** {Language}ProposalProvider, {Language}QuickfixProvider

### {Language}Factory

Singleton from sheep-dog-test (not in sheepdogxtextplugin).

- `instance` - Singleton instance
  - **Accessed by:** All IDE integration classes

- `createTestProject()` - Returns project singleton
  - **Creates:** TestProjectImpl
  - **Returns:** ITestProject

**Called by:** initProject() methods

### {Language}IssueProposal

Data container from sheep-dog-test (not in sheepdogxtextplugin).

**Properties:** id, description, value, qualifiedName

**Created by:** {Feature}IssueResolver classes
