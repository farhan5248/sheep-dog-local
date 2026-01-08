package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.farhan.dsl.cucumber.cucumber.Statement;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.StatementElements;

public class StatementFormatter extends Formatter {

	private boolean isMinIndentCnt = false;

	private Statement theStatement;

	public StatementFormatter(Statement theStatement) {
		this.theStatement = theStatement;
	}

	public void setIndent(int indentCnt, boolean isMinIndentCnt) {
		this.isMinIndentCnt = isMinIndentCnt;
		setIndent(indentCnt);
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		StatementElements a = ga.getStatementAccess();
		formatTitleRuleCall(df.getRegion(theStatement, a.getNameTitleParserRuleCall_0_0()), doc);
		formatEOL12RuleCall(df.getRegion(theStatement, a.getEOLTerminalRuleCall_1()), doc);
	}

	public void formatTitleRuleCall(ISemanticRegion iSR, IFormattableDocument doc) {

		int hiddenLength = iSR.getPreviousHiddenRegion().getText().length();
		doc.prepend(iSR, it -> it.noSpace());
		doc.append(iSR, it -> it.noSpace());
		if (isMinIndentCnt && hiddenLength > getIndent().length()) {
			replace(doc, iSR, indent.repeat(hiddenLength) + iSR.getText());
		} else {
			replace(doc, iSR, getIndent() + iSR.getText());
		}
	}

}
