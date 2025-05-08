package org.farhan.dsl.sheepdog.ui.syntaxcoloring;

import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

public class SheepDogAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(final String tokenName, final int tokenType) {
		if (tokenName == null) {
			return SheepDogHighlightingConfiguration.DEFAULT_ID;
		}
		switch (tokenName) {
		case "RULE_EOL":
			// nothing to do here
		case "RULE_WS":
			// nothing to do here
		case "RULE_WORD":
			return SheepDogHighlightingConfiguration.WORD_ID;
		case "RULE_SL_COMMENT":
			return SheepDogHighlightingConfiguration.COMMENT_ID;
		case "RULE_RAWTEXT":
			return SheepDogHighlightingConfiguration.DOC_ID;
		case "'='":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_1;
		case "'=='":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_2;
		case "'==='":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'Step-Object:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_1;
		case "'Step-Definition:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_2;
		case "'Step-Parameters:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'Test-Suite:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_1;
		case "'Test-Setup:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_2;
		case "'Test-Case:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_2;
		case "'Test-Data:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'Given:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'When:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'Then:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'And:'":
			return SheepDogHighlightingConfiguration.KEYWORD_LVL_3;
		case "'|==='":
			return SheepDogHighlightingConfiguration.TBL_ID;
		case "'|'":
			return SheepDogHighlightingConfiguration.TBL_ID;
		case "'[tags='":
			return SheepDogHighlightingConfiguration.TAG_ID;
		case "']'":
			return SheepDogHighlightingConfiguration.TAG_ID;
		default:
			return SheepDogHighlightingConfiguration.DEFAULT_ID;
		}
	}
}
