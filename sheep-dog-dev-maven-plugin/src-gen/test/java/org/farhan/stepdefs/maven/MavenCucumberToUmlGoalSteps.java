package org.farhan.stepdefs.maven;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.maven.CucumberToUmlGoal;

@ScenarioScoped
public class MavenCucumberToUmlGoalSteps extends TestSteps {

    @Inject
    public MavenCucumberToUmlGoalSteps(CucumberToUmlGoal object) {
        super(object, "maven", "cucumber-to-uml");
    }

    @Given("^The maven plugin, cucumber-to-uml goal is executed with$")
    public void isExecutedWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
