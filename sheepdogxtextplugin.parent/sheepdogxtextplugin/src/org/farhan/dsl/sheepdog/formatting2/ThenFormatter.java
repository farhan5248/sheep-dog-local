package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.ThenElements;
import org.farhan.dsl.sheepdog.sheepDog.Then;

public class ThenFormatter extends TestStepFormatter {

	public ThenFormatter(Then theStep) {
		super(theStep);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga) {
		return ga.getThenAccess();
	}

	@Override
	protected Keyword getEqualsKeyword(AbstractParserRuleElementFinder a) {
		return ((ThenElements) a).getAsteriskKeyword_0();
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((ThenElements) a).getThenKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((ThenElements) a).getEOLTerminalRuleCall_3();
	}

	@Override
	protected RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a) {
		return ((ThenElements) a).getNameTitleParserRuleCall_2_0();
	}

}
