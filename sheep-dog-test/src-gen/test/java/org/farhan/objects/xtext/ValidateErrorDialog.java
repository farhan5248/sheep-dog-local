package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateErrorDialog {

    public void assertEmpty(HashMap<String, String> keyMap);

    public void assertMessage(HashMap<String, String> keyMap);
}
