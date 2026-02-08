# LoggerFactory

Facade for logger creation that abstracts SLF4J vs custom logger providers. Separates logging infrastructure concerns from business logic by hiding provider selection and fallback.

## getLogger

**Desc**: Creates logger for a class by selecting SLF4J or custom provider based on availability.

**Rule**: ONE method names match getLogger pattern.
 - **Name**: `^getLogger$`
 - **Return**: `^Logger$`
 - **Parameters**: `^\(Class<\?>\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static Logger getLogger(Class<?> clazz)`

## setLoggerImplementation

**Desc**: Configures custom logger provider for environments without SLF4J implementations (like Eclipse OSGi).

**Rule**: ONE method names match setLoggerImplementation pattern.
 - **Name**: `^setLoggerImplementation$`
 - **Return**: `^void$`
 - **Parameters**: `^\(LoggerProvider\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static void setLoggerImplementation(LoggerProvider provider)`
