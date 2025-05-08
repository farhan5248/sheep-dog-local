package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.cucumber.cucumber.Statement;
import org.farhan.dsl.cucumber.cucumber.StepDefinition;
import org.farhan.dsl.cucumber.cucumber.StepParameters;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.StepDefinitionElements;

public class StepDefinitionFormatter extends Formatter {

	private StepDefinition stepDefinition;

	public StepDefinitionFormatter(StepDefinition stepDefinition) {
		this.stepDefinition = stepDefinition;
	}

	private void formatParameters(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		for (StepParameters e : stepDefinition.getStepParameters()) {
			StepParametersFormatter formatter = new StepParametersFormatter(e);
			formatter.setIndent(4);
			formatter.format(doc, ga, df);
		}
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		StepDefinitionElements a = ga.getStepDefinitionAccess();
		formatKeyword(df.getRegion(stepDefinition, a.getDefinitionKeyword_0()), doc);
		formatPhraseRuleCall(df.getRegion(stepDefinition, a.getNamePhraseParserRuleCall_1_0()), doc);
		formatEOL2RuleCall(df.getRegion(stepDefinition, a.getEOLTerminalRuleCall_2()), doc);
		for (Statement s : stepDefinition.getStatements()) {
			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, stepDefinition.getStatements()));
			formatter.setIndent(4);
			formatter.isLastEOLDouble(true);
			formatter.format(doc, ga, df);
		}
		formatParameters(doc, ga, df);
	}

}
