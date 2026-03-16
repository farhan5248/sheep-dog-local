# {Language}FactoryImpl

**Implements**: I{Language}Factory

## create{Type}

**Desc**: Creates and returns a new {Type}Impl instance. Each method implements the corresponding I{Language}Factory contract.

**Rule**: ALL method names follow create{Type} pattern.
 - **Name**: `^create{Type}$`
 - **Return**: `^I{Type}$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public ICell createCell()`
 - `public ITestSuite createTestSuite()`
 - `public IDescription createDescription()`
