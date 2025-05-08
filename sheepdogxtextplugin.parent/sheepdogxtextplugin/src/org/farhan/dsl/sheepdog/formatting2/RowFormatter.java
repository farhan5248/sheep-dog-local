package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.RowElements;
import org.farhan.dsl.sheepdog.sheepDog.Row;

public class RowFormatter extends Formatter {

	private Row theRow;

	public RowFormatter(Row Row) {
		this.theRow = Row;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		RowElements a = ga.getRowAccess();
		for (Cell c : theRow.getCellList()) {
			CellFormatter formatter = new CellFormatter(c);
			formatter.isLast(isLastElement(c, theRow.getCellList()));
			formatter.isFirst(isFirstElement(c, theRow.getCellList()));
			formatter.format(doc, ga, df);
		}
		formatEOL1RuleCall(df.getRegion(theRow, a.getEOLTerminalRuleCall_1()), doc);
	}

}
