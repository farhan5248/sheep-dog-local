package org.farhan.suites;

import org.farhan.dsl.lang.StepObjectRef;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    public void testGetComponentObjectState() {
        Assertions
                .assertTrue(StepObjectRef.getComponent("The Something1 application Something2 request is executed with")
                        .contentEquals("Something1 application"));
    }

    @Test
    public void testGetComponentObject() {
        Assertions.assertTrue(StepObjectRef.getComponent("The Something1 application Something2 request")
                .contentEquals("Something1 application"));
    }

    @Test
    public void testGetComponent() {
        Assertions.assertTrue(
                StepObjectRef.getComponent("The Something1 application ").contentEquals("Something1 application"));
    }

    @Test
    public void testGetObjectComponentState() {
        Assertions.assertTrue(StepObjectRef.getObject("The Something1 application Something2 request is executed with")
                .contentEquals("Something2 request"));
    }

    @Test
    public void testGetObjectComponent() {
        Assertions.assertTrue(StepObjectRef.getObject("The Something1 application Something2 request")
                .contentEquals("Something2 request"));
    }

}
