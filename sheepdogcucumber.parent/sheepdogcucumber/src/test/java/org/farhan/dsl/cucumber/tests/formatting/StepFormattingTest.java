package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class StepFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		sb.append("  Scenario: Submit a claim\n");
		sb.append("\n");
		sb.append("    Given do step one\n");
		sb.append("     When do step three\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatScenarioNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("  Feature:   This is a test feature  \n");
			sb.append("\n");
			sb.append("    Scenario:   Submit a claim  \n");
			sb.append("\n");
			sb.append("      Given do step one  \n");
			sb.append("       When do step three  \n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioFewerSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("Scenario: Submit a claim\n");
			sb.append("\n");
			sb.append("Given do step one\n");
			sb.append("When do step three\n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatScenarioMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("  Scenario: Submit a claim");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Given do step one\n");
			sb.append("\n");
			sb.append("     When do step three\n");
			sb.append("\n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
