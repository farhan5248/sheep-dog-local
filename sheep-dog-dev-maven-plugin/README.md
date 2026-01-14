# Sheep Dog Development Maven Plugin

Maven plugin for local/offline specification transformations.

## Overview

This plugin runs the sheep-dog-dev transformation library directly in the Maven build process, without requiring the cloud service. It performs all transformations in-process, making it suitable for offline development or CI environments without network access to the cloud service.

## Key Functionality

- Maven goals for AsciiDoctor to UML transformation
- Maven goals for UML to AsciiDoctor generation
- Maven goals for Cucumber to UML transformation
- Maven goals for UML to Cucumber generation (plain, Guice, Spring variants)
- Reads/writes files directly to the local filesystem
- Tag-based filtering for selective transformations

## Technology

- Maven Plugin API
- Embeds sheep-dog-dev library for in-process transformations
- Java 21
