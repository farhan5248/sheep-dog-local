package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.cucumber.cucumber.Statement;
import org.farhan.dsl.cucumber.cucumber.StepParameters;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.StepParametersElements;

public class StepParametersFormatter extends Formatter {

	private StepParameters stepParameters;

	public StepParametersFormatter(StepParameters stepParameters) {
		this.stepParameters = stepParameters;
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		StepParametersElements a = ga.getStepParametersAccess();

		formatKeyword(df.getRegion(stepParameters, a.getParametersKeyword_0()), doc);
		formatTitleRuleCall(df.getRegion(stepParameters, a.getNameTitleParserRuleCall_1_0()), doc);
		formatEOL2RuleCall(df.getRegion(stepParameters, a.getEOLTerminalRuleCall_2()), doc);
		for (Statement s : stepParameters.getStatements()) {

			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, stepParameters.getStatements()));
			formatter.setIndent(6);
			formatter.isLastEOLDouble(true);
			formatter.format(doc, ga, df);
		}
		ParametersTableFormatter formatter = new ParametersTableFormatter(stepParameters.getParametersTable());
		formatter.format(doc, ga, df);
	}
}
