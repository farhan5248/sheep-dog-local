package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.cucumber.cucumber.Scenario;
import org.farhan.dsl.cucumber.cucumber.Tag;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.ScenarioElements;

public class ScenarioFormatter extends AbstractScenarioFormatter {

	public ScenarioFormatter(Scenario theScenario) {
		super(theScenario);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(CucumberGrammarAccess ga) {
		return ga.getScenarioAccess();
	}

	@Override
	protected void formatTags(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		Scenario theScenario = (Scenario) theAbstractScenario;
		if (!theScenario.getTags().isEmpty()) {
			for (Tag t : theScenario.getTags()) {
				TagFormatter formatter = new TagFormatter(t);
				formatter.isLast(isLastElement(t, theScenario.getTags()));
				formatter.isFirst(isFirstElement(t, theScenario.getTags()));
				formatter.setIndent(2);
				formatter.format(doc, ga, df);
			}
			formatEOL1RuleCall(df.getRegion(theScenario, ga.getScenarioAccess().getEOLTerminalRuleCall_0_1()), doc);
		}
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((ScenarioElements) a).getScenarioKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((ScenarioElements) a).getEOLTerminalRuleCall_3();
	}

	@Override
	protected RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a) {
		return ((ScenarioElements) a).getNamePhraseParserRuleCall_2_0();
	}

	@Override
	protected void formatExamples(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		// Nothing to do here
	}

}
