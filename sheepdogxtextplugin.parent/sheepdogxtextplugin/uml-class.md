# UML Class Patterns

## Pattern 9: SheepDogValidator has check* for every validate*

Only elements with validation infrastructure (Detector/Types) have check methods. 

There should be one check method for each validate method: ONLY issues will be FAST checks, FILE will be NORMAL, WORKSPACE will be EXPENSIVE.

### TODO

- Move Row validation to checkRow



## Pattern 10: SheepDogValidator constants match FeatureIssueTypes enums

The Validator contains constants for issues that have quick fixes. 
Missing constants are for warnings/informational messages that don't require fixes. 
The pattern is: only create constants for issues that will have `@Fix` annotations.



## Pattern 11: SheepDogQuickfixProvider has fix* methods for each SheepDogValidator check*

There doesn't need to be a fix* method for every check* method.
If a fix* method exists, there must be a corresponding check* method.
Just because there is a check* method, doesn't mean a fix* method has to exist.



## Pattern 12: All @Fix annotations in QuickfixProvider exist in SheepDogValidator

There can be multiple @Fix annotations for one fix* method.
Each of those annotations must exist in SheepDogValidator.

Method names follow the convention fix{CamelCase} corresponding to @Fix annotation constants in {UPPER_SNAKE_CASE} format.



## Pattern 13: fix* methods invoke FeatureIssueResolver.propose* methods



## Pattern 14: completeFeature_Attribute methods invoke helper complete* methods

All `completeFeature_Attribute` methods either invoke a helper method (`completeName`) or directly invoke the IssueResolver (`proposeCellList`). The pattern is consistently followed - the goal is to avoid duplicating business logic across multiple complete methods.



## Pattern 15: complete* helper methods invoke FeatureIssueResolver.propose* methods

Both helper/complete methods properly delegate to their corresponding `IssueResolver.propose*` methods. The pattern ensures that proposal logic is centralized in Resolver classes and reused across content assist and quick fixes.



