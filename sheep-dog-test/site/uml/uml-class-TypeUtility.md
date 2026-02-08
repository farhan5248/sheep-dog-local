# {Type}Utility

Utility classes provide helper methods for grammar elements. All methods are static with no instance state.

## static

**Desc**: Utility classes have no instance methods, constructors, or variables. All methods (public and private) must be static.

**Rule**: SOME methods are static.
 - **Name**: `^(get|set|add|is)`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static boolean isTag(String text)`
 - `public static String getStepObjectName(String text)`
