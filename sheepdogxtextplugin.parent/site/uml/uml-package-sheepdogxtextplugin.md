# UML Package Patterns

## org.farhan.dsl.sheepdog

### {Language}RuntimeModule

**Examples:**
- SheepDogRuntimeModule

## org.farhan.dsl.sheepdog.impl

### {Feature}Impl

- Always has one class per **{Feature}** named **{Feature}Impl**

**Examples:**
- TestStepImpl
- TextImpl
- TestSuiteImpl
- StepObjectImpl
- SheepDogFactoryImpl
- EclipseFileRepository

## org.farhan.dsl.sheepdog.validation

### {Language}Validator
- Contains custom validation class {Language}Validator

**Examples:**
- SheepDogValidator

## org.farhan.dsl.sheepdog.formatting2

### {Language}Formatter

- Contains {Language}Formatter as main entry point

**Examples:**
- SheepDogFormatter

### {Feature}Formatter

- Contains one {Feature}Formatter per grammar feature
- Contains TextReplacer for formatting hidden regions
- Uses polymorphic pattern with factory methods for union types
- Manually created to define formatting rules

**Examples:**
- TestStepFormatter
- TestSuiteFormatter

### Formatter

- Formatter is the base class for **{Feature}Formatter**

## org.farhan.dsl.sheepdog.generator

### {Language}Generator

**Examples:**
- SheepDogGenerator

### {Language}OutputConfigurationProvider

**Examples:**
- SheepDogOutputConfigurationProvider

## org.farhan.dsl.sheepdog.parser.antlr

### My{Language}Parser

**Examples:**
- MySheepDogParser

## org.farhan.dsl.sheepdog.parser.antlr.internal

### My{Language}Lexer

**Examples:**
- MySheepDogLexer
