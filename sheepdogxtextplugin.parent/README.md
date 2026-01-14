# Sheep Dog Xtext Plugin for Eclipse

Eclipse IDE plugin providing language support for Sheep Dog AsciiDoc specifications.

## Overview

This is a multi-module Eclipse plugin project that provides full IDE support for editing AsciiDoc specification files within Eclipse. It includes syntax highlighting, validation with quick fixes, content assist, and code generation capabilities.

## Sub-projects

- **sheepdogxtextplugin**: Core Xtext grammar and parser for Sheep Dog AsciiDoc DSL
- **sheepdogxtextplugin.ide**: IDE-agnostic language services
- **sheepdogxtextplugin.ui**: Eclipse-specific UI integration (editors, views, wizards)
- **sheepdogxtextplugin.feature**: Eclipse feature for plugin distribution
- **sheepdogxtextplugin.repository**: Eclipse p2 update site
- **sheepdogxtextplugin.tests**: Grammar and validation tests
- **sheepdogxtextplugin.ui.tests**: UI integration tests

## Key Functionality

- Syntax highlighting and formatting
- Real-time validation with quick-fix proposals
- Content assist and code completion
- Code generation via SheepDogGenerator
- Cross-reference scoping

## Technology

- Maven + Tycho for Eclipse plugin build
- Eclipse Xtext 2.41
- Eclipse p2 update site for distribution
- Targets Windows, macOS, Linux
- Java 21
