package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ValidateAnnotation {

    public void setEmpty(HashMap<String, String> keyMap);

    public void setSetAsFollows(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public String getEmpty(HashMap<String, String> keyMap);

    public String getSetAsFollows(HashMap<String, String> keyMap);

    public String getContent(HashMap<String, String> keyMap);
}
