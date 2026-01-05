# LoggerProvider

## Purpose

Interface that allows external systems (like Eclipse/OSGi plugins) to inject custom logger implementations when SLF4J providers are not available.

## Methods

### getLogger(Class<?>)

Creates and returns an org.slf4j.Logger for the specified class.

**Signature**
```java
public Logger getLogger(Class<?> clazz)
```