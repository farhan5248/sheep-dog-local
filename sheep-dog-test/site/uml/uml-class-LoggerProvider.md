# LoggerProvider

Interface that allows external systems (like Eclipse/OSGi plugins) to inject custom logger implementations when SLF4J providers are not available.

## getLogger

The provider interface defines a single method for creating loggers by class.

**Rule**: ALL method names follow getLogger pattern

**Regex**: `^public\s+Logger\s+getLogger\(Class<\?>\s+\w+\)$`
 - `public Logger getLogger(Class<?> clazz)`
