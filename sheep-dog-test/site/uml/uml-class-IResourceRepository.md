# IResourceRepository

Repository interface for file I/O operations. Separates persistence contracts from business logic, allowing different implementations (filesystem, in-memory, Eclipse workspace).

## {IO}

**Desc**: Performs CRUD operations on tagged file resources using standard repository method naming.

**Rule**: ALL method names follow CRUD operation patterns.
 - **Name**: `^(get|put|delete|list|clear|contains)$`

**Examples**:
 - `void clear(String tags)`
 - `boolean contains(String tags, String path)`
 - `void delete(String tags, String path)`
 - `String get(String tags, String path)`
 - `List<String> list(String tags, String path, String extension)`
 - `void put(String tags, String path, String content)`
