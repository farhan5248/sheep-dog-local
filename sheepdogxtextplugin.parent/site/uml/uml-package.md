# UML Package Patterns

## org.farhan.dsl.sheepdog

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains Xtext-generated grammar model classes named **{Language}.xtext**
- Controlled by `grammar org.farhan.dsl.sheepdog.SheepDog` declaration in .xtext file
- Contains union types (Model, TestStepContainer) and concrete types (TestSuite, TestStep, Cell, etc.)

**Examples:**
- Model (union: StepObject | TestSuite)
- TestStepContainer (union: TestSetup | TestCase)
- TestSuite, TestStep, Cell, Row, Table, Text

## org.farhan.dsl.sheepdog.impl

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Always has one class per **{Feature}** named **{Feature}Impl**

**Examples:**
- TestStepImpl
- TextImpl
- TestSuiteImpl
- StepObjectImpl
- SheepDogFactoryImpl
- EclipseFileRepository

## org.farhan.dsl.sheepdog.validation

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains custom validation class {Language}Validator

**Examples:**
- SheepDogValidator

## org.farhan.dsl.sheepdog.ui.contentassist

**Sub-Projects:**
- sheepdogxtextplugin.ui

**Rules**
- Contains {Language}ProposalProvider for content assist

**Examples:**
- SheepDogProposalProvider

## org.farhan.dsl.sheepdog.ui.quickfix

**Sub-Projects:**
- sheepdogxtextplugin.ui

**Rules**
- Contains {Language}QuickfixProvider for quick fixes

**Examples:**
- SheepDogQuickfixProvider

## org.farhan.dsl.sheepdog.formatting2

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains {Language}Formatter as main entry point
- Contains one {Feature}Formatter per grammar feature
- Contains TextReplacer for formatting hidden regions
- Uses polymorphic pattern with factory methods for union types
- Manually created to define formatting rules

**Examples:**
- SheepDogFormatter
- TestStepFormatter, CellFormatter, RowFormatter, TableFormatter
- TestSuiteFormatter, TestStepContainerFormatter, TestCaseFormatter
- StepObjectFormatter, StepDefinitionFormatter
- TextReplacer, Formatter (base class)

## org.farhan.dsl.sheepdog

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains {Language}RuntimeModule for dependency injection bindings
- Contains {Language}StandaloneSetup for standalone initialization
- Might be manually modified to configure parser and generator bindings

**Examples:**
- SheepDogRuntimeModule
- SheepDogStandaloneSetup

## org.farhan.generator

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains {Language}Generator for code generation
- Contains {Language}OutputConfigurationProvider for output configuration
- Manually created to define code generation behavior

**Examples:**
- SheepDogGenerator
- SheepDogOutputConfigurationProvider

## org.farhan.dsl.sheepdog.parser.antlr

**Sub-Projects:**
- sheepdogxtextplugin

**Rules**
- Contains custom parser classes
- Might be manually modified to customize parsing behavior

**Examples:**
- My{Language}Parser
- internal.My{Language}Lexer

## org.farhan.ui

**Sub-Projects:**
- sheepdogxtextplugin.ui

**Rules**
- Contains {Language}UiModule for UI dependency injection bindings
- Might be manually modified to configure syntax highlighting and other UI features

**Examples:**
- {Language}UiModule

## org.farhan.ui.syntaxcoloring

**Sub-Projects:**
- sheepdogxtextplugin.ui

**Rules**
- Contains {Language}AntlrTokenToAttributeIdMapper for token-to-style mapping
- Contains {Language}HighlightingConfiguration for style definitions
- Contains {Language}SemanticHighlightingCalculator for semantic highlighting
- Manually created to define syntax coloring behavior

**Examples:**
- {Language}AntlrTokenToAttributeIdMapper
- {Language}HighlightingConfiguration
- {Language}SemanticHighlightingCalculator
