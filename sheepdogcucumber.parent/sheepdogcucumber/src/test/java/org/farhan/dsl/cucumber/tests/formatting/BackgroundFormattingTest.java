package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class BackgroundFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("Feature: This is a test feature\n");
		sb.append("\n");
		sb.append("  Background: Setup a cardholder\n");
		sb.append("\n");
		sb.append("    First setup a group\n");
		sb.append("    Next setup the cardholder\n");
		sb.append("    Next setup their family\n");
		sb.append("\n");
		sb.append("    Given do step one\n");
		sb.append("     When do step three\n");
		sb.append("\n");
		assertNoFeatureErrors(sb);
		return sb;
	}

	@Test
	public void formatBackgroundNoIssues() {

		assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(getExpected().toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatBackgroundMoreSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("  Feature:   This is a test feature  \n");
			sb.append("\n");
			sb.append("    Background:   Setup a cardholder  \n");
			sb.append("\n");
			sb.append("      First setup a group  \n");
			sb.append("      Next setup the cardholder  \n");
			sb.append("      Next setup their family  \n");
			sb.append("\n");
			sb.append("      Given   do step one  \n");
			sb.append("       When   do step three  \n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}

	@Test
	public void formatBackgroundFewerSpaces() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("Background: Setup a cardholder\n");
			sb.append("\n");
			sb.append("First setup a group\n");
			sb.append("Next setup the cardholder\n");
			sb.append("Next setup their family\n");
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
	public void formatBackgroundMoreEOL() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("  Background: Setup a cardholder\n");
			sb.append("\n");
			sb.append("\n");
			sb.append("    First setup a group\n");
			sb.append("    Next setup the cardholder\n");
			sb.append("    Next setup their family\n");
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
