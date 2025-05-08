package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class DocStringFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		sb.append("  Scenario: Submit a drug claim\n");
		sb.append("\n");
		sb.append("    Given do step one\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("     When do step three\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("     Then do step four\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("      And do step two\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("      But do step five\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("        * do step six\n");
		sb.append("          \"\"\"\n");
		sb.append("          Line1\n");
		sb.append("          \"\"\"\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatDocStringNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatDocStringMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("  Scenario: Submit a drug claim\n");
			sb.append("\n");
			sb.append("     Given do step one\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("      When do step three\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("      Then do step four\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("       And do step two\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("       But do step five\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("         * do step six\n");
			sb.append("           \"\"\"\n");
			sb.append("          Line1\n");
			sb.append("           \"\"\"\n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
