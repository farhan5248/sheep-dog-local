package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;

@ScenarioScoped
public class MavenUmlToCucumberSpringGoalSteps extends TestSteps {

    @Inject
    public MavenUmlToCucumberSpringGoalSteps(UmlToCucumberSpringGoal object) {
        super(object, "maven", "uml-to-cucumber-spring");
    }

    @Given("^The maven plugin, uml-to-cucumber-spring goal is executed$")
    public void isExecuted() {
        object.transition();
    }
}
