# LoggerFactory

Factory class that provides loggers to sheep-dog-test classes. Uses SLF4J when a real provider is available, otherwise delegates to a custom LoggerProvider implementation.

The getLogger method delegates to LoggerProvider when SLF4J falls back to NOPLoggerFactory.

## getLogger(Class<?>)

Get logger for class using SLF4J or custom provider.

**Rule**: ONE method names match getLogger pattern

**Regex**: `^public\s+static\s+Logger\s+getLogger\(Class<\?>\s+\w+\)$`
 - `public static Logger getLogger(Class<?> clazz)`

## setLoggerImplementation(LoggerProvider)

Set custom logger provider when SLF4J is unavailable.

**Rule**: ONE method names match setLoggerImplementation pattern

**Regex**: `^public\s+static\s+void\s+setLoggerImplementation\(LoggerProvider\s+\w+\)$`
 - `public static void setLoggerImplementation(LoggerProvider provider)`

## provider

Custom logger implementation injected by external systems when SLF4J has no provider.

**Rule**: SOME attribute names match provider pattern

**Regex**: `^provider$`
 - `private static LoggerProvider provider`
