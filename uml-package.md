# UML Package Patterns

List of file name patterns and their corresponding packages.

1. **sheep-dog-test**
   1. **org\farhan\dsl\issues**: ElementIssueTypes, ElementIssueDetector, ElementIssueResolver, LanguageIssueProposal
   2. **org\farhan\dsl\lang**: IElement, ITestProject, LanguageBuilder, LanguageFactory, ElementUtility
   3. **org\farhan\dsl\types**: ElementAspectTypes
2. **sheepdogxtextplugin.parent\sheepdogxtextplugin**
   1. **org\farhan\dsl\sheepdog\impl**: ElementImpl
   2. **org\farhan\dsl\sheepdog\validation**: LanguageValidator
3. **sheepdogxtextplugin.parent\sheepdogxtextplugin.ui**
   1. **org\farhan\dsl\sheepdog\ui\contentassist**: *IssueResolver
   2. **org\farhan\dsl\sheepdog\ui\quickfix**: *IssueTypes, *IssueDetector

TODO
This list is not complete, it needs more entries for xtext files.