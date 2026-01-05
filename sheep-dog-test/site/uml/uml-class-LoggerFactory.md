# LoggerFactory

## Purpose

Factory class that provides loggers to sheep-dog-test classes. Uses SLF4J when a real provider is available, otherwise delegates to a custom LoggerProvider implementation.

## Static Attributes

- `provider`: LoggerProvider - Custom logger implementation injected by external systems

## Static Methods

### setLoggerImplementation(LoggerProvider)

Sets the custom logger provider for environments where SLF4J has no provider.

**Signature**
```java
public static void setLoggerImplementation(LoggerProvider provider)
```

### getLogger(Class<?>)

Returns an SLF4J Logger for the specified class. Uses custom provider if SLF4J falls back to NOPLoggerFactory.

**Signature**
```java
public static Logger getLogger(Class<?> clazz)
```

**Detection Logic**
- Checks if `org.slf4j.LoggerFactory.getILoggerFactory()` returns `NOPLoggerFactory`
- If yes and provider is set, delegates to `provider.getLogger(clazz)`
- Otherwise returns standard SLF4J logger