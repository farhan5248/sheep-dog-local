package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.farhan.dsl.cucumber.cucumber.DocString;
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

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		DocStringElements a = ga.getDocStringAccess();
		// For now I'm doing nothing, what this needs is
		// 1. figure out space in front of """
		// 2. make every line start with at least that many spaces
		indentCnt = 10;
		formatKeywordNoSpace(df.getRegion(theDocString, a.getNameRAWTEXTTerminalRuleCall_0_0()), doc);
		formatEOL12RuleCall(df.getRegion(theDocString, a.getEOLTerminalRuleCall_1()), doc);
	}

}
