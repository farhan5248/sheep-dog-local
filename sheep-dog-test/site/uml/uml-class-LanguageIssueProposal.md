# {Language}IssueProposal

Data transfer object holding quick fix proposal data. Separates proposal data (id, description, value, qualifiedName) from proposal generation and application logic.

## {Language}IssueProposal

**Desc**: Initializes all proposal fields to empty strings for subsequent population.

**Rule**: ONE constructor names match default constructor pattern.
 - **Name**: `^{Language}IssueProposal$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public SheepDogIssueProposal()`

## get{Proposal}

**Desc**: Provides read access to proposal attributes, allowing resolvers and UI to query proposal details.

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

**Desc**: Provides write access for resolvers to populate proposal attributes during generation.

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

**Desc**: Generates formatted string representation for debugging and logging purposes.

**Rule**: SOME method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
