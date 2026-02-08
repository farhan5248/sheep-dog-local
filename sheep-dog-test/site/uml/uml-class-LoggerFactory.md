# LoggerFactory

Factory class that provides loggers to sheep-dog-test classes. Uses SLF4J when a real provider is available, otherwise delegates to a custom LoggerProvider implementation.

The getLogger method delegates to LoggerProvider when SLF4J falls back to NOPLoggerFactory.

## getLogger

**Desc**: Get logger for class using SLF4J or custom provider.

**Rule**: ONE method names match getLogger pattern.
 - **Name**: `^getLogger$`
 - **Return**: `^Logger$`
 - **Parameters**: `^\(Class<\?>\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static Logger getLogger(Class<?> clazz)`

## setLoggerImplementation

**Desc**: Set custom logger provider when SLF4J is unavailable.

**Rule**: ONE method names match setLoggerImplementation pattern.
 - **Name**: `^setLoggerImplementation$`
 - **Return**: `^void$`
 - **Parameters**: `^\(LoggerProvider\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static void setLoggerImplementation(LoggerProvider provider)`
