# I{Language}Factory


Interface for creating language-specific grammar elements. Defines parameterless create{Type}() methods that return empty instances.
Factory interface methods create empty instances of grammar types. 
The {Language}Builder is responsible for setting attributes and adding instances to parent containers.

## create{Type}

**Desc**: Return type I{Type} must match method name create{Type}(). 

**Rule**: ALL method names follow create{Type} pattern.
 - **Name**: `^create{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(\)$`

**Examples**:
 - `IStepDefinition createStepDefinition()`
 - `IStepObject createStepObject()`
