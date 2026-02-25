package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.TextElements;
import org.farhan.dsl.sheepdog.sheepDog.Text;

public class TextFormatter extends Formatter {

	private Text theDocString;

	public TextFormatter(Text theDocString) {
		this.theDocString = theDocString;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		TextElements a = ga.getTextAccess();
		formatKeywordNoSpace(df.getRegion(theDocString, a.getPlusSignKeyword_0()), doc);
		formatEOL1RuleCall(df.getRegion(theDocString, a.getEOLTerminalRuleCall_1()), doc);
		formatTitleNoSpace(df.getRegion(theDocString, a.getContentTEXT_BLOCKTerminalRuleCall_2_0()), doc);
		formatEOL2RuleCall(df.getRegion(theDocString, a.getEOLTerminalRuleCall_3()), doc);
	}

}
