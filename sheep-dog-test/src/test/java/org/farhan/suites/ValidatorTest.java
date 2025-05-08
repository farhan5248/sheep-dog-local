package org.farhan.suites;

import org.farhan.dsl.common.TestStepNameHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

	@Test
	public void testGetComponentObjectState() {
		Assertions.assertTrue(
				TestStepNameHelper.getComponent("The Something1 application, Something2 request is executed with")
						.contentEquals("Something1 application"));
	}

	@Test
	public void testGetComponentObject() {
		Assertions.assertTrue(TestStepNameHelper.getComponent("The Something1 application, Something2 request")
				.contentEquals("Something1 application"));
	}

	@Test
	public void testGetComponent() {
		Assertions.assertTrue(TestStepNameHelper.getComponent("The Something1 application, ")
				.contentEquals("Something1 application"));
	}

	@Test
	public void testGetObjectComponentState() {
		Assertions.assertTrue(
				TestStepNameHelper.getObject("The Something1 application, Something2 request is executed with")
						.contentEquals("Something2 request"));
	}

	@Test
	public void testGetObjectComponent() {
		Assertions.assertTrue(TestStepNameHelper.getObject("The Something1 application, Something2 request")
				.contentEquals("Something2 request"));
	}

	@Test
	public void testGetObject() {
		Assertions
				.assertTrue(TestStepNameHelper.getObject("The Something2 request").contentEquals("Something2 request"));
	}

	@Test
	public void testGetPredicate() {
		Assertions.assertTrue(TestStepNameHelper
				.getPredicate("The Something1 application, Something2 request Something3 section is executed with")
				.contentEquals("Something3 section is executed with"));
	}

	@Test
	public void testHasModalityWithDetails() {
		Assertions.assertTrue(TestStepNameHelper
				.hasStateModality("The Something1 application, Something2 request Something3 section is"));
	}

	@Test
	public void testHasModalityWithoutDetails() {
		Assertions.assertTrue(TestStepNameHelper.hasStateModality("The Something1 application, Something2 request is"));
	}

	@Test
	public void testHasModalityEmpty() {
		Assertions.assertFalse(TestStepNameHelper.hasStateModality("The Something1 application, Something2 request"));
	}

	@Test
	public void testHasDetailsEmpty() {
		Assertions.assertFalse(TestStepNameHelper.hasDetails("The Something1 application, Something2 request"));
	}

	@Test
	public void testHasDetails() {
		Assertions.assertTrue(
				TestStepNameHelper.hasDetails("The Something1 application, Something2 request something section"));
	}
}
