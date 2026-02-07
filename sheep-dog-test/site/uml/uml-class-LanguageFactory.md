# {Language}Factory

Singleton holder class that provides access to the concrete factory implementation. Contains only the static instance field.

## instance

The factory class holds a static instance field that references the concrete I{Language}Factory implementation.

**Rule**: ONE attribute names match instance pattern

**Regex**: `^public\s+static\s+I{Language}Factory\s+instance$`
 - `public static ISheepDogFactory instance`
