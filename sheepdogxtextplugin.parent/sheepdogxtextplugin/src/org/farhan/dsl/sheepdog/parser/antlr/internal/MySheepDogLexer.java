package org.farhan.dsl.sheepdog.parser.antlr.internal;

import org.eclipse.xtext.parser.antlr.Lexer;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class MySheepDogLexer extends InternalSheepDogLexer {

	// TODO maybe these should all be one flag called escapeKeyword?
	private boolean nextTokenIsWORD = true;
	private boolean nextTokenIsTestStep = false;

	public MySheepDogLexer() {
	}

	public MySheepDogLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public MySheepDogLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public boolean isMatch(String s) throws MismatchedTokenException {
		int i = 0;
		while (i < s.length()) {
			input.LA(i + 1);
			if (input.LA(i + 1) != s.charAt(i)) {
				return false;
			}
			i++;
		}
		//System.out.println("isMatch >>>" + s + "<<<");
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
			System.out.println("Token >>>" + s + "<<<");
		} catch (Exception e) {
			System.out.println("Error >>>" + input.LA(i) + "<<<");
		}

	}

	@Override
	public void mTokens() throws RecognitionException {
		// TODO document how to update the lexer in markdown
		// get the position from input and find the next set of non-space characters
		// This is a hack, ideally the xtext grammar file needs to be defined better,
		// when I have more time I'll review the need to do this but for now I figured
		// it'd be a good example on how to hack the lexer for newbies
		//printNextToken();
		if (isMatch("----")) {
			mRULE_RAWTEXT();// ( '----' RULE_EOL ( . )+ '----' RULE_EOL )
		} else if (isMatch("#")) {
			mRULE_SL_COMMENT();
		} else if (isMatch(" ") || isMatch("\t") || isMatch("\r")) {
			mRULE_WS();
		} else if (isMatch("+")) {
			mT__23();
		} else if (isMatch("|===")) {
			mT__24();
		} else if (isMatch("*")) {
			mT__13();
		} else if (isMatch("==")) {
			mT__11();
		} else if (isMatch("=")) {
			mT__9();
		} else if (isMatch("|")) {
			mT__25();
		} else if (isMatch("Step-Object:")) {
			mT__10();// 'Object:'
		} else if (isMatch("Step-Definition:")) {
			mT__12();// 'Definition:'
		} else if (isMatch("Step-Parameters:")) {
			mT__14();// 'Parameters:'
		} else if (isMatch("Test-Suite:")) {
			mT__15();// 'Feature:'
		} else if (isMatch("Test-Setup:")) {
			mT__16();// 'Background:'
		} else if (isMatch("Test-Case:")) {
			mT__17();// 'Scenario:'
		} else if (isMatch("Test-Data:")) {
			mT__18();// 'Examples:'
		} else if (isMatch(",")) {
			mT__21();// ','
		} else if (isMatch("\n")) {
			mRULE_EOL();
			nextTokenIsTestStep = false;
		} else if (isMatch("Given:")) {
			mT__19();// 'Given'
			nextTokenIsTestStep = true;
		} else if (isMatch("When:")) {
			mT__20();// 'When'
			nextTokenIsTestStep = true;
		} else if (isMatch("Then:")) {
			mT__21();// 'Then'
			nextTokenIsTestStep = true;
		} else if (isMatch("And:")) {
			mT__22();// 'And'
			nextTokenIsTestStep = true;
		} else if (nextTokenIsTestStep) {
			// TODO perhaps I don't need to override the whole lexer, just stuff like raw text?
			super.mTokens();
		} else {
			mRULE_WORD();
		}
	}
}