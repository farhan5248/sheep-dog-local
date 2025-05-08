package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class ScenarioOutlineFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		sb.append("  @tag1\n");
		sb.append("  Scenario Outline: Submit a claim\n");
		sb.append("\n");
		sb.append("    Basic EDI claim\n");
		sb.append("    No deductible\n");
		sb.append("\n");
		sb.append("    Given do step one\n");
		sb.append("     When do step three\n");
		sb.append("\n");
		sb.append("    Examples: Describe what this data is about\n");
		sb.append("\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatScenarioOutlineNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioOutlineMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("  Feature:   This is a test feature  \n");
			sb.append("\n");
			sb.append("    @tag1  \n");
			sb.append("    Scenario Outline: Submit a claim  \n");
			sb.append("\n");
			sb.append("      Basic EDI claim  \n");
			sb.append("      No deductible  \n");
			sb.append("\n");
			sb.append("      Given do step one  \n");
			sb.append("       When do step three  \n");
			sb.append("\n");
			sb.append("      Examples:   Describe what this data is about  \n");
			sb.append("\n");
			sb.append("            |   Header1   |   Header2   |  \n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioOutlineFewerSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("@tag1\n");
			sb.append("Scenario Outline: Submit a claim\n");
			sb.append("\n");
			sb.append("Basic EDI claim\n");
			sb.append("No deductible\n");
			sb.append("\n");
			sb.append("Given do step one\n");
			sb.append("When do step three\n");
			sb.append("\n");
			sb.append("Examples: Describe what this data is about\n");
			sb.append("\n");
			sb.append("| Header1 | Header2 |\n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioOutlineMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("  @tag1\n");
			sb.append("  Scenario Outline: Submit a claim\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Basic EDI claim\n");
			sb.append("    No deductible\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Given do step one\n");
			sb.append("\n");
			sb.append("     When do step three\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Examples: Describe what this data is about\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("\n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
