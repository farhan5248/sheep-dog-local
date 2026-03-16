# {ObjectName}{ObjectType}Impl

**Extends**: TestObject{Language}Impl

**Implements**: {ObjectName}{ObjectType}

**Desc**: Test object implementation that bridges Cucumber step definitions to grammar model operations. Edge types (Action) buffer parameters in `properties` via setters, then consume them in performed methods. Vertex types (File, Popup, Annotation) operate directly on the document model or dialog state.

## get{Type}{Assignment}

**Desc**: Vertex getter that operates directly on the document model. If Param=NodePath, navigates via setCursorAtNode and returns cursor. If Param=State, returns state or listToString. Otherwise, asserts via assert{Type}{Assignment}.

**Rule**: ALL method names follow get{Type}{Assignment} pattern.
 - **Name**: `^get{Type}{Assignment}$`
 - **Return**: `^String$`
 - **Parameters**: `^\(HashMap<String,\s*String>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getCellListNodeCellName(HashMap<String, String> keyMap)`
 - `public String getCellListNodeNodePath(HashMap<String, String> keyMap)`
 - `public String getDescriptionNodeState(HashMap<String, String> keyMap)`
 - `public String getStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap)`

## set{Type}{Assignment}

**Desc**: Edge classes buffer a step parameter value from keyMap into the properties map. Vertex classes operate directly on the model: if Param=NodePath, creates dependencies via createNodeDependencies. Otherwise, adds via add{Type}With{Assignment}.

**Rule**: ALL method names follow set{Type}{Assignment} pattern.
 - **Name**: `^set{Type}{Assignment}$`
 - **Return**: `^void$`
 - **Parameters**: `^\(HashMap<String,\s*String>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setTestSuiteFullName(HashMap<String, String> keyMap)`
 - `public void setNodePath(HashMap<String, String> keyMap)`
 - `public void setCellListNodeNodePath(HashMap<String, String> keyMap)`
 - `public void setCellListNodeCellName(HashMap<String, String> keyMap)`

## get{StateDesc}

**Desc**: Vertex getter for document-level or dialog-level state. Document get retrieves via testProject.getTestDocument. Dialog read returns dialog string or listToString(dialog). Proposal read iterates dialog list, matches by Id, and returns field.

**Rule**: ALL method names follow get{StateDesc} pattern.
 - **Name**: `^get{StateDesc}$`
 - **Return**: `^String$`
 - **Parameters**: `^\(HashMap<String,\s*String>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public String getCreatedAsFollows(HashMap<String, String> keyMap)`
 - `public String getEmpty(HashMap<String, String> keyMap)`
 - `public String getSetAsFollows(HashMap<String, String> keyMap)`
 - `public String getProposalId(HashMap<String, String> keyMap)`
 - `public String getContent(HashMap<String, String> keyMap)`

## set{StateDesc}

**Desc**: Edge classes consume buffered properties to execute an action (navigate then create/modify/validate/fix). Vertex File classes create documents via add{Type}WithFullName. Vertex Popup/Annotation classes write to dialog state.

**Rule**: ALL method names follow set{StateDesc} pattern.
 - **Name**: `^set{StateDesc}$`
 - **Return**: `^void$`
 - **Parameters**: `^\(HashMap<String,\s*String>\s+\w+\)$`
 - **Modifier**: `^public$`

**Examples**:
 - `public void setPerformedToCreateATestSuiteWith(HashMap<String, String> keyMap)`
 - `public void setPerformedAsFollows(HashMap<String, String> keyMap)`
 - `public void setPerformedToModifyTestStepListWith(HashMap<String, String> keyMap)`
 - `public void setCreated(HashMap<String, String> keyMap)`
 - `public void setContent(HashMap<String, String> keyMap)`
 - `public void setEmpty(HashMap<String, String> keyMap)`

## navigateToDocument

**Desc**: Private helper that navigates cursor to a document by consuming Test Suite Full Name or Step Object Full Name from properties.

**Rule**: SOME method names follow navigateToDocument pattern.
 - **Name**: `^navigateToDocument$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^private$`

**Examples**:
 - `private void navigateToDocument()`

## navigateToNode

**Desc**: Private helper that navigates cursor to a node position by consuming Node Path from properties.

**Rule**: SOME method names follow navigateToNode pattern.
 - **Name**: `^navigateToNode$`
 - **Return**: `^void$`
 - **Parameters**: `^\(\)$`
 - **Modifier**: `^private$`

**Examples**:
 - `private void navigateToNode()`

## applyProposal

**Desc**: Static helper that applies issue fix proposals to the current cursor element based on proposal value type.

**Rule**: SOME method names follow applyProposal pattern.
 - **Name**: `^applyProposal$`
 - **Return**: `^void$`
 - **Parameters**: `^\(ArrayList<SheepDogIssueProposal>\s+\w+\)$`
 - **Modifier**: `^private\s+static$`

**Examples**:
 - `private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals)`
