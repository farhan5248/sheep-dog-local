# IResourceRepository

Service interface for resource management operations.

## {IO}

Repository methods follow standard CRUD (Create, Read, Update, Delete) naming conventions using verbs: get, put, delete, list, clear, contains.

**Rule**: ALL method names follow CRUD operation patterns

**Regex**: `^(get|put|delete|list|clear|contains)$`
 - `void clear(String tags)`
 - `boolean contains(String tags, String path)`
 - `void delete(String tags, String path)`
 - `String get(String tags, String path)`
 - `List<String> list(String tags, String path, String extension)`
 - `void put(String tags, String path, String content)`
