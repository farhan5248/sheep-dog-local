package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class StepTableFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		sb.append("  Scenario: Submit a drug claim\n");
		sb.append("\n");
		sb.append("    Given do step one\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("     When do step three\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("     Then do step four\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("      And do step two\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("      But do step five\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("        * do step six\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("          | data1   | data2   |\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatStepTableNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepTableMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("  Scenario: Submit a drug claim\n");
			sb.append("\n");
			sb.append("     Given do step one\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("      When do step three\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("      Then do step four\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("       And do step two\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("       But do step five\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("         * do step six\n");
			sb.append("           |  Header1  |  Header2  | \n");
			sb.append("           |    data1  |    data2  | \n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
