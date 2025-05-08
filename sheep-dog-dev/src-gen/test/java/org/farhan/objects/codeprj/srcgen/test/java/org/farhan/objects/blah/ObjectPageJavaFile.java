package org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah;

import java.util.HashMap;

public interface ObjectPageJavaFile {

    public void assertHeaderSectionImport(HashMap<String, String> keyMap);

    public void assertHeaderSectionInterfaceName(HashMap<String, String> keyMap);

    public void assertHeaderSectionPackage(HashMap<String, String> keyMap);

    public void assertMethodsSectionMethodName(HashMap<String, String> keyMap);

    public void assertMethodsSectionVisibility(HashMap<String, String> keyMap);

    public void assertMethodsSectionReturnType(HashMap<String, String> keyMap);

    public void assertMethodsSectionParameterName(HashMap<String, String> keyMap);

    public void assertMethodsSectionParameterType(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void assertContent(HashMap<String, String> keyMap);

    public void assertPresent(HashMap<String, String> keyMap);
}
