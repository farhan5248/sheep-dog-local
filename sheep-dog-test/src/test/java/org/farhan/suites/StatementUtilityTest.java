package org.farhan.suites;

import java.util.Set;

import org.farhan.dsl.lang.TitleFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementUtilityTest {

    @Test
    public void testGetTags() {
        Assertions.assertTrue(
                TitleFragments.getTagAsList("@tag1 @tag2 @tag3").containsAll(Set.of("tag1", "tag2", "tag3")));
    }

    @Test
    public void testIsTag() {
        Assertions.assertTrue(TitleFragments.isTag("@tag1"));
    }

    @Test
    public void testIsTodo() {
        Assertions.assertTrue(TitleFragments.isTodo("TODO Do something"));
    }

    @Test
    public void testGetTodoType() {
        Assertions.assertTrue(TitleFragments.getTodoType("TODO Do something").contentEquals("TODO"));
    }

    @Test
    public void testGetTodoDesc() {
        Assertions.assertTrue(TitleFragments.getTodoDesc("TODO Do something").contentEquals("Do something"));
    }
}
