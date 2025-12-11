package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.NestedStatementListElements;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.NestedStatementList;

public class NestedStatementListFormatter extends Formatter {

	private NestedStatementList theStatementList;

	public NestedStatementListFormatter(NestedStatementList theStatementList) {
		this.theStatementList = theStatementList;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		NestedStatementListElements a = ga.getNestedStatementListAccess();
		formatKeywordNoSpace(df.getRegion(theStatementList, a.getPlusSignKeyword_0()), doc);
		formatEOL1RuleCall(df.getRegion(theStatementList, a.getEOLTerminalRuleCall_1()), doc);

		for (Statement s : theStatementList.getStatementList()) {
			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, theStatementList.getStatementList()));
			formatter.format(doc, ga, df);
		}
	}
}
