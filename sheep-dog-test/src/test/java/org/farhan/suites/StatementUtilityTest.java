package org.farhan.suites;

import java.util.Set;

import org.farhan.dsl.lang.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementUtilityTest {

    @Test
    public void testGetTags() {
        Assertions.assertTrue(Title.getTags("@tag1 @tag2 @tag3").containsAll(Set.of("tag1", "tag2", "tag3")));
    }

    @Test
    public void testIsTag() {
        Assertions.assertTrue(Title.isTag("@tag1"));
    }

    @Test
    public void testIsTodo() {
        Assertions.assertTrue(Title.isTodo("TODO"));
    }
}
