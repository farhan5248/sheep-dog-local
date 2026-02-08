# {Language}Factory

Singleton holder that provides global access to the concrete factory instance. Separates factory instance management from factory operations and builder logic.

## instance

**Desc**: Stores the concrete factory implementation, allowing builders and other consumers to create grammar instances.

**Rule**: ONE attribute names match instance pattern.
 - **Name**: `^instance$`
 - **Return**: `^I{Language}Factory$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ISheepDogFactory instance`
