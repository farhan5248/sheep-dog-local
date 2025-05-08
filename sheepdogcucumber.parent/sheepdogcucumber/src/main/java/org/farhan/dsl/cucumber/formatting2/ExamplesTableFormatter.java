package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.cucumber.cucumber.ExamplesTable;
import org.farhan.dsl.cucumber.cucumber.Row;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;

public class ExamplesTableFormatter extends Formatter {

	private ExamplesTable theExamplesTable;

	public ExamplesTableFormatter(ExamplesTable theExamplesTable) {
		this.theExamplesTable = theExamplesTable;
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {

		if (theExamplesTable != null) {
			for (Row r : theExamplesTable.getRows()) {
				RowFormatter formatter = new RowFormatter(r);
				formatter.isLast(isLastElement(r, theExamplesTable.getRows()));
				formatter.isFirst(isFirstElement(r, theExamplesTable.getRows()));
				formatter.isLastEOLDouble(true);
				formatter.setIndent(6);
				formatter.format(doc, ga, df);
			}
		}
	}

}
