# {Type}Utility

Utility classes provide helper methods for grammar elements. All methods are static with no instance state.

## ALL methods are static

Utility classes have no instance methods, constructors, or variables. All methods (public and private) must be static.

**Regex**: `^(public|private)\s+static\s+\S+\s+[a-z]\w+\(`
 - `public static boolean isTag(String word)`
 - `public static String getStepObjectName(String text)`
 - `private static String cellsToString(List<ICell> cells)`
 - `private static String normalizePipeDelimitedString(String pipeDelimitedString)`
 - `private static String getGroup(String regex, String text, int group)`
 - `private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep)`

## SOME methods are validation methods

Boolean methods for classification and validation checks. Method names follow is{Condition} pattern.

**Regex**: `^public\s+static\s+boolean\s+is[A-Z]\w+\(`
 - `public static boolean isValid(String text)`
 - `public static boolean isTag(String word)`
 - `public static boolean isTodo(String word)`
 - `public static boolean isEdge(String text)`
 - `public static boolean isVertex(String text)`
 - `public static boolean isNegativeStep(String text)`

## SOME methods are parsing methods

Extract components from composite String values. Method names follow get{Component} pattern, accept String parameter, return String or collection.

**Regex**: `^public\s+static\s+\S+\s+get[A-Z]\w+\(String\s+[a-z]\w+\)$`
 - `public static String getStepObjectName(String text)`
 - `public static String getComponent(String text)`
 - `public static String getComponentName(String text)`
 - `public static String getComponentType(String text)`
 - `public static String getObject(String text)`
 - `public static String getObjectName(String text)`
 - `public static String getObjectType(String text)`
 - `public static String getStepDefinitionName(String text)`
 - `public static TreeSet<String> getTags(String name)`

## SOME methods are derived attributes

Compute values from grammar object graphs. Method names follow get{Attribute} pattern, accept I{Type} or collection parameters, return computed values. A derived attribute is an attribute that's in the I{Type} interfaces but not in the grammar itself.

**Regex**: `^public\s+static\s+\S+\s+get[A-Z]\w+\((I{Type}|List|ArrayList)[^)]*\)$`
 - `public static String getNameLong(ITestStep theStep)`
 - `public static String getStepObjectQualifiedName(ITestStep theStep)`
 - `public static ArrayList<String> getComponentList(ITestProject testProject)`
 - `public static ArrayList<IStepObject> getStepObjectList(ITestProject testProject, String component)`
 - `public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String pipeDelimitedString)`
 - `public static String getStatementListAsString(List<IStatement> statementList)`

**Behavioral Notes**:
- TestStepUtility contains complex regex patterns (20+ capture groups) for parsing test step names
- Some utilities have private helper methods that don't follow public API patterns
- Parsing methods use regex or string manipulation to extract components
- Derived attributes may navigate object graphs or aggregate data from collections
