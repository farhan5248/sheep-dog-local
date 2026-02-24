package org.farhan.suites;

import java.util.Set;

import org.farhan.dsl.lang.PhraseFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementUtilityTest {

    @Test
    public void testGetTags() {
        Assertions.assertTrue(
                PhraseFragments.getTagAsList("@tag1 @tag2 @tag3").containsAll(Set.of("tag1", "tag2", "tag3")));
    }

    @Test
    public void testIsTag() {
        Assertions.assertTrue(PhraseFragments.isTag("@tag1"));
    }

    @Test
    public void testIsTodo() {
        Assertions.assertTrue(PhraseFragments.isTodo("TODO Do something"));
    }

    @Test
    public void testGetTodoType() {
        Assertions.assertTrue(PhraseFragments.getTodoType("TODO Do something").contentEquals("TODO"));
    }

    @Test
    public void testGetTodoDesc() {
        Assertions.assertTrue(PhraseFragments.getTodoDesc("TODO Do something").contentEquals("Do something"));
    }
}
