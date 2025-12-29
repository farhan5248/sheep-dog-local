# UML Communication Patterns

Each class is part of a collection of classes that follow a pattern.
These are the patterns that all classes follow:

1. Wrapper
2. Content proposal
3. Content validation
4. Content correction

These are the classes per project in **sheep-dog-local** for a pattern above:

1. **sheep-dog-test**
   1. **Content proposal**: *IssueResolver, LanguageIssueProposal
   2. **Content validation**: *IssueTypes, *IssueDetector
   3. **Content correction**: *IssueTypes, *IssueDetector, *IssueResolver
2. **sheepdogxtextplugin.parent\sheepdogxtextplugin**
   1. **Content validation**: Validator
3. **sheepdogxtextplugin.parent\sheepdogxtextplugin.ui**
   1. **Content proposal**: ProposalProvider
   2. **Content correction**: QuickfixProvider
