package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.UmlToJunitGuiceGoal;

@ScenarioScoped
public class MavenUmlToJunitGuiceGoalSteps extends TestSteps {

    @Inject
    public MavenUmlToJunitGuiceGoalSteps(UmlToJunitGuiceGoal object) {
        super(object, "maven", "uml-to-junit-guice");
    }

    @Given("^The maven plugin, uml-to-junit-guice goal is executed$")
    public void isExecuted() {
        object.transition();
    }
}
