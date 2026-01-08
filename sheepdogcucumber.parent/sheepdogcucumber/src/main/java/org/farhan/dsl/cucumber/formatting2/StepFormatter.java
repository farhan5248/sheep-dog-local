package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.cucumber.cucumber.Step;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;

public abstract class StepFormatter extends Formatter {

	protected Step theStep;

	public StepFormatter(Step theStep) {
		this.theStep = theStep;
	}

	protected abstract void formatKeyword(ISemanticRegion iSR, IFormattableDocument doc);

	protected abstract AbstractParserRuleElementFinder getAccess(CucumberGrammarAccess ga);

	protected abstract Keyword getKeyword(AbstractParserRuleElementFinder a);

	protected abstract RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a);

	protected abstract RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a);

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {

		AbstractParserRuleElementFinder a = getAccess(ga);
		formatKeyword(df.getRegion(theStep, getKeyword(a)), doc);
		formatTitleRuleCall(df.getRegion(theStep, getPhraseRuleCall(a)), doc);
		formatEOL12RuleCall(df.getRegion(theStep, getEOLRuleCall(a)), doc);
		if (theStep.getTheStepTable() != null) {
			StepTableFormatter formatter = new StepTableFormatter(theStep.getTheStepTable());
			formatter.setIndent(10);
			formatter.isEOLDouble(isLast);
			formatter.format(doc, ga, df);
		}
		if (theStep.getTheDocString() != null) {
			DocStringFormatter formatter2 = new DocStringFormatter(theStep.getTheDocString());
			formatter2.setIndent(10);
			formatter2.isEOLDouble(isLast);
			formatter2.format(doc, ga, df);
		}
	}

}
