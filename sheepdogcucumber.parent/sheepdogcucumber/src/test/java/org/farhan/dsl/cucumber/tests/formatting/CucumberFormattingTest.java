package org.farhan.dsl.cucumber.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.cucumber.tests.CucumberInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(CucumberInjectorProvider.class)
public class CucumberFormattingTest extends FormattingTest {

	@Test
	public void formatCompleteFile() {

		assertFormatted((FormatterTestRequest it) -> {
			StringBuilder sb = new StringBuilder();
			sb.append("@tag1 @tag2 @tag3\n");
			sb.append("Feature: This is a test feature\n");
			sb.append("\n");
			sb.append("  This is the description\n");
			sb.append("  This is the second line of the description\n");
			sb.append("\n");
			sb.append("  Background: Setup a cardholder\n");
			sb.append("\n");
			sb.append("    First setup a group\n");
			sb.append("    Next setup the cardholder\n");
			sb.append("    Next setup their family\n");
			sb.append("\n");
			sb.append("    Given do step one\n");
			sb.append("          \"\"\"\n");
			sb.append("              Line1\n");
			sb.append("          Line2\n");
			sb.append("          Line3\n");
			sb.append("          \"\"\"\n");
			sb.append("      And do step two\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("     When do step three\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("     Then do step four\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("      But do step five\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("        * do step six\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("\n");
			sb.append("  @tag1 @tag2 @tag3\n");
			sb.append("  Scenario: Submit a claim\n");
			sb.append("\n");
			sb.append("        * do step one\n");
			sb.append("      And do step two\n");
			sb.append("\n");
			sb.append("  @tag1 @tag2 @tag3\n");
			sb.append("  Scenario: Submit a drug claim\n");
			sb.append("\n");
			sb.append("        * do step one\n");
			sb.append("      And do step two\n");
			sb.append("     When do step three\n");
			sb.append("     Then do step four\n");
			sb.append("      But do step five\n");
			sb.append("    Given do step six\n");
			sb.append("          \"\"\"\n");
			sb.append("              Line1\n");
			sb.append("          Line2\n");
			sb.append("          Line3\n");
			sb.append("          \"\"\"\n");
			sb.append("\n");
			sb.append("  @tag1 @tag2 @tag3\n");
			sb.append("  Scenario Outline: Submit a dental claim\n");
			sb.append("\n");
			sb.append("    Given do step one\n");
			sb.append("      And do step two\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("     When do step three\n");
			sb.append("     Then do step four\n");
			sb.append("      But do step five\n");
			sb.append("        * do step six\n");
			sb.append("\n");
			sb.append("    @tag1 @tag2 @tag3\n");
			sb.append("    Examples: Describe what this data is about\n");
			sb.append("\n");
			sb.append("      Put some explanation here.\n");
			sb.append("\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("          | data3   | data4   |\n");
			sb.append("\n");
			sb.append("  @tag1 @tag2 @tag3\n");
			sb.append("  Scenario Outline: Submit a dental claim\n");
			sb.append("\n");
			sb.append("    Given do step one\n");
			sb.append("      And do step two\n");
			sb.append("     When do step three\n");
			sb.append("     Then do step four\n");
			sb.append("      But do step five\n");
			sb.append("        * do step six\n");
			sb.append("\n");
			sb.append("    @tag1 @tag2 @tag3\n");
			sb.append("    Examples: Describe what this data is about as well\n");
			sb.append("\n");
			sb.append("      Put some explanation here.\n");
			sb.append("\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("          | data3   | data4   |\n");
			sb.append("\n");
			sb.append("    @tag1 @tag2 @tag3\n");
			sb.append("    Examples: Describe this data too\n");
			sb.append("\n");
			sb.append("          | Header1 | Header2 |\n");
			sb.append("          | data1   | data2   |\n");
			sb.append("\n");
			sb.append("");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(sb.toString());
		});
	}

}
