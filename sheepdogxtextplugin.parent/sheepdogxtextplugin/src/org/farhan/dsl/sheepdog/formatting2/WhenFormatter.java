package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.WhenElements;
import org.farhan.dsl.sheepdog.sheepDog.When;

public class WhenFormatter extends TestStepFormatter {

	public WhenFormatter(When theStep) {
		super(theStep);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga) {
		return ga.getWhenAccess();
	}

	@Override
	protected Keyword getEqualsKeyword(AbstractParserRuleElementFinder a) {
		return ((WhenElements) a).getAsteriskKeyword_0();
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((WhenElements) a).getWhenKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((WhenElements) a).getEOLTerminalRuleCall_4();
	}

	@Override
	protected RuleCall getObjectStepObjectRefParserRuleCall(AbstractParserRuleElementFinder a) {
		return ((WhenElements) a).getObjectStepObjectRefParserRuleCall_2_0();
	}

	@Override
	protected RuleCall getPredicateStepDefinitionRefParserRuleCall(AbstractParserRuleElementFinder a) {
		return ((WhenElements) a).getPredicateStepDefinitionRefParserRuleCall_3_0();
	}

}
