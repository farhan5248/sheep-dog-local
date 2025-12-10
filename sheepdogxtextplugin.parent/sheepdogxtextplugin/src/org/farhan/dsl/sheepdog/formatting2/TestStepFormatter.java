package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;

public abstract class TestStepFormatter extends Formatter {

	protected TestStep theStep;

	public TestStepFormatter(TestStep theStep) {
		this.theStep = theStep;
	}

	protected abstract AbstractParserRuleElementFinder getAccess(SheepDogGrammarAccess ga);

	protected abstract Keyword getEqualsKeyword(AbstractParserRuleElementFinder a);

	protected abstract Keyword getKeyword(AbstractParserRuleElementFinder a);

	protected abstract RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a);

	protected abstract RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a);

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		AbstractParserRuleElementFinder a = getAccess(ga);
		formatKeywordTrailingSpace(df.getRegion(theStep, getEqualsKeyword(a)), doc);
		formatKeywordTrailingSpace(df.getRegion(theStep, getKeyword(a)), doc);
		// TODO change to StepReferenceFormatter.format
		formatTitle(df.getRegion(theStep, getPhraseRuleCall(a)), doc);
		if (theStep.getTable() != null || theStep.getText() != null) {
			formatEOL1RuleCall(df.getRegion(theStep, getEOLRuleCall(a)), doc);
		} else {
			formatEOL2RuleCall(df.getRegion(theStep, getEOLRuleCall(a)), doc);
		}
		if (theStep.getTable() != null) {
			TableFormatter formatter = new TableFormatter(theStep.getTable());
			formatter.format(doc, ga, df);
		}
		if (theStep.getText() != null) {
			TextFormatter formatter2 = new TextFormatter(theStep.getText());
			formatter2.format(doc, ga, df);
		}
	}

}
