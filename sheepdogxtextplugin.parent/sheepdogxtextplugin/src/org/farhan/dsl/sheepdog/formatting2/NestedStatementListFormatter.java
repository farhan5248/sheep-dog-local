package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.NestedDescriptionElements;
import org.farhan.dsl.sheepdog.sheepDog.Line;
import org.farhan.dsl.sheepdog.sheepDog.NestedDescription;

public class NestedStatementListFormatter extends Formatter {

	private NestedDescription theStatementList;

	public NestedStatementListFormatter(NestedDescription theStatementList) {
		this.theStatementList = theStatementList;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		NestedDescriptionElements a = ga.getNestedDescriptionAccess();
		formatKeywordNoSpace(df.getRegion(theStatementList, a.getPlusSignKeyword_0()), doc);
		formatEOL1RuleCall(df.getRegion(theStatementList, a.getEOLTerminalRuleCall_1()), doc);

		for (Line s : theStatementList.getLineList()) {
			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, theStatementList.getLineList()));
			formatter.format(doc, ga, df);
		}
	}
}
