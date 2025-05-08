package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.UmlToJunitSpringGoal;

@ScenarioScoped
public class MavenUmlToJunitSpringGoalSteps extends TestSteps {

    @Inject
    public MavenUmlToJunitSpringGoalSteps(UmlToJunitSpringGoal object) {
        super(object, "maven", "uml-to-junit-spring");
    }

    @Given("^The maven plugin, uml-to-junit-spring goal is executed$")
    public void isExecuted() {
        object.transition();
    }
}
