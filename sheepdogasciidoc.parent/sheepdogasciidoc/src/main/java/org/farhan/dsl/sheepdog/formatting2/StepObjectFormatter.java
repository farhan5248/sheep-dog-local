package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.StepObjectElements;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.Line;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;

public class StepObjectFormatter extends Formatter {

	private StepObject theStepObject;

	public StepObjectFormatter(StepObject theStepObject) {
		this.theStepObject = theStepObject;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		StepObjectElements a = ga.getStepObjectAccess();

		formatKeywordTrailingSpace(df.getRegion(theStepObject, a.getEqualsSignKeyword_0()), doc);
		formatKeywordTrailingSpace(df.getRegion(theStepObject, a.getStepObjectKeyword_1()), doc);
		formatTitle(df.getRegion(theStepObject, a.getNamePhraseParserRuleCall_2_0()), doc);
		formatEOL2RuleCall(df.getRegion(theStepObject, a.getEOLTerminalRuleCall_3()), doc);
		if (theStepObject.getDescription() != null) {
			for (Line s : theStepObject.getDescription().getLineList()) {
				StatementFormatter formatter = new StatementFormatter(s);
				formatter.isLast(isLastElement(s, theStepObject.getDescription().getLineList()));
				formatter.format(doc, ga, df);
			}
		}
		for (StepDefinition s : theStepObject.getStepDefinitionList()) {
			StepDefinitionFormatter formatter = new StepDefinitionFormatter(s);
			formatter.format(doc, ga, df);
		}
	}

}
