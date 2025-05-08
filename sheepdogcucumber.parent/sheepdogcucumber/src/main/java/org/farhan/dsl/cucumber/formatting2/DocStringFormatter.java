package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.farhan.dsl.cucumber.cucumber.DocString;
import org.farhan.dsl.cucumber.cucumber.Line;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.DocStringElements;

public class DocStringFormatter extends Formatter {

	private DocString theDocString;

	public DocStringFormatter(DocString theDocString) {
		this.theDocString = theDocString;
	}

	public void isEOLDouble(boolean isEOLDouble) {
		this.isLastEOLDouble = isEOLDouble;
	}

	protected void formatKeyword(ISemanticRegion iSR, IFormattableDocument doc) {
		doc.prepend(iSR, it -> it.noSpace());
		doc.append(iSR, it -> it.noSpace());
		replace(doc, iSR, getIndent() + iSR.getText());
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		DocStringElements a = ga.getDocStringAccess();
		formatKeyword(df.getRegion(theDocString, a.getQuotationMarkQuotationMarkQuotationMarkKeyword_0()), doc);
		formatEOL1RuleCall(df.getRegion(theDocString, a.getEOLTerminalRuleCall_1()), doc);
		formatKeyword(df.getRegion(theDocString, a.getQuotationMarkQuotationMarkQuotationMarkKeyword_3()), doc);
		formatEOL12RuleCall(df.getRegion(theDocString, a.getEOLTerminalRuleCall_4()), doc);
		for (Line s : theDocString.getLines()) {
			LineFormatter formatter = new LineFormatter(s);
			formatter.isLast(isLastElement(s, theDocString.getLines()));
			formatter.setIndent(10);
			formatter.isLastEOLDouble(false);
			formatter.format(doc, ga, df);
		}
	}

}
