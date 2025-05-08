package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;

@ScenarioScoped
public class MavenAsciidoctorToUmlGoalSteps extends TestSteps {

    @Inject
    public MavenAsciidoctorToUmlGoalSteps(AsciidoctorToUmlGoal object) {
        super(object, "maven", "asciidoctor-to-uml");
    }

    @Given("^The maven plugin, asciidoctor-to-uml goal is executed$")
    public void isExecuted() {
        object.transition();
    }

    @Given("^The maven plugin, asciidoctor-to-uml goal is executed with$")
    public void isExecutedWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
