# {Type}IssueDetector

Validation detector for grammar element assignments. Methods validate assignment values at different scopes (element-level, file-level, cross-file).

## ALL method names follow validate{Assignment}{Issue} pattern

Detector methods validate specific grammar assignments at different validation scopes. Method name pattern is validate + {Assignment} + {Issue} where {Assignment} is the grammar assignment in PascalCase and {Issue} is the validation scope (Only=element, File=file, Workspace=cross-file). Parameter type must be I{Type} interface. Return type must be String (empty string = valid, error description = invalid).

**Regex**: `^public\s+static\s+String\s+validate{Assignment}{Issue}\(I{Type}\s+[a-z]\w+\)$`
 - `public static String validateNameOnly(ICell theCell)`
 - `public static String validateNameOnly(ITestStepContainer theTestStepContainer)`
 - `public static String validateTestStepListFile(ITestStepContainer theTestStepContainer)`
 - `public static String validateStepObjectNameOnly(ITestStep theTestStep)`
 - `public static String validateStepObjectNameWorkspace(ITestStep theTestStep)`
 - `public static String validateStepDefinitionNameOnly(ITestStep theTestStep)`
 - `public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep)`
 - `public static String validateCellListWorkspace(IRow theRow)`

**Behavioral Notes**:
- Only scope: Element-level validation (CheckType.FAST)
- File scope: File-level validation (CheckType.NORMAL)
- Workspace scope: Cross-file validation (CheckType.EXPENSIVE)
- Methods can throw Exception for validation errors
