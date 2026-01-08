package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.cucumber.cucumber.AbstractScenario;
import org.farhan.dsl.cucumber.cucumber.Background;
import org.farhan.dsl.cucumber.cucumber.Feature;
import org.farhan.dsl.cucumber.cucumber.Scenario;
import org.farhan.dsl.cucumber.cucumber.ScenarioOutline;
import org.farhan.dsl.cucumber.cucumber.Statement;
import org.farhan.dsl.cucumber.cucumber.Tag;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.FeatureElements;

public class FeatureFormatter extends Formatter {

	private Feature theFeature;

	public FeatureFormatter(Feature theFeature) {
		this.theFeature = theFeature;
	}

	private AbstractScenarioFormatter newAbstractScenarioFormatter(AbstractScenario s) {
		if (s instanceof Background) {
			return new BackgroundFormatter((Background) s);
		} else if (s instanceof Scenario) {
			return new ScenarioFormatter((Scenario) s);
		} else if (s instanceof ScenarioOutline) {
			return new ScenarioOutlineFormatter((ScenarioOutline) s);
		} else {
			return null;
		}
	}

	public void format(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		FeatureElements a = ga.getFeatureAccess();

		if (!theFeature.getTags().isEmpty()) {
			for (Tag t : theFeature.getTags()) {
				TagFormatter formatter = new TagFormatter(t);
				formatter.isLast(isLastElement(t, theFeature.getTags()));
				formatter.isFirst(isFirstElement(t, theFeature.getTags()));
				formatter.setIndent(0);
				formatter.format(doc, ga, df);
			}
			formatEOL1RuleCall(df.getRegion(theFeature, a.getEOLTerminalRuleCall_0_1()), doc);
		}
		formatKeyword(df.getRegion(theFeature, a.getFeatureKeyword_1()), doc);
		// There's two types of assignments, = and += where the latter is a list
		// This is an example of how to access an assignment of just one item.
		// An assignment has 2 parts, the feature (name) and the ruleCall (Phrase)
		// Together they make up an assignment.
		// A ruleCall is anything that's in the xtext file with a :
		// So a ruleCall can be a structure like thing with attributes or a terminal
		formatTitleRuleCall(df.getRegion(theFeature, a.getNameTitleParserRuleCall_2_0()), doc);
		formatEOL2RuleCall(df.getRegion(theFeature, a.getEOLTerminalRuleCall_3()), doc);
		for (Statement s : theFeature.getStatements()) {

			StatementFormatter formatter = new StatementFormatter(s);
			formatter.isLast(isLastElement(s, theFeature.getStatements()));
			formatter.setIndent(2);
			formatter.isLastEOLDouble(true);
			formatter.format(doc, ga, df);
		}

		for (AbstractScenario s : theFeature.getAbstractScenarios()) {

			AbstractScenarioFormatter formatter = newAbstractScenarioFormatter(s);
			formatter.setIndent(2);
			formatter.format(doc, ga, df);
		}
	}
}
