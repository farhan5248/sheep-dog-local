# TestConfig

**Directory**: `src/test/java/org/farhan/impl`

**Extends**: AbstractModule

**Implements**: InjectorSource

## configure

**Desc**: Binds each `src-gen/test/java/org/farhan/objects` interface to its corresponding `src/test/java/org/farhan/impl` class via Guice `bind().to()`.

**Rule**: ALL method names follow configure pattern.
 - **Name**: `^configure$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^protected$`

**Examples**:
 - `protected void configure()`

## getInjector

**Desc**: Creates a Guice injector with DEVELOPMENT stage, Cucumber scenario module, and this TestConfig module.

**Rule**: ALL method names follow getInjector pattern.
 - **Name**: `^getInjector$`
 - **Return**: `^Injector$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public Injector getInjector()`

## resetTestProject

**Desc**: Cucumber @Before hook that resets TestObject and TestObjectSheepDogImpl static state before each scenario.

**Rule**: ALL method names follow resetTestProject pattern.
 - **Name**: `^resetTestProject$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void resetTestProject()`
