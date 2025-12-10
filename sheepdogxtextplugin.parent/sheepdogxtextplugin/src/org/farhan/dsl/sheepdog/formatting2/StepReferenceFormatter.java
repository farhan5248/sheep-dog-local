package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess;
import org.farhan.dsl.sheepdog.services.SheepDogGrammarAccess.StepReferenceElements;
import org.farhan.dsl.sheepdog.sheepDog.StepReference;

public class StepReferenceFormatter extends Formatter {

	private StepReference theStepReference;

	public StepReferenceFormatter(StepReference theStepReference) {
		this.theStepReference = theStepReference;
	}

	public void format(IFormattableDocument doc, SheepDogGrammarAccess ga, SheepDogFormatter df) {
		StepReferenceElements a = ga.getStepReferenceAccess();
		formatIdNoSpace(df.getRegion(theStepReference, a.getObjectNameParserRuleCall_0_0()), doc);
		formatKeywordTrailingSpace(df.getRegion(theStepReference, a.getCommaKeyword_1()), doc);
		formatIdNoSpace(df.getRegion(theStepReference, a.getPredicateNameParserRuleCall_2_0()), doc);
	}

}
