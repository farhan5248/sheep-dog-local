package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.sheepDog.Description;
import org.farhan.dsl.sheepdog.sheepDog.Line;

public class NestedStatementListFormatter extends Formatter {

	private Description theStatementList;

	public NestedStatementListFormatter(Description theStatementList) {
		this.theStatementList = theStatementList;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		for (Line s : theStatementList.getLineList()) {
			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, theStatementList.getLineList()));
			formatter.format(doc, ga, df);
		}
	}
}
