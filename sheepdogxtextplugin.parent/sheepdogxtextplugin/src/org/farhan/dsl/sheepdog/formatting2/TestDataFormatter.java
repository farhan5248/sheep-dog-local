package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.TestDataElements;
import org.farhan.dsl.sheepdog.sheepDog.TestData;

public class TestDataFormatter extends Formatter {

	private TestData theTestData;

	public TestDataFormatter(TestData theTestData) {
		this.theTestData = theTestData;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		TestDataElements a = ga.getTestDataAccess();
		formatKeywordTrailingSpace(df.getRegion(theTestData, a.getAsteriskKeyword_0()), doc);
		formatKeywordTrailingSpace(df.getRegion(theTestData, a.getTestDataKeyword_1()), doc);
		formatTitle(df.getRegion(theTestData, a.getNamePhraseParserRuleCall_2_0()), doc);

		if (theTestData.getTable() != null || theTestData.getNestedDescription() != null) {
			formatEOL1RuleCall(df.getRegion(theTestData, a.getEOLTerminalRuleCall_3()), doc);
		} else {
			formatEOL2RuleCall(df.getRegion(theTestData, a.getEOLTerminalRuleCall_3()), doc);
		}

		if (theTestData.getNestedDescription() != null) {
			NestedStatementListFormatter formatter = new NestedStatementListFormatter(theTestData.getNestedDescription());
			formatter.format(doc, ga, df);
		}

		if (theTestData.getTable() != null) {
			TableFormatter formatter = new TableFormatter(theTestData.getTable());
			formatter.format(doc, ga, df);
		}
	}

}
