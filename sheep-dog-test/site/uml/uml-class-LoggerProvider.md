# LoggerProvider

Interface that allows external systems (like Eclipse/OSGi plugins) to inject custom logger implementations when SLF4J providers are not available.

## LoggerProvider has single getLogger method

The provider interface defines a single method for creating loggers by class.

**Examples**
```java
public Logger getLogger(Class<?> clazz)
```