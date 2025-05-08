package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.farhan.dsl.cucumber.cucumber.Line;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.LineElements;

public class LineFormatter extends Formatter {

	private Line theLine;

	public LineFormatter(Line theLine) {
		this.theLine = theLine;
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		LineElements a = ga.getLineAccess();
		ISemanticRegion iSR = df.getRegion(theLine, a.getNameLineBitsParserRuleCall_0_0());
		if (iSR != null) {
			if (!iSR.getText().isEmpty()) {
				formatLineBitsRuleCall(df.getRegion(theLine, a.getNameLineBitsParserRuleCall_0_0()), doc);
			} else {
				formatEOL1RuleCall(df.getRegion(theLine, a.getEOLTerminalRuleCall_1()), doc);
			}
		} else {
			formatEOL1RuleCall(df.getRegion(theLine, a.getEOLTerminalRuleCall_1()), doc);
		}
	}

	protected void formatEOL1RuleCall(ISemanticRegion iSR, IFormattableDocument doc) {
		//System.out.println("h>" + iSR.getPreviousHiddenRegion().getText() + "<");
		//System.out.println("t>\\n<");
		doc.prepend(iSR, it -> it.noSpace());
		if (iSR.getPreviousHiddenRegion().getText().isEmpty()) {
			replace(doc, iSR, indent.repeat(indentCnt) + iSR.getText());
		} else {
			replace(doc, iSR, iSR.getPreviousHiddenRegion().getText() + iSR.getText());
		}
	}

	public void formatLineBitsRuleCall(ISemanticRegion iSR, IFormattableDocument doc) {

		//System.out.println("h>" + iSR.getPreviousHiddenRegion().getText() + "<");
		//System.out.println("t>" + iSR.getText() + "<");
		doc.prepend(iSR, it -> it.noSpace());
		doc.append(iSR, it -> it.noSpace());
		if (iSR.getPreviousHiddenRegion().getText().isEmpty()) {

			// if there's no hidden text, there's two possibilities
			if (iSR.getText().startsWith(indent)) {
				// 1 it's part of the text so do nothing
			} else {
				// 2 it's never set when creating a file programmatically.
				// The maven plugin adds leading spaces and I can't think of a way that this
				// situation occurs when using the GUI
				replace(doc, iSR, indent.repeat(indentCnt) + iSR.getText());
			}
		} else {
			// if leading whitespace is considered part of the hidden region, append it to
			// the text after zero'ing it out
			replace(doc, iSR, iSR.getPreviousHiddenRegion().getText() + iSR.getText());
		}
	}
}
