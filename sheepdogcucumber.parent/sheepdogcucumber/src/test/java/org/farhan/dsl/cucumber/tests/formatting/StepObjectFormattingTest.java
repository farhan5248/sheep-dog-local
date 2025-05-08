package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class StepObjectFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Object: This is a test object\n");
		sb.append("\n");
		sb.append("  This is the description\n");
		sb.append("  This is the second line of the description\n");
		sb.append("\n");
		assertNoStepObjectErrors(sb);
		return sb;
	}

	@Test
	public void formatStepObjectNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepObjectMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(" Object:  This is a test object \n");
			sb.append(" This is the description \n");
			sb.append(" This is the second line of the description \n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepObjectFewerSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Object: This is a test object\n");
			sb.append("This is the description\n");
			sb.append("This is the second line of the description\n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatStepObjectMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Object: This is a test object\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("  This is the description\n");
			sb.append("\n");
			sb.append("  This is the second line of the description\n");
			sb.append("\n");
			assertNoStepObjectErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
