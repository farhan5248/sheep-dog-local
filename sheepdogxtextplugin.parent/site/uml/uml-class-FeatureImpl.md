# {Feature}Impl

## {Feature}Impl implements I{Feature} interface

Wrapper classes implement framework-independent interfaces from org.farhan.dsl.lang.

Provides bridge pattern between Xtext EMF objects and business logic.

### {Feature}Impl

```java
public {Feature}Impl({Feature} eObject)
public String getName()
public void setName(String value)
public I{Parent} getParent()
public {Type} get{Attribute}()
```

## {Feature}Impl wraps EMF eObject

Wrapper delegates to underlying Xtext-generated EMF object for data access.

### {Feature}Impl

```java
public String getName()
// Calls: eObject.getName()

public I{Parent} getParent()
// Creates: Parent wrapper instance (lazy initialization)
// Calls: eObject.eContainer()
```
