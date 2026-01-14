# Sheep Dog Test Library

Shared DSL interfaces and utilities for the Sheep Dog ecosystem.

## Overview

This library provides common abstractions and utilities used across the Sheep Dog projects. It defines interfaces for test specifications that can be implemented by Xtext grammars, and provides validation logic with quick-fix proposals. It serves as a foundation for both the Eclipse and VS Code plugins.

## Key Functionality

- DSL interfaces: ITestProject, ITestSuite, ITestCase, ITestStep, IStepDefinition, IStepObject
- Issue detection for cells, rows, test steps, test suites
- Quick-fix proposal generation for detected issues
- Utility classes: StatementUtility, StepDefinitionUtility, TestStepUtility
- IResourceRepository interface for file/model persistence abstraction

## Technology

- Pure Java library (no framework dependencies)
- Used by Xtext plugins and transformation libraries
- Java 21
