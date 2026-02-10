# {Type}Fragments

Parser utilities for extracting typed fragments from formatted text strings. Separates parsing logic from grammar model classes, using regex patterns to extract components based on domain-specific syntax rules.

## get{Fragment}

**Desc**: Extracts a specific named fragment from formatted text using predefined regex patterns and group positions.

**Rule**: SOME method names follow get{Fragment} pattern.
 - **Name**: `^get{Fragment}(Desc|Type|Name|Edge|Vertex)*$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getComponent(String text)`
 - `public static String getObject(String text)`
 - `public static String getTagDesc(String text)`

## getAll

**Desc**: Extracts the complete matched text from formatted input, returning the entire reference as a single string for full pattern validation or processing.

**Rule**: SOME method names follow getAll pattern.
 - **Name**: `^getAll$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String getAll(String text)`

## get{Fragment}AsList

**Desc**: Extracts multiple occurrences of a fragment type from text and returns them as a collection for batch processing.

**Rule**: SOME method names follow get{Fragment}AsList pattern.
 - **Name**: `^get{Fragment}AsList$`
 - **Return**: `^ArrayList<String>$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static ArrayList<String> getTagAsList(String name)`

## is{Fragment}

**Desc**: Tests whether text contains or matches a specific fragment pattern, returning boolean result for conditional logic.

**Rule**: SOME method names follow is{Fragment} pattern.
 - **Name**: `^is{Fragment}(Desc|Type|Name|Edge|Vertex)*$`
 - **Return**: `^boolean$`
 - **Parameters**: `^\(String\s+\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static boolean isTag(String text)`
 - `public static boolean isObjectEdgeType(String text)`
