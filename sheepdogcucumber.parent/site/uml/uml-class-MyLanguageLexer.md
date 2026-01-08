# MyCucumberLexer

## MyCucumberLexer extends InternalCucumberLexer

Custom lexer that overrides the generated lexer to handle context-sensitive tokenization.

**Examples**

- ```java
  // MyCucumberLexer.java
  public class MyCucumberLexer extends InternalCucumberLexer {
  ```

## MyCucumberLexer has nextTokenIsWORD flag for table cell context

After encountering `|`, the next token should be treated as WORD even if it matches a keyword. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#class-structure) for pattern.

## MyCucumberLexer has useDefaultLexer flag for step keyword context

After step keywords (Given/When/Then/And/But/*), delegate to the generated lexer for the remainder of the line. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#class-structure) for pattern.

## MyCucumberLexer has three constructors

Default constructor, CharStream constructor, and CharStream with RecognizerSharedState constructor. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#class-structure) for pattern.

## isKeyword method uses input.LA() for character lookahead

Checks if the upcoming characters match the given keyword without consuming tokens. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#lookahead-pattern) for pattern.

## printNextToken method provides debug output

Outputs the next token text for debugging purposes. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#debug-logging-method) for pattern.

## mTokens method checks Cucumber keywords in priority order

Overrides generated mTokens to control token recognition with state management. Uses Cucumber-specific keywords (no colons on step keywords, `"""` for docstrings, `@` for tags). See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#mtokens-override-pattern) for base pattern.

**Examples**

- ```java
  // MyCucumberLexer.java - Cucumber-specific keyword order
  } else if (isKeyword("\"\"\"")) {
      mT__22();
  } else if (isKeyword("Object:")) {
      mT__13();
  } else if (isKeyword("Feature:")) {
      mT__16();
  } else if (isKeyword("Scenario Outline:")) {
      mT__19();
  } else if (isKeyword("Scenario:")) {
      mT__18();
  } else if (isKeyword("@")) {
      mT__29();
  } else if (isKeyword("Given")) {
      mT__23();
      useDefaultLexer = true;
  } else if (isKeyword("But")) {
      mT__27();
      useDefaultLexer = true;
  ```
