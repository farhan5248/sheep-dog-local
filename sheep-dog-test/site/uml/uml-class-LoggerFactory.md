# LoggerFactory

Factory class that provides loggers to sheep-dog-test classes. Uses SLF4J when a real provider is available, otherwise delegates to a custom LoggerProvider implementation.

## All LoggerFactory methods are static

The LoggerFactory provides static factory methods for logger creation and configuration.

**Examples**
```java
public static void setLoggerImplementation(LoggerProvider provider)
public static Logger getLogger(Class<?> clazz)
```

## LoggerFactory stores a custom LoggerProvider

Custom logger implementation injected by external systems when SLF4J has no provider.

**Examples**
```java
private static LoggerProvider provider;
```

## getLogger delegates to LoggerProvider when SLF4J unavailable

Returns an SLF4J Logger for the specified class. Uses custom provider if SLF4J falls back to NOPLoggerFactory.

**Examples**
```java
public static Logger getLogger(Class<?> clazz) {
    if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory && provider != null) {
        return provider.getLogger(clazz);
    }
    return LoggerFactory.getLogger(clazz);
}
```