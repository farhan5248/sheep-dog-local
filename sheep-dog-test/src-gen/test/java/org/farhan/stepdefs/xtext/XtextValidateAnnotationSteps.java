package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateAnnotation;

@ScenarioScoped
public class XtextValidateAnnotationSteps extends TestSteps {

    @Inject
    public XtextValidateAnnotationSteps(ValidateAnnotation object) {
        super(object, "xtext", "validate");
    }

    @Given("^The xtext plugin validate annotation will be set as follows$")
    public void willBeSetAsFollows(String docString) {
        object.assertVertexStep("", "", "will be", "set as follows", docString);
    }
}
