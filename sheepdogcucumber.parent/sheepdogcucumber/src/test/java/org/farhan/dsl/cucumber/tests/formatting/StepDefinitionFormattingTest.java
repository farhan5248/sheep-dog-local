package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class StepDefinitionFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Object: This is a test object\n");
		sb.append("\n");
		sb.append("  Definition: Submit a claim\n");
		sb.append("\n");
		sb.append("    Basic EDI claim\n");
		sb.append("    No deductible\n");
		sb.append("\n");
		sb.append("    Parameters: Describe what this data is about\n");
		sb.append("\n");
		sb.append("          | Header1 | Header2 |\n");
		sb.append("\n");
		assertNoStepObjectErrors(sb);
		return sb;
	}

	@Test
	public void formatStepDefinitionNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepDefinitionMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("  Object:   This is a test object  \n");
			sb.append("\n");
			sb.append("    Definition: Submit a claim  \n");
			sb.append("\n");
			sb.append("      Basic EDI claim  \n");
			sb.append("      No deductible  \n");
			sb.append("\n");
			sb.append("      Parameters:   Describe what this data is about  \n");
			sb.append("\n");
			sb.append("            |   Header1   |   Header2   |  \n");
			sb.append("\n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepDefinitionFewerSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Object: This is a test object\n");
			sb.append("\n");
			sb.append("Definition: Submit a claim\n");
			sb.append("\n");
			sb.append("Basic EDI claim\n");
			sb.append("No deductible\n");
			sb.append("\n");
			sb.append("Parameters: Describe what this data is about\n");
			sb.append("\n");
			sb.append("| Header1 | Header2 |\n");
			sb.append("\n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepDefinitionMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Object: This is a test object\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("  Definition: Submit a claim\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Basic EDI claim\n");
			sb.append("    No deductible\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    Parameters: Describe what this data is about\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("\n");
			sb.append("\n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
