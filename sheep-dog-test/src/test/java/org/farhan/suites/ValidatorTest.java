package org.farhan.suites;

import org.farhan.dsl.lang.TestStepUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

	@Test
	public void testGetComponentObjectState() {
		Assertions.assertTrue(
				TestStepUtility.getComponent("The Something1 application Something2 request is executed with")
						.contentEquals("Something1 application"));
	}

	@Test
	public void testGetComponentObject() {
		Assertions.assertTrue(TestStepUtility.getComponent("The Something1 application Something2 request")
				.contentEquals("Something1 application"));
	}

	@Test
	public void testGetComponent() {
		Assertions.assertTrue(
				TestStepUtility.getComponent("The Something1 application ").contentEquals(""));
	}

	@Test
	public void testGetObjectComponentState() {
		Assertions
				.assertTrue(TestStepUtility.getObject("The Something1 application Something2 request is executed with")
						.contentEquals("Something2 request"));
	}

	@Test
	public void testGetObjectComponent() {
		Assertions.assertTrue(TestStepUtility.getObject("The Something1 application Something2 request")
				.contentEquals("Something2 request"));
	}

	@Test
	public void testGetStepObjectName() {
		Assertions.assertTrue(TestStepUtility.getObject("The Something2 request").contentEquals("Something2 request"));
	}

	@Test
	public void testGetStepDefinitionName() {
		Assertions.assertTrue(TestStepUtility
				.getStepDefinitionName(
						"The Something1 application Something2 request Something3 section is executed with")
				.contentEquals("Something3 section is executed with"));
	}

}
