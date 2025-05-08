package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.UmlToCucumberGuiceGoal;

@ScenarioScoped
public class MavenUmlToCucumberGuiceGoalSteps extends TestSteps {

    @Inject
    public MavenUmlToCucumberGuiceGoalSteps(UmlToCucumberGuiceGoal object) {
        super(object, "maven", "uml-to-cucumber-guice");
    }

    @Given("^The maven plugin, uml-to-cucumber-guice goal is executed$")
    public void isExecuted() {
        object.transition();
    }
}
