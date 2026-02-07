# {Language}IssueProposal

Data transfer object for Eclipse Quick Fix proposals. Contains four private String attributes with standard JavaBeans getters and setters.

## {Language}IssueProposal()

Default constructor initializes all attributes to empty strings.

**Rule**: ONE constructor names match default constructor pattern

**Regex**: `^public\s+{Language}IssueProposal\(\)$`
 - `public SheepDogIssueProposal()`

## {Language}IssueProposal(String, String, String)

Parameterized constructor accepts id, description, and value (qualifiedName is set separately).

**Rule**: ONE constructor names match parameterized constructor pattern

**Regex**: `^public\s+{Language}IssueProposal\(String\s+\w+,\s*String\s+\w+,\s*String\s+\w+\)$`
 - `public SheepDogIssueProposal(String id, String description, String value)`

## get(Id|Description|Value|QualifiedName)()

Getters provide read access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow getter pattern

**Regex**: `^public\s+String\s+get(Id|Description|Value|QualifiedName)\(\)$`
 - `public String getId()`
 - `public String getDescription()`
 - `public String getValue()`
 - `public String getQualifiedName()`

## set(Id|Description|Value|QualifiedName)(String)

Setters provide write access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow setter pattern

**Regex**: `^public\s+void\s+set(Id|Description|Value|QualifiedName)\(String\s+\w+\)$`
 - `public void setId(String id)`
 - `public void setDescription(String description)`
 - `public void setValue(String value)`
 - `public void setQualifiedName(String qualifiedName)`
