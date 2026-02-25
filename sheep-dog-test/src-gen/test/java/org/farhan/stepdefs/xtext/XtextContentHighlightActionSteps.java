package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ContentHighlightAction;

@ScenarioScoped
public class XtextContentHighlightActionSteps extends TestSteps {

    @Inject
    public XtextContentHighlightActionSteps(ContentHighlightAction object) {
        super(object, "xtext", "content highlight");
    }

    @Given("^The xtext plugin content highlight action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
