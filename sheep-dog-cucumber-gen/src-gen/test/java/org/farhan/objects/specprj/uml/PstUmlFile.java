package org.farhan.objects.specprj.uml;

import java.util.HashMap;

public interface PstUmlFile {

    public String getClassAnnotationsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getClassAnnotationsSectionClassName(HashMap<String, String> keyMap);

    public String getClassAnnotationsSectionAnnotationName(HashMap<String, String> keyMap);

    public String getClassAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap);

    public String getClassCommentsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getClassCommentsSectionClassName(HashMap<String, String> keyMap);

    public String getClassCommentsSectionComment(HashMap<String, String> keyMap);

    public String getClassSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getClassSectionClassName(HashMap<String, String> keyMap);

    public String getInteractionAnnotationsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getInteractionAnnotationsSectionInteractionName(HashMap<String, String> keyMap);

    public String getInteractionAnnotationsSectionAnnotationName(HashMap<String, String> keyMap);

    public String getInteractionAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap);

    public String getInteractionCommentsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getInteractionCommentsSectionInteractionName(HashMap<String, String> keyMap);

    public String getInteractionCommentsSectionComment(HashMap<String, String> keyMap);

    public String getInteractionMessagesSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getInteractionMessagesSectionInteractionName(HashMap<String, String> keyMap);

    public String getInteractionMessagesSectionMessage(HashMap<String, String> keyMap);

    public String getInteractionMessagesSectionArgumentName(HashMap<String, String> keyMap);

    public String getInteractionMessagesSectionAnnotationDetail(HashMap<String, String> keyMap);

    public String getInteractionSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getInteractionSectionInteractionName(HashMap<String, String> keyMap);

    public String getPresent(HashMap<String, String> keyMap);
}
