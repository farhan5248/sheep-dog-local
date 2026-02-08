# {Type}IssueDetector

Validation logic for grammar elements at different scopes. Separates validation rules from grammar model and UI, enabling reuse across editors and build tools.

## validate{Assignment}{Issue}

**Desc**: Validates a specific grammar assignment at element-only, file, or workspace scope, returning empty string if valid or error description if invalid.

**Rule**: ALL method names follow validate{Assignment}{Issue} pattern.
 - **Name**: `^validate{Assignment}{Issue}$`
 - **Return**: `^String$`
 - **Parameters**: `^\(I{Type}\s+[a-z]\w+\)$`
 - **Modifier**: `^public\s+static$`

**Examples**:
 - `public static String validateNameOnly(ICell theCell)`
 - `public static String validateNameOnly(ITestStepContainer theTestStepContainer)`
 - `public static String validateTestStepListFile(ITestStepContainer theTestStepContainer)`
 - `public static String validateStepObjectNameOnly(ITestStep theTestStep)`
 - `public static String validateStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static String validateStepDefinitionNameOnly(ITestStep theTestStep)`
 - `public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static String validateCellListWorkspace(IRow theRow)`
