package org.farhan.suites;

import java.util.Set;

import org.farhan.dsl.common.StatementNameHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementNameHelperTest {

	@Test
	public void testGetTags() {
		Assertions.assertTrue(
				StatementNameHelper.getTags("@tag1 @tag2 @tag3").containsAll(Set.of("tag1", "tag2", "tag3")));
	}

	@Test
	public void testIsTag() {
		Assertions.assertTrue(StatementNameHelper.isTag("@tag1"));
	}

	@Test
	public void testIsTodo() {
		Assertions.assertTrue(StatementNameHelper.isTodo("TODO"));
	}
}
