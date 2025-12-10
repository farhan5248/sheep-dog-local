package org.farhan.dsl.sheepdog.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.farhan.dsl.sheepdog.tests.SheepDogInjectorProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(SheepDogInjectorProvider.class)
public class TableFormattingTest extends FormattingTest {

	private StringBuilder getExpected() {

		StringBuilder sb = new StringBuilder();
		sb.append("= Test-Suite: This is a test feature\n");
		sb.append("\n");
		sb.append("== Test-Case: Submit a drug claim\n");
		sb.append("\n");
		sb.append("* Given: do step, one\n");
		sb.append("+\n");
		sb.append("|===\n");
		sb.append("| Header1 | Header2\n");
		sb.append("| data1   | data2  \n");
		sb.append("|===\n");
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
			sb.append("= Test-Suite: This is a test feature\n");
			sb.append("\n");
			sb.append("== Test-Case: Submit a drug claim\n");
			sb.append("\n");
			sb.append("* Given: do step, one\n");
			sb.append("+\n");
			sb.append(" |=== \n");
			sb.append(" |  Header1  |  Header2   \n");
			sb.append(" |  data1   |  data2     \n");
			sb.append(" |=== \n");
			sb.append("\n");
			assertNoFeatureErrors(sb);
			it.setToBeFormatted(sb.toString());
			it.setExpectation(getExpected().toString());
		});
	}
}
