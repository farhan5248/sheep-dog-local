package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateDialog;

@ScenarioScoped
public class XtextValidateDialogSteps extends TestSteps {

    @Inject
    public XtextValidateDialogSteps(ValidateDialog object) {
        super(object, "xtext", "validate");
    }

    @Given("^The xtext plugin validate dialog is empty$")
    public void isEmpty() {
        object.setInputOutputs("Empty");
    }

    @Given("^The xtext plugin validate dialog is set as follows$")
    public void isSetAsFollows(String docString) {
        object.setInputOutputs("Content", docString);
    }

    @Given("^The xtext plugin validate dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin validate dialog will be set as follows$")
    public void willBeSetAsFollows(String docString) {
        object.assertInputOutputs("Content", docString);
    }
}
