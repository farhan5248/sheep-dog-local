package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;

@ScenarioScoped
public class MavenUmlToAsciidoctorGoalSteps extends TestSteps {

    @Inject
    public MavenUmlToAsciidoctorGoalSteps(UmlToAsciidoctorGoal object) {
        super(object, "maven", "uml-to-asciidoctor");
    }

    @Given("^The maven plugin uml-to-asciidoctor goal is executed$")
    public void isExecuted() {
        object.doEdgeStep("", "", "is", "executed");
    }
}
