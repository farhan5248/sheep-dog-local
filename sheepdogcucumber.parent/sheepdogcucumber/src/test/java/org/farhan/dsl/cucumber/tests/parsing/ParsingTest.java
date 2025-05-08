package org.farhan.dsl.cucumber.tests.parsing;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.farhan.dsl.cucumber.cucumber.Feature;
import org.farhan.dsl.cucumber.cucumber.StepObject;
import org.junit.jupiter.api.Assertions;

import com.google.inject.Inject;

public class ParsingTest {

	@Inject
	protected ParseHelper<Feature> parseFeatureHelper;

	@Inject
	protected ParseHelper<StepObject> parseStepObjectHelper;

	protected void assertNoStepObjectErrors(StringBuilder sb) {
		StepObject result;
		try {
			result = parseStepObjectHelper.parse(sb.toString());
		} catch (Exception e) {
			result = null;
		}
		Assertions.assertNotNull(result);
		List<Diagnostic> errors = result.eResource().getErrors();
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: " + IterableExtensions.join(errors, ", "));
	}

	protected void assertStepObjectErrors(StringBuilder sb) {
		StepObject result;
		try {
			result = parseStepObjectHelper.parse(sb.toString());
		} catch (Exception e) {
			result = null;
		}
		Assertions.assertNotNull(result);
		List<Diagnostic> errors = result.eResource().getErrors();
		Assertions.assertTrue(!errors.isEmpty(), "There should be errors");
	}

	protected void assertNoFeatureErrors(StringBuilder sb) {
		Feature result;
		try {
			result = parseFeatureHelper.parse(sb.toString());
		} catch (Exception e) {
			result = null;
		}
		Assertions.assertNotNull(result);
		List<Diagnostic> errors = result.eResource().getErrors();
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: " + IterableExtensions.join(errors, ", "));
	}

	protected void assertFeatureErrors(StringBuilder sb) {
		Feature result;
		try {
			result = parseFeatureHelper.parse(sb.toString());
		} catch (Exception e) {
			result = null;
		}
		Assertions.assertNotNull(result);
		List<Diagnostic> errors = result.eResource().getErrors();
		Assertions.assertTrue(!errors.isEmpty(), "There should be errors");
	}
}
