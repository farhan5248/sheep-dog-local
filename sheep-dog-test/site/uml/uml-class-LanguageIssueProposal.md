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

**Desc**: Provides read access to proposal attributes, allowing resolvers and UI to query proposal details. getValue returns Object to support both String and IStepObject types.

**Rule**: SOME method names follow getter pattern.
 - **Name**: `^get{Proposal}$`
 - **Return**: `^(String|Object)$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getId()`
 - `public String getDescription()`
 - `public Object getValue()`

## set{Proposal}

**Desc**: Provides write access for resolvers to populate proposal attributes during generation. setValue accepts Object to support both String and IStepObject types.

**Rule**: SOME method names follow setter pattern.
 - **Name**: `^set{Proposal}$`
 - **Return**: `^void$`
 - **Parameters**: `^\((String|Object)\s+\w+\)$`

**Examples**:
 - `public void setId(String id)`
 - `public void setDescription(String description)`
 - `public void setValue(Object value)`

## toString

**Desc**: Generates formatted string representation for debugging and logging purposes.

**Rule**: ONE method names follow toString pattern.
 - **Name**: `^toString$`
 - **Return**: `^String$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String toString()`
