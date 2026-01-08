package org.farhan.dsl.cucumber.parser.antlr.internal;

import org.eclipse.xtext.parser.antlr.Lexer;
import org.antlr.runtime.*;
import org.apache.log4j.Logger;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CucumberLexer extends InternalCucumberLexer {

	private static final Logger logger = Logger.getLogger(CucumberLexer.class);

	private boolean hasNoDelimiter = false;
	private boolean hasConstantDelimiter = false;

	public CucumberLexer() {
	}

	public CucumberLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public CucumberLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public boolean isKeyword(String s) throws MismatchedTokenException {
		int i = 0;
		while (i < s.length()) {
			input.LA(i + 1);
			if (input.LA(i + 1) != s.charAt(i)) {
				return false;
			}
			i++;
		}
		return true;
	}

	public void printNextToken() throws MismatchedTokenException {
		int i = 0;
		try {
			String s = "";
			while (!Character.isWhitespace(input.LA(i))) {
				s += Character.toString(input.LA(i));
				i++;
			}
			logger.debug("Token >>>" + s + "<<<");
		} catch (Exception e) {
			logger.debug("Error >>>" + input.LA(i) + "<<<");
		}
	}

	@Override
	public void mTokens() throws RecognitionException {
		// The general idea for this parser is
		// 1 identify initial keyword
		// 2 greedily handle tokens that follow till end of line

		// Some rules are multi line, like RAWTEXT or a multiline comment if it were
		// implemented.
		// They automatically handle the greedy collection of tokens

		// Other rules are single line, like +, = or Given
		// These are broken up into 5. Anything after the token
		// 1. is not a WORD like +, |===, * And or = Test-Suite
		// 2. is anything until a newline like with #
		// 3. is a WORD like Test-Suite. These are list elements which have no delimiter
		// keywords
		// 4. is a WORD or a constant delimiter like | or @. These are list elements
		// which
		// might have the same delimiter keyword.
		// 5. is a WORD or a variable delimiter like ( file | page). These are list
		// elements which might have one of a set of delimiter keywords.

		// whitespace
		if (isKeyword(" ") || isKeyword("\t") || isKeyword("\r")) {
			mRULE_WS();
			// multi line greedy automatic collection
		} else if (isKeyword("\"\"\"")) {
			mRULE_RAWTEXT();
			// delimiter reset
		} else if (isKeyword("\n")) {
			mRULE_EOL();
			hasNoDelimiter = false;
			hasConstantDelimiter = false;
			// handle greedy collection by delimiter
		} else if (hasNoDelimiter) {
			mRULE_WORD();
		} else if (hasConstantDelimiter) {
			if (isKeyword("|")) {
				mT__17();
			} else if (isKeyword("@")) {
				mT__24();
			} else {
				mRULE_WORD();
			}
			// single line automatic collection
		} else if (isKeyword("#")) {
			mRULE_SL_COMMENT();
			// single line no delimiter collection
		} else if (isKeyword("Object:")) {
			mT__9();
			hasNoDelimiter = true;
		} else if (isKeyword("Definition:")) {
			mT__10();
			hasNoDelimiter = true;
		} else if (isKeyword("Parameters:")) {
			mT__11();
			hasNoDelimiter = true;
		} else if (isKeyword("Feature:")) {
			mT__12();
			hasNoDelimiter = true;
		} else if (isKeyword("Background:")) {
			mT__13();
			hasNoDelimiter = true;
		} else if (isKeyword("Scenario Outline:")) {
			mT__15();
			hasNoDelimiter = true;
		} else if (isKeyword("Scenario:")) {
			mT__14();
			hasNoDelimiter = true;
		} else if (isKeyword("Examples:")) {
			mT__16();
			hasNoDelimiter = true;
		} else if (isKeyword("Given")) {
			mT__18();
			hasNoDelimiter = true;
		} else if (isKeyword("When")) {
			mT__19();
			hasNoDelimiter = true;
		} else if (isKeyword("Then")) {
			mT__20();
			hasNoDelimiter = true;
		} else if (isKeyword("And")) {
			mT__21();
			hasNoDelimiter = true;
		} else if (isKeyword("But")) {
			mT__22();
			hasNoDelimiter = true;
		} else if (isKeyword("*")) {
			mT__23();
			hasNoDelimiter = true;
			// single line constant delimiter collection
		} else if (isKeyword("|")) {
			mT__17();
			hasConstantDelimiter = true;
		} else if (isKeyword("@")) {
			mT__24();
			hasConstantDelimiter = true;
			// catch all
		} else {
			mRULE_WORD();
		}
	}
}
