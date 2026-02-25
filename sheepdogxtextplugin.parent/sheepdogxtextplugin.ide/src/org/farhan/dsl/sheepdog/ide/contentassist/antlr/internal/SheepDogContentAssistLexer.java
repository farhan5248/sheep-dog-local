package org.farhan.dsl.sheepdog.ide.contentassist.antlr.internal;

import org.antlr.runtime.*;

@SuppressWarnings("all")
public class SheepDogContentAssistLexer extends InternalSheepDogLexer {

	// Used to escape keywords
	private boolean hasNoDelimiter = false;
	private boolean hasConstantDelimiter = false;
	private boolean hasVariableDelimiter = false;

	public SheepDogContentAssistLexer() {
	}

	public SheepDogContentAssistLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public SheepDogContentAssistLexer(CharStream input, RecognizerSharedState state) {
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

	// Content Assist token mapping (different from runtime):
	// T__18 = '='           T__19 = 'Step-Object:'     T__20 = '=='
	// T__21 = 'Step-Definition:'  T__22 = '*'          T__23 = 'Step-Parameters:'
	// T__24 = 'Test-Suite:'       T__25 = 'Test-Setup:'  T__26 = 'Test-Case:'
	// T__27 = 'Test-Data:'        T__28 = '+'            T__29 = 'Given:'
	// T__30 = 'When:'             T__31 = 'Then:'        T__32 = 'And:'
	// T__33 = '|==='             T__34 = '|'

	@Override
	public void mTokens() throws RecognitionException {
		// whitespace
		if (isKeyword(" ") || isKeyword("\t") || isKeyword("\r")) {
			mRULE_WS();
			// multi line greedy automatic collection
		} else if (isKeyword("----")) {
			mRULE_TEXT_BLOCK();
			// delimiter reset
		} else if (isKeyword("\n")) {
			mRULE_EOL();
			hasNoDelimiter = false;
			hasConstantDelimiter = false;
			hasVariableDelimiter = false;
			// handle greedy collection by delimiter
		} else if (hasNoDelimiter) {
			mRULE_WORD();
		} else if (hasConstantDelimiter) {
			if (isKeyword("|")) {
				mT__34(); // '|'
			} else {
				mRULE_WORD();
			}
		} else if (hasVariableDelimiter) {
			super.mTokens();
			// single line no collection
		} else if (isKeyword("+")) {
			mT__28(); // '+'
		} else if (isKeyword("|===")) {
			mT__33(); // '|==='
		} else if (isKeyword("*")) {
			mT__22(); // '*'
		} else if (isKeyword("==")) {
			mT__20(); // '=='
		} else if (isKeyword("=")) {
			mT__18(); // '='
			// single line automatic collection
		} else if (isKeyword("#")) {
			mRULE_SL_COMMENT();
			// single line no delimiter collection
		} else if (isKeyword("Step-Object:")) {
			mT__19(); // 'Step-Object:'
			hasNoDelimiter = true;
		} else if (isKeyword("Step-Definition:")) {
			mT__21(); // 'Step-Definition:'
			hasNoDelimiter = true;
		} else if (isKeyword("Step-Parameters:")) {
			mT__23(); // 'Step-Parameters:'
			hasNoDelimiter = true;
		} else if (isKeyword("Test-Suite:")) {
			mT__24(); // 'Test-Suite:'
			hasNoDelimiter = true;
		} else if (isKeyword("Test-Setup:")) {
			mT__25(); // 'Test-Setup:'
			hasNoDelimiter = true;
		} else if (isKeyword("Test-Case:")) {
			mT__26(); // 'Test-Case:'
			hasNoDelimiter = true;
		} else if (isKeyword("Test-Data:")) {
			mT__27(); // 'Test-Data:'
			hasNoDelimiter = true;
			// single line constant delimiter collection
		} else if (isKeyword("|")) {
			mT__34(); // '|'
			hasConstantDelimiter = true;
			// single line variable delimiter collection
		} else if (isKeyword("Given:")) {
			mT__29(); // 'Given:'
			hasVariableDelimiter = true;
		} else if (isKeyword("When:")) {
			mT__30(); // 'When:'
			hasVariableDelimiter = true;
		} else if (isKeyword("Then:")) {
			mT__31(); // 'Then:'
			hasVariableDelimiter = true;
		} else if (isKeyword("And:")) {
			mT__32(); // 'And:'
			hasVariableDelimiter = true;
		// catch all
		} else {
			mRULE_WORD();
		}
	}
}
