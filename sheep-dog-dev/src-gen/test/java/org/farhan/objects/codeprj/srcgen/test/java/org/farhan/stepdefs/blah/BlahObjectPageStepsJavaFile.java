package org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah;

import java.util.HashMap;

public interface BlahObjectPageStepsJavaFile {

    public void assertHeaderSectionImport(HashMap<String, String> keyMap);

    public void assertHeaderSectionExtends(HashMap<String, String> keyMap);

    public void assertHeaderSectionConstructorName(HashMap<String, String> keyMap);

    public void assertHeaderSectionStatement(HashMap<String, String> keyMap);

    public void assertHeaderSectionClassAnnotation(HashMap<String, String> keyMap);

    public void assertHeaderSectionConstructorAnnotation(HashMap<String, String> keyMap);

    public void assertHeaderSectionClassName(HashMap<String, String> keyMap);

    public void assertHeaderSectionPackage(HashMap<String, String> keyMap);

    public void assertMethodsSectionMethodName(HashMap<String, String> keyMap);

    public void assertMethodsSectionAnnotation(HashMap<String, String> keyMap);

    public void assertMethodsSectionVisibility(HashMap<String, String> keyMap);

    public void assertMethodsSectionReturnType(HashMap<String, String> keyMap);

    public void assertMethodsSectionStatement(HashMap<String, String> keyMap);

    public void assertMethodsSectionParameterName(HashMap<String, String> keyMap);

    public void assertMethodsSectionParameterType(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void assertContent(HashMap<String, String> keyMap);

    public void assertPresent(HashMap<String, String> keyMap);
}
