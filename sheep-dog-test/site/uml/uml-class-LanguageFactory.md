# {Language}Factory

Singleton holder class that provides access to the concrete factory implementation. Contains only the static instance field.

## instance

**Desc**: The factory class holds a static instance field that references the concrete I{Language}Factory implementation.

**Rule**: ONE attribute names match instance pattern.
 - **Name**: `^instance$`
 - **Return**: `^I{Language}Factory$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ISheepDogFactory instance`
