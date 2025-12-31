# UML Communication Patterns

These are the patterns that all classes follow:

## Interface Definition

**Rules**
- There is no proposal, validation or correction for the grammar element.

**Class Name**
- Always has one interface per **Feature** named I**Feature**
- Might have one class per **Feature** named **Feature**Utility
- Might have multiple classes per **Feature** named **FeatureAspect**Types

## Content Proposal

**Rules**
- Applies when proposing alternatives to empty grammar elements.

**Class Name**
- Always has one interface per **Feature** named I**Feature**
- Might have one class per **Feature** named **Feature**Utility
- Might have multiple classes per **Feature** named **FeatureAspect**Types
- Always has a class named **Language**IssueProposal
- Always has one class per **Feature** named **Feature**IssueResolver

## Content Validation

**Rules**
- Applies when validating non-empty grammar elements.

**Class Name**
- Always has one interface per **Feature** named I**Feature**
- Might have one class per **Feature** named **Feature**Utility
- Might have multiple classes per **Feature** named **FeatureAspect**Types
- Always has one class per **Feature** named **Feature**IssueTypes
- Always has one class per **Feature** named **Feature**IssueDetector

## Content Correction

**Rules**
- Applies when proposing alternatives to non-empty invalid grammar elements.

**Class Name**
- Always has one interface per **Feature** named I**Feature**
- Might have one class per **Feature** named **Feature**Utility
- Might have multiple classes per **Feature** named **FeatureAspect**Types
- Always has a class named **Language**IssueProposal
- Always has one class per **Feature** named **Feature**IssueResolver
- Always has one class per **Feature** named **Feature**IssueTypes
- Always has one class per **Feature** named **Feature**IssueDetector
