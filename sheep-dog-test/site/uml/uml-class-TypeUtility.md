# {Type}Utility

Utility classes provide helper methods for grammar elements. All methods are static with no instance state.

## (public|private) static .* [a-z]\w+\(

Utility classes have no instance methods, constructors, or variables. All methods (public and private) must be static.

**Rule**: ALL methods are static

**Regex**: `^(public|private)\s+static\s+\S+\s+[a-z]\w+\(`
 - `public static boolean isTag(String word)`
 - `public static String getStepObjectName(String text)`
 - `private static String cellsToString(List<ICell> cells)`
 - `private static String normalizePipeDelimitedString(String pipeDelimitedString)`
 - `private static String getGroup(String regex, String text, int group)`
 - `private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep)`

## is[A-Z]\w+\(

Boolean methods for classification and validation checks. Method names follow is{Condition} pattern.

**Rule**: SOME methods are validation methods

**Regex**: `^public\s+static\s+boolean\s+is[A-Z]\w+\(`
 - `public static boolean isValid(String text)`
 - `public static boolean isTag(String word)`
 - `public static boolean isTodo(String word)`
 - `public static boolean isEdge(String text)`
 - `public static boolean isVertex(String text)`
 - `public static boolean isNegativeStep(String text)`

## get[A-Z]\w+\(String\)

Extract components from composite String values. Method names follow get{Component} pattern, accept String parameter, return String or collection.

**Rule**: SOME methods are parsing methods

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

## get[A-Z]\w+\((I{Type}|List|ArrayList)\)

Compute values from grammar object graphs. Method names follow get{Attribute} pattern, accept I{Type} or collection parameters, return computed values. A derived attribute is an attribute that's in the I{Type} interfaces but not in the grammar itself.

**Rule**: SOME methods are derived attributes

**Regex**: `^public\s+static\s+\S+\s+get[A-Z]\w+\((I{Type}|List|ArrayList)[^)]*\)$`
 - `public static String getNameLong(ITestStep theStep)`
 - `public static String getStepObjectQualifiedName(ITestStep theStep)`
 - `public static ArrayList<String> getComponentList(ITestProject testProject)`
 - `public static ArrayList<IStepObject> getStepObjectList(ITestProject testProject, String component)`
 - `public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String pipeDelimitedString)`
 - `public static String getStatementListAsString(List<IStatement> statementList)`
