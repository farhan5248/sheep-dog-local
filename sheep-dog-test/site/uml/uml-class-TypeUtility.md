# {Type}Utility

Static helper methods for grammar element operations. Separates utility operations from grammar model classes, keeping interfaces focused on data access.

## static

**Desc**: Performs parsing, formatting, or computation operations on grammar elements without maintaining state.

**Rule**: SOME methods are static.
 - **Name**: `^(get|set|add|is)`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static boolean isTag(String text)`
 - `public static String getStepObjectName(String text)`
