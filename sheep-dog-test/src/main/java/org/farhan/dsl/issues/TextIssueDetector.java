package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class TextIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

	public static String validateContentWorkspace(IText theText) throws Exception {
		logger.debug("Entry: validateContentWorkspace({})", theText);
		String message = "";
		ITestStep testStep = theText.getParent();
		if (testStep != null) {
			String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
			if (!stepObjectFullName.isEmpty()) {
				ITestProject project = SheepDogUtility.getTestProjectParentForText(theText);
				if (project != null) {
					ITestDocument stepObjectDoc = project.getTestDocument(stepObjectFullName);
					if (stepObjectDoc instanceof IStepObject) {
						IStepObject stepObject = (IStepObject) stepObjectDoc;
						String stepDefName = testStep.getStepDefinitionName();
						if (stepDefName != null && !stepDefName.isEmpty()) {
							IStepDefinition stepDef = stepObject.getStepDefinition(stepDefName);
							if (stepDef != null) {
								message = TextIssueTypes.TEXT_CONTENT_WORKSPACE.description;
								for (IStepParameters sp : stepDef.getStepParameterList()) {
									if (sp.getTable() != null && !sp.getTable().getRowList().isEmpty()) {
										IRow headerRow = sp.getTable().getRow(0);
										String paramCells = SheepDogUtility
												.getCellListAsString(headerRow.getCellList());
										if ("Content".equals(paramCells)) {
											message = "";
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		logger.debug("Exit: validateContentWorkspace({})", message);
		return message;
	}
}
