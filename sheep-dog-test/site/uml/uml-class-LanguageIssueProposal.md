# {Language}IssueProposal

Data transfer object for Eclipse Quick Fix proposals. Contains four private String attributes with standard JavaBeans getters and setters.

## SOME attribute names match required fields pattern

The proposal class has four private String attributes for issue data.

**Regex**: `^private\s+String\s+(id|description|value|qualifiedName)$`
 - `private String id`
 - `private String description`
 - `private String value`
 - `private String qualifiedName`

## ONE constructor names match default constructor pattern

Default constructor initializes all attributes to empty strings.

**Regex**: `^public\s+{Language}IssueProposal\(\)$`
 - `public SheepDogIssueProposal()`

## ONE constructor names match parameterized constructor pattern

Parameterized constructor accepts id, description, and value (qualifiedName is set separately).

**Regex**: `^public\s+{Language}IssueProposal\(String\s+\w+,\s*String\s+\w+,\s*String\s+\w+\)$`
 - `public SheepDogIssueProposal(String id, String description, String value)`

## SOME method names follow getter pattern

Getters provide read access to private attributes following JavaBeans convention.

**Regex**: `^public\s+String\s+get(Id|Description|Value|QualifiedName)\(\)$`
 - `public String getId()`
 - `public String getDescription()`
 - `public String getValue()`
 - `public String getQualifiedName()`

## SOME method names follow setter pattern

Setters provide write access to private attributes following JavaBeans convention.

**Regex**: `^public\s+void\s+set(Id|Description|Value|QualifiedName)\(String\s+\w+\)$`
 - `public void setId(String id)`
 - `public void setDescription(String description)`
 - `public void setValue(String value)`
 - `public void setQualifiedName(String qualifiedName)`
