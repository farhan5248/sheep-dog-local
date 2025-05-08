package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractParserRuleElementFinder;
import org.farhan.dsl.cucumber.cucumber.Examples;
import org.farhan.dsl.cucumber.cucumber.ScenarioOutline;
import org.farhan.dsl.cucumber.cucumber.Tag;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess;
import org.farhan.dsl.cucumber.services.CucumberGrammarAccess.ScenarioOutlineElements;

public class ScenarioOutlineFormatter extends AbstractScenarioFormatter {

	public ScenarioOutlineFormatter(ScenarioOutline theScenarioOutline) {
		super(theScenarioOutline);
	}

	@Override
	protected AbstractParserRuleElementFinder getAccess(CucumberGrammarAccess ga) {
		return ga.getScenarioOutlineAccess();
	}

	@Override
	protected void formatTags(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		ScenarioOutline theScenarioOutline = (ScenarioOutline) theAbstractScenario;
		if (!theScenarioOutline.getTags().isEmpty()) {
			for (Tag t : theScenarioOutline.getTags()) {
				TagFormatter formatter = new TagFormatter(t);
				formatter.isLast(isLastElement(t, theScenarioOutline.getTags()));
				formatter.isFirst(isFirstElement(t, theScenarioOutline.getTags()));
				formatter.setIndent(2);
				formatter.format(doc, ga, df);
			}
			formatEOL1RuleCall(
					df.getRegion(theScenarioOutline, ga.getScenarioOutlineAccess().getEOLTerminalRuleCall_0_1()), doc);
		}
	}

	@Override
	protected Keyword getKeyword(AbstractParserRuleElementFinder a) {
		return ((ScenarioOutlineElements) a).getScenarioOutlineKeyword_1();
	}

	@Override
	protected RuleCall getEOLRuleCall(AbstractParserRuleElementFinder a) {
		return ((ScenarioOutlineElements) a).getEOLTerminalRuleCall_3();
	}

	@Override
	protected RuleCall getPhraseRuleCall(AbstractParserRuleElementFinder a) {
		return ((ScenarioOutlineElements) a).getNamePhraseParserRuleCall_2_0();
	}

	@Override
	protected void formatExamples(IFormattableDocument doc, CucumberGrammarAccess ga, CucumberFormatter df) {
		ScenarioOutline theScenarioOutline = (ScenarioOutline) theAbstractScenario;
		for (Examples e : theScenarioOutline.getExamples()) {
			ExampleFormatter formatter = new ExampleFormatter(e);
			formatter.setIndent(4);
			formatter.format(doc, ga, df);
		}
	}

}
