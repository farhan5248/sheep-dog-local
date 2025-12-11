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

	public MySheepDogLexer() {
	}

	public MySheepDogLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public MySheepDogLexer(CharStream input, RecognizerSharedState state) {
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
		//System.out.println("Keyword >>>" + s + "<<<");
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
		if (isKeyword("----")) {
			mRULE_RAWTEXT();// ( '----' RULE_EOL ( . )+ '----' RULE_EOL )
		} else if (isKeyword("#")) {
			mRULE_SL_COMMENT();
		} else if (isKeyword(" ") || isKeyword("\t") || isKeyword("\r")) {
			mRULE_WS();
		} else if (isKeyword("+")) {
			mT__25();
		} else if (isKeyword("|===")) {
			mT__26();
		} else if (isKeyword("*")) {
			mT__14();
		} else if (isKeyword("==")) {
			mT__12();
		} else if (isKeyword("=")) {
			mT__10();
		} else if (isKeyword("Step-Object:")) {
			mT__11();// 'Object:'
		} else if (isKeyword("Step-Definition:")) {
			mT__13();// 'Definition:'
		} else if (isKeyword("Step-Parameters:")) {
			mT__15();// 'Parameters:'
		} else if (isKeyword("Test-Suite:")) {
			mT__16();// 'Feature:'
		} else if (isKeyword("Test-Setup:")) {
			mT__17();// 'Background:'
		} else if (isKeyword("Test-Case:")) {
			mT__18();// 'Scenario:'
		} else if (isKeyword("Test-Data:")) {
			mT__19();// 'Examples:'
		} else if (isKeyword(",")) {
			mT__21();// ','
		} else if (isKeyword("\n")) {
			mRULE_EOL();
			nextTokenIsWORD = true;
		} else if (isKeyword("Given:")) {
			mT__20();// 'Given'
			nextTokenIsWORD = false;
		} else if (isKeyword("When:")) {
			mT__22();// 'When'
			nextTokenIsWORD = false;
		} else if (isKeyword("Then:")) {
			mT__23();// 'Then'
			nextTokenIsWORD = false;
		} else if (isKeyword("And:")) {
			mT__24();// 'And'
			nextTokenIsWORD = false;
		} else if (isKeyword("|")) {
			mT__27();
			// TODO not sure I need this assignment
			nextTokenIsWORD = true;
		} else if (!nextTokenIsWORD) {
			mRULE_ID();
		} else {
			mRULE_WORD();
		}
	}
}