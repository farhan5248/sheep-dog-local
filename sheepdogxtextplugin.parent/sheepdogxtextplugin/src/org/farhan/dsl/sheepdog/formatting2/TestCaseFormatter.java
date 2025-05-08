package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.TestCaseElements;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;

public class TestCaseFormatter extends TestStepContainerFormatter {

	public TestCaseFormatter(TestCase theTestCase) {
		super(theTestCase);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga) {
		return ga.getTestCaseAccess();
	}

	@Override
	protected void formatExamples(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		for (TestData e : ((TestCase) theAbstractScenario).getTestDataList()) {
			TestDataFormatter formatter = new TestDataFormatter(e);
			formatter.format(doc, ga, df);
		}
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((TestCaseElements) a).getTestCaseKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((TestCaseElements) a).getEOLTerminalRuleCall_3();
	}

	@Override
	protected RuleCall getTitleRuleCall(AbstractParserRuleElementFinder a) {
		return ((TestCaseElements) a).getNameTitleParserRuleCall_2_0();
	}

	@Override
	protected Keyword getEqualsKeyword(AbstractParserRuleElementFinder a) {
		return ((TestCaseElements) a).getEqualsSignEqualsSignKeyword_0();
	}

}
