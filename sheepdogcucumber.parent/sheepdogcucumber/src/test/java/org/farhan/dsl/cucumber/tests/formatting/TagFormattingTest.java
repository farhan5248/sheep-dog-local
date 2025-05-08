package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class TagFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("@tag1 @tag2 @tag3\n");
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatTagNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatTagMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("  @tag1  @tag2  @tag3 \n");
			sb.append("Feature: This is a test feature\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatTagMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("@tag1 @tag2 @tag3\n");
			sb.append("\n");
			sb.append("Feature: This is a test feature\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
