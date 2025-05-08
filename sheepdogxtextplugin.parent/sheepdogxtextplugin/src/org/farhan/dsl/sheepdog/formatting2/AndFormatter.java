package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.AndElements;
import org.farhan.dsl.sheepdog.sheepDog.And;

public class AndFormatter extends TestStepFormatter {

	public AndFormatter(And theStep) {
		super(theStep);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga) {
		return ga.getAndAccess();
	}

	@Override
	protected Keyword getEqualsKeyword(AbstractParserRuleElementFinder a) {
		return ((AndElements) a).getAsteriskKeyword_0();
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((AndElements) a).getAndKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((AndElements) a).getEOLTerminalRuleCall_3();
	}

	@Override
	protected RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a) {
		return ((AndElements) a).getNameTitleParserRuleCall_2_0();
	}

}
