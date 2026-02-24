# IResourceRepository

Repository interface for file I/O operations. Separates persistence contracts from business logic, allowing different implementations (filesystem, in-memory, Eclipse workspace).

## get

**Desc**: Retrieves file content by tags and path.

**Rule**: ONE method names follow get pattern.
 - **Name**: `^get$`
 - **Return**: `^String$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+\)$`

**Examples**:
 - `String get(String tags, String path)`

## put

**Desc**: Writes file content by tags and path.

**Rule**: ONE method names follow put pattern.
 - **Name**: `^put$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+,\s*String\s+\w+\)$`

**Examples**:
 - `void put(String tags, String path, String content)`

## delete

**Desc**: Removes a file resource by tags and path.

**Rule**: ONE method names follow delete pattern.
 - **Name**: `^delete$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+\)$`

**Examples**:
 - `void delete(String tags, String path)`

## list

**Desc**: Lists file resources matching tags, path, and extension.

**Rule**: ONE method names follow list pattern.
 - **Name**: `^list$`
 - **Return**: `^List<String>$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+,\s*String\s+\w+\)$`

**Examples**:
 - `List<String> list(String tags, String path, String extension)`

## clear

**Desc**: Removes all file resources matching tags.

**Rule**: ONE method names follow clear pattern.
 - **Name**: `^clear$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`

**Examples**:
 - `void clear(String tags)`

## contains

**Desc**: Checks whether a file resource exists for tags and path.

**Rule**: ONE method names follow contains pattern.
 - **Name**: `^contains$`
 - **Return**: `^boolean$`
 - **Parameters**: `^\(String\s+\w+,\s*String\s+\w+\)$`

**Examples**:
 - `boolean contains(String tags, String path)`
