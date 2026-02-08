# LoggerProvider

Interface that allows external systems (like Eclipse/OSGi plugins) to inject custom logger implementations when SLF4J providers are not available.

## getLogger

**Desc**: The provider interface defines a single method for creating loggers by class.

**Rule**: ALL method names follow getLogger pattern.
 - **Name**: `^getLogger$`
 - **Return**: `^Logger$`
 - **Parameters**: `^\(Class<\?>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public Logger getLogger(Class<?> clazz)`
