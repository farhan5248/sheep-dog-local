# CucumberLexer

## CucumberLexer extends InternalCucumberLexer

Custom lexer that overrides the generated lexer to handle context-sensitive tokenization.

**Examples**

- ```java
  // CucumberLexer.java
  public class CucumberLexer extends InternalCucumberLexer {
  ```

## CucumberLexer has hasNoDelimiter flag for keywords and step keywords

After keywords like `Feature:`, `Scenario:`, AND step keywords (`Given`, `When`, `Then`, `And`, `But`, `*`), treat following tokens as WORD. Cucumber step text is plain text with no embedded keywords to parse. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#state-flags) for pattern.

## CucumberLexer has hasConstantDelimiter flag for table cell and tag context

After encountering `|` (table cells) or `@` (tags), check for same delimiter or treat as WORD. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#state-flags) for pattern.

## CucumberLexer has three constructors

Default constructor, CharStream constructor, and CharStream with RecognizerSharedState constructor. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#class-structure) for pattern.

## isKeyword method uses input.LA() for character lookahead

Checks if the upcoming characters match the given keyword without consuming tokens. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#lookahead-pattern) for pattern.

## printNextToken method provides debug output

Outputs the next token text for debugging using `logger.debug()`. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#debug-logging-method) for pattern.

## mTokens method checks keywords by category

Overrides generated mTokens to control token recognition with delimiter-based state management. Uses `"""` for RAWTEXT delimiter. Categories: whitespace, multi-line, delimiter reset, greedy collection, single-line tokens. See [impl-xtext-grammar.md](../../../impl-xtext-grammar.md#mtokens-override-pattern) for pattern.
