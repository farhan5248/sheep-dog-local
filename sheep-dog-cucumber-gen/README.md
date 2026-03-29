# Sheep Dog Development Library

Core transformation library that converts specifications to UML models and generates code.

## Overview

This is the heart of the Sheep Dog ecosystem. It provides bidirectional transformations between AsciiDoctor/Cucumber specifications and Eclipse UML2 models. It can also generate Java step definition classes from UML models for different testing frameworks.

## Key Functionality

- AsciiDoctor to UML model transformation
- UML model to AsciiDoctor generation
- Cucumber to UML model transformation
- UML model to Cucumber feature generation
- Java step definition code generation (plain, Guice, Spring variants)
- UML model classes: TestProject, TestSuite, TestCase, TestStep, StepDefinition, StepObject

## Technology

- Eclipse UML2 for model representation
- Eclipse Xtext for DSL parsing
- JavaParser for Java code generation
- Depends on sheepdogxtextplugin and sheepdogcucumber
- Java 21
