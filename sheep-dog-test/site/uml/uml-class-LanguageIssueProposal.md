# {Language}IssueProposal

Data transfer object for Eclipse Quick Fix proposals. Contains four private String attributes with standard JavaBeans getters and setters.

## {Language}IssueProposal

Default constructor initializes all attributes to empty strings.

**Rule**: ONE constructor names match default constructor pattern

**Regex**: `^public\s+{Language}IssueProposal\(\)$`
 - `public SheepDogIssueProposal()`

## get{Proposal}

Getters provide read access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow getter pattern

**Regex**: `^public\s+String\s+get{Proposal}\(\)$`
 - `public String getId()`
 - `public String getDescription()`
 - `public String getValue()`
 - `public String getQualifiedName()`

## set{Proposal}

Setters provide write access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow setter pattern

**Regex**: `^public\s+void\s+set{Proposal}\(String\s+\w+\)$`
 - `public void setId(String id)`
 - `public void setDescription(String description)`
 - `public void setValue(String value)`
 - `public void setQualifiedName(String qualifiedName)`
