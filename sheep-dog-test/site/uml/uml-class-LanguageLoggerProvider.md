# {Language}LoggerProvider

Interface for custom logger implementations. Separates logger provider contract from logger usage, enabling dependency injection in environments without SLF4J.

## getLogger

**Desc**: Creates a logger instance for the specified class when custom logging is needed.

**Rule**: ALL method names follow getLogger pattern.
 - **Name**: `^getLogger$`
 - **Return**: `^Logger$`
 - **Parameters**: `^\(Class<\?>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public Logger getLogger(Class<?> clazz)`
