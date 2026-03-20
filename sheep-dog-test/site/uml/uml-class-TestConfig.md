# TestConfig

**Directory**: `src/test/java/org/farhan/common`

**Extends**: AbstractModule

**Implements**: InjectorSource

## configure

**Desc**: Binds grammar object interfaces to impl classes for dependency injection.

**Rule**: ALL method names follow configure pattern.
 - **Name**: `^configure$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void configure()`
