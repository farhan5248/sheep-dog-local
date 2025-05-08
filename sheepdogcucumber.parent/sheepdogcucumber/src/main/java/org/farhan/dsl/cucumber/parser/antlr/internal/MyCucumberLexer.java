package org.farhan.dsl.cucumber.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
import org.farhan.dsl.cucumber.parser.antlr.internal.InternalCucumberLexer;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MyCucumberLexer extends InternalCucumberLexer {

	private boolean isDocString = false;
	private int docStringIndent = 0;
	private boolean lastTokenIsEOL = true;
	private boolean isTagLine = false;

	public MyCucumberLexer() {
	}

	public MyCucumberLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public MyCucumberLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public Token nextToken() {
		Token t = super.nextToken();
		String tokenText = t.getText();
		if (tokenText == null) {
			return t;
		}
		docStringHandler(t);
		if (isKeyword(t.getType())) {
			keywordHandler(t);
		} else if (t.getType() == 0) {
			keywordErrorHandler(t);
		} else {
			textHandler(t);
		}
		return t;
	}

	private void textHandler(Token t) {
		if (t.getType() == RULE_EOL) {
			lastTokenIsEOL = true;
			// we're leaving the tag line
			isTagLine = false;
		} else {
			if (t.getType() == RULE_WS) {
				// if it's all whitespace (and not Scenario O) ignore the whitespace
			} else {
				lastTokenIsEOL = false;
			}
		}
	}

	private void keywordErrorHandler(Token t) {
		// if it begins with "Scenario " but isn't Scenario Outline: then change
		// it's type to RULE_STRING
		if (t.getText().startsWith("Scenario ") && !t.getText().contentEquals("Scenario Outline:")) {
			t.setType(RULE_STRING);
		}
		lastTokenIsEOL = false;
	}

	private void keywordHandler(Token t) {
		// This handles keywords not in a docstring
		// If it's a identified as a keyword but doesn't have a new line on its left,
		// then it should be a string
		if (t.getType() == 21) {
			// the | can occur multiple times on one line. It's not always
			// preceded by new lines. This is escaped with \
		} else {
			if (lastTokenIsEOL) {
				// this is an actual keyword
				if (t.getType() == 29) {
					// if it's an @
					isTagLine = true;
				}
			} else {
				if (t.getType() == 29 && isTagLine) {
					// if it's an @ and we're on a tag line, then treat it as a tag
				} else {
					t.setType(RULE_STRING);
				}
			}
		}
		lastTokenIsEOL = false;
	}

	private void docStringHandler(Token t) {
		if (!isDocString && t.getText().contentEquals("\"\"\"")) {
			isDocString = true;
		} else if (!isDocString && !t.getText().contentEquals("\"\"\"")) {
			// The last token before the docstring should be the whitespace so we'll use
			// that as the default white space for the entire docstring
			docStringIndent = t.getText().length();
			// System.out.println("Setting the indent to: " + docStringIndent);
		} else if (isDocString && t.getText().contentEquals("\"\"\"")) {
			isDocString = false;
		} else if (isDocString && !t.getText().contentEquals("\"\"\"")) {
			if (t.getType() != RULE_EOL && !isLeadingWhiteSpace(t)) {
				// System.out.println("Converting Token >>>" + t.getText() + "<<< " +
				// t.getType());
				// The length check is there so that the whitespace before the closing """ isn't
				// ignored. When it's ignored, it looks like there's a line bit without an EOL
				// before the closing """ which is a syntax error
				t.setType(RULE_STRING);
			} else {
				// System.out.println("Ignoring Token >>>" + t.getText() + "<<< " +
				// t.getType());
			}
		}
	}

	private boolean isLeadingWhiteSpace(Token t) {
		if (t.getType() != RULE_WS) {
			return false;
		} else if (!lastTokenIsEOL) {
			return false;
		} else if (t.getText().length() > docStringIndent) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isKeyword(int type) {
		if (type == T__13) {
			// Object:
			return true;
		} else if (type == T__14) {
			// Definition
			return true;
		} else if (type == T__15) {
			// Parameters:
			return true;
		} else if (type == T__16) {
			// Feature:
			return true;
		} else if (type == T__17) {
			// Background:
			return true;
		} else if (type == T__18) {
			// Scenario:
			return true;
		} else if (type == T__19) {
			// Scenario Outline:
			return true;
		} else if (type == T__20) {
			// Examples:
			return true;
		} else if (type == T__21) {
			// |
			return true;
		} else if (type == T__22) {
			// \"\"\"
			return true;
		} else if (type == T__23) {
			// Given
			return true;
		} else if (type == T__24) {
			// When
			return true;
		} else if (type == T__25) {
			// Then
			return true;
		} else if (type == T__26) {
			// And
			return true;
		} else if (type == T__27) {
			// But
			return true;
		} else if (type == T__28) {
			// *
			return true;
		} else if (type == T__29) {
			// @
			return true;
		} else {
			return false;
		}
	}
}