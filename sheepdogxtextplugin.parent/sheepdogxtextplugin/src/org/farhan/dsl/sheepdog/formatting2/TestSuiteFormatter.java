package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.TestSuiteElements;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.Statement;

public class TestSuiteFormatter extends Formatter {

	private TestSuite theFeature;

	public TestSuiteFormatter(TestSuite theFeature) {
		this.theFeature = theFeature;
	}

	private TestStepContainerFormatter newAbstractTestCaseFormatter(TestStepContainer s) {
		if (s instanceof TestSetup) {
			return new TestSetupFormatter((TestSetup) s);
		} else {
			return new TestCaseFormatter((TestCase) s);
		}
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		TestSuiteElements a = ga.getTestSuiteAccess();

		formatKeywordTrailingSpace(df.getRegion(theFeature, a.getEqualsSignKeyword_0()), doc);
		formatKeywordTrailingSpace(df.getRegion(theFeature, a.getTestSuiteKeyword_1()), doc);
		formatTitle(df.getRegion(theFeature, a.getNameTitleParserRuleCall_2_0()), doc);
		formatEOL2RuleCall(df.getRegion(theFeature, a.getEOLTerminalRuleCall_3()), doc);
		for (Statement s : theFeature.getStatementList()) {
			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, theFeature.getStatementList()));
			formatter.format(doc, ga, df);
		}
		for (TestStepContainer s : theFeature.getTestStepContainerList()) {
			TestStepContainerFormatter formatter = newAbstractTestCaseFormatter(s);
			formatter.format(doc, ga, df);
		}
	}

}
