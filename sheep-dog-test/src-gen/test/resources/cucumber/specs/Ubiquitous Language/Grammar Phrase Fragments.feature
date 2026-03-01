@sheep-dog-test
Feature: Grammar Phrase Fragments

  \@sheep-dog-test
  A phrase is a sequence of words. Tags and TODOs are special phrases.

  @Grammar
  Scenario Outline: Tag Fragment

    \@Grammar

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file line type is created as follows
          | Line   |
          | <Line> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file phrase tag fragment will be decomposed as follows
          | Tag List   |
          | <Tag List> |

    Examples: Fragments

          | Line              | Tag List         |
          | @tag1             | tag1             |
          | @tag1 @tag2 @tag3 | tag1, tag2, tag3 |
          | @tag1 TODO @tag3  | empty            |
          | TODO @tag2 @tag3  | empty            |

  @Grammar
  Scenario Outline: Todo Fragment

    \@Grammar

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file line type is created as follows
          | Line   |
          | <Line> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file phrase todo fragment will be decomposed as follows
          | Todo Type   | Todo Description   |
          | <Todo Type> | <Todo Description> |

    Examples: Fragments

          | Line              | Todo Type | Todo Description |
          | TODO Do something | TODO      | Do something     |
          | @tag1 TODO @tag3  | TODO      | @tag3            |
          | TODO @tag2 @tag3  | TODO      | @tag2 @tag3      |

