# IResourceRepository

Service interface for resource management operations.

## ALL method names follow CRUD operation patterns

Repository methods follow standard CRUD (Create, Read, Update, Delete) naming conventions using verbs: get, put, delete, list, clear, contains.

**Regex Filters** (method must match at least one):
1. `^get$` - Retrieve single resource
2. `^put$` - Store/update resource
3. `^delete$` - Delete resource
4. `^list$` - List resources
5. `^clear$` - Clear resources
6. `^contains$` - Check resource existence

**Examples**

```java
// IResourceRepository.java
package org.farhan.dsl.lang;

import java.util.List;

public interface IResourceRepository {
    void clear(String tags);
    boolean contains(String tags, String path);
    void delete(String tags, String path);
    String get(String tags, String path) throws Exception;
    List<String> list(String tags, String path, String extension);
    void put(String tags, String path, String content) throws Exception;
}
```
