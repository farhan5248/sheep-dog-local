# I{Language}Factory

Factory interface for creating empty grammar instances. Separates factory contract from initialization logic and concrete implementations (EMF vs POJO).

## create{Type}

**Desc**: Creates uninitialized grammar element instance for subsequent attribute setting by builder. 

**Rule**: ALL method names follow create{Type} pattern.
 - **Name**: `^create{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(\)$`

**Examples**:
 - `IStepDefinition createStepDefinition()`
 - `IStepObject createStepObject()`
