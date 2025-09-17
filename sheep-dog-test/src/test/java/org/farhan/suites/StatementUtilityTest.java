package org.farhan.suites;

import java.util.Set;

import org.farhan.dsl.lang.StatementUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementUtilityTest {

	@Test
	public void testGetTags() {
		Assertions.assertTrue(
				StatementUtility.getTags("@tag1 @tag2 @tag3").containsAll(Set.of("tag1", "tag2", "tag3")));
	}

	@Test
	public void testIsTag() {
		Assertions.assertTrue(StatementUtility.isTag("@tag1"));
	}

	@Test
	public void testIsTodo() {
		Assertions.assertTrue(StatementUtility.isTodo("TODO"));
	}
}
