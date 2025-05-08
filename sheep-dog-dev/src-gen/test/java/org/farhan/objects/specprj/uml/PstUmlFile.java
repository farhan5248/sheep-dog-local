package org.farhan.objects.specprj.uml;

import java.util.HashMap;

public interface PstUmlFile {

    public void assertClassAnnotationsSectionClassName(HashMap<String, String> keyMap);

    public void assertClassAnnotationsSectionAnnotationName(HashMap<String, String> keyMap);

    public void assertClassAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap);

    public void assertClassCommentsSectionClassName(HashMap<String, String> keyMap);

    public void assertClassCommentsSectionComment(HashMap<String, String> keyMap);

    public void assertClassSectionClassName(HashMap<String, String> keyMap);

    public void assertClassSectionNegative(HashMap<String, String> keyMap);

    public void assertInteractionAnnotationsSectionInteractionName(HashMap<String, String> keyMap);

    public void assertInteractionAnnotationsSectionAnnotationName(HashMap<String, String> keyMap);

    public void assertInteractionAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap);

    public void assertInteractionCommentsSectionInteractionName(HashMap<String, String> keyMap);

    public void assertInteractionCommentsSectionComment(HashMap<String, String> keyMap);

    public void assertInteractionMessagesSectionInteractionName(HashMap<String, String> keyMap);

    public void assertInteractionMessagesSectionMessage(HashMap<String, String> keyMap);

    public void assertInteractionMessagesSectionArgumentName(HashMap<String, String> keyMap);

    public void assertInteractionMessagesSectionAnnotationDetail(HashMap<String, String> keyMap);

    public void assertInteractionSectionInteractionName(HashMap<String, String> keyMap);

    public void assertInteractionSectionNegative(HashMap<String, String> keyMap);

    public void assertPresent(HashMap<String, String> keyMap);
}
