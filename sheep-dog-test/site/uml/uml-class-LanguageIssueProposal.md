# {Language}IssueProposal

Data transfer object for Eclipse Quick Fix proposals. Contains four private String attributes with standard JavaBeans getters and setters.

## {Language}IssueProposal

**Desc**: Default constructor initializes all attributes to empty strings.

**Rule**: ONE constructor names match default constructor pattern.
 - **Name**: `^{Language}IssueProposal$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public SheepDogIssueProposal()`

## get{Proposal}

**Desc**: Getters provide read access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow getter pattern.
 - **Name**: `^get{Proposal}$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getId()`
 - `public String getDescription()`
 - `public String getValue()`
 - `public String getQualifiedName()`

## set{Proposal}

**Desc**: Setters provide write access to private attributes following JavaBeans convention.

**Rule**: SOME method names follow setter pattern. 
 - **Name**: `^set{Proposal}$`
 - **Return**: `^void$`
 - **Parameters**: `^\(String\s+\w+\)$`

**Examples**:
 - `public void setId(String id)`
 - `public void setDescription(String description)`
 - `public void setValue(String value)`
 - `public void setQualifiedName(String qualifiedName)`

## toString

**Desc**: Output a description of the proposal

**Rule**: SOME method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
