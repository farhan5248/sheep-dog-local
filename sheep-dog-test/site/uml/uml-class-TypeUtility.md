# {Type}Utility

Utility classes provide helper methods for grammar elements. All methods are static with no instance state.

## {Accessor}

Utility classes have no instance methods, constructors, or variables. All methods (public and private) must be static.

**Rule**: ALL methods are static

**Regex**: `^public\s+static\s+{Accessor}(`
 - `public static boolean isTag(String text)`
 - `public static String getStepObjectName(String text)`
