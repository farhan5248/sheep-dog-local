package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateDialog {

    public void assertEmpty(HashMap<String, String> keyMap);

    public void assertContent(HashMap<String, String> keyMap);
}
