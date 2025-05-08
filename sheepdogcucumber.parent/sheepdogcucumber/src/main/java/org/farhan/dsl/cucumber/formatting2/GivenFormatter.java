package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.cucumber.cucumber.Given;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.GivenElements;

public class GivenFormatter extends StepFormatter {

	public GivenFormatter(Given theGiven) {
		super(theGiven);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(CucumberGrammarAccess ga) {
		return ga.getGivenAccess();
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getGivenKeyword_0();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getEOLTerminalRuleCall_2();
	}

	@Override
	protected RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getNamePhraseParserRuleCall_1_0();
	}

	@Override
	protected void formatKeyword(ISemanticRegion iSR, IFormattableDocument doc) {
		doc.prepend(iSR, it -> it.noSpace());
		doc.append(iSR, it -> it.noSpace());
		replace(doc, iSR, getIndent() + iSR.getText() + " ");
	}

}