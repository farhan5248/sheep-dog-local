package org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah;

import java.util.HashMap;

public interface BlahObjectPageStepsJavaFile {

    public String getHeaderSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getHeaderSectionClassAnnotation(HashMap<String, String> keyMap);

    public String getHeaderSectionClassName(HashMap<String, String> keyMap);

    public String getHeaderSectionPackage(HashMap<String, String> keyMap);

    public String getHeaderSectionConstructorName(HashMap<String, String> keyMap);

    public String getHeaderSectionConstructorAnnotation(HashMap<String, String> keyMap);

    public String getHeaderSectionStatement(HashMap<String, String> keyMap);

    public String getHeaderSectionExtends(HashMap<String, String> keyMap);

    public String getHeaderSectionImport(HashMap<String, String> keyMap);

    public String getMethodsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getMethodsSectionMethodName(HashMap<String, String> keyMap);

    public String getMethodsSectionAnnotation(HashMap<String, String> keyMap);

    public String getMethodsSectionVisibility(HashMap<String, String> keyMap);

    public String getMethodsSectionReturnType(HashMap<String, String> keyMap);

    public String getMethodsSectionParameterName(HashMap<String, String> keyMap);

    public String getMethodsSectionParameterType(HashMap<String, String> keyMap);

    public String getMethodsSectionStatement(HashMap<String, String> keyMap);

    public void setCreatedAsFollows(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public String getCreatedAsFollows(HashMap<String, String> keyMap);

    public String getContent(HashMap<String, String> keyMap);

    public String getPresent(HashMap<String, String> keyMap);
}
