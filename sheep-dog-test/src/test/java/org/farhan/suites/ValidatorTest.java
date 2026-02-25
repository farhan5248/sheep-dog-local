package org.farhan.suites;

import org.farhan.dsl.lang.StepObjectRefFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testGetComponentObjectState() {
        Assertions
                .assertTrue(StepObjectRefFragments.getComponent("The graph-viewer application uml-to-cucumber request is executed with")
                        .contentEquals("graph-viewer application"));
    }

    @Test
    public void testGetComponentObject() {
        Assertions.assertTrue(StepObjectRefFragments.getComponent("The graph-viewer application uml-to-cucumber request")
                .contentEquals("graph-viewer application"));
    }

    @Test
    public void testGetComponent() {
        Assertions.assertTrue(
                StepObjectRefFragments.getComponent("The graph-viewer application ").contentEquals("graph-viewer application"));
    }

    @Test
    public void testGetObjectComponentState() {
        Assertions.assertTrue(StepObjectRefFragments.getObject("The graph-viewer application uml-to-cucumber request is executed with")
                .contentEquals("uml-to-cucumber request"));
    }

    @Test
    public void testGetObjectComponent() {
        Assertions.assertTrue(StepObjectRefFragments.getObject("The graph-viewer application uml-to-cucumber request")
                .contentEquals("uml-to-cucumber request"));
    }

}
