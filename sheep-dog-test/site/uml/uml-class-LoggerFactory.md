# LoggerFactory

Factory class that provides loggers to sheep-dog-test classes. Uses SLF4J when a real provider is available, otherwise delegates to a custom LoggerProvider implementation.

The getLogger method delegates to LoggerProvider when SLF4J falls back to NOPLoggerFactory.

## ONE method names match getLogger pattern

Get logger for class using SLF4J or custom provider.

**Regex**: `^public\s+static\s+Logger\s+getLogger\(Class<\?>\s+\w+\)$`
 - `public static Logger getLogger(Class<?> clazz)`

## ONE method names match setLoggerImplementation pattern

Set custom logger provider when SLF4J is unavailable.

**Regex**: `^public\s+static\s+void\s+setLoggerImplementation\(LoggerProvider\s+\w+\)$`
 - `public static void setLoggerImplementation(LoggerProvider provider)`

## SOME attribute names match provider pattern

Custom logger implementation injected by external systems when SLF4J has no provider.

**Regex**: `^provider$`
 - `private static LoggerProvider provider`
