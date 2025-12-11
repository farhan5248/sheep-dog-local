package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.GivenElements;
import org.farhan.dsl.sheepdog.sheepDog.Given;

public class GivenFormatter extends TestStepFormatter {

	public GivenFormatter(Given theStep) {
		super(theStep);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga) {
		return ga.getGivenAccess();
	}

	@Override
	protected Keyword getEqualsKeyword(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getAsteriskKeyword_0();
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getGivenKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getEOLTerminalRuleCall_4();
	}

	@Override
	protected RuleCall getObjectStepObjectRefParserRuleCall(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getObjectStepObjectRefParserRuleCall_2_0();
	}

	@Override
	protected RuleCall getPredicateStepDefinitionRefParserRuleCall(AbstractParserRuleElementFinder a) {
		return ((GivenElements) a).getPredicateStepDefinitionRefParserRuleCall_3_0();
	}

}
