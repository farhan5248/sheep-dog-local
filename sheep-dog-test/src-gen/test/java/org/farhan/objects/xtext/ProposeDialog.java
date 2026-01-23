package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ProposeDialog {

    public void assertEmpty(HashMap<String, String> keyMap);

    public void assertSuggestion(HashMap<String, String> keyMap);

    public void assertSuggestionName(HashMap<String, String> keyMap);

    public void assertSuggestionDescription(HashMap<String, String> keyMap);
}
