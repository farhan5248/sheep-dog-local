package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListProposalsAction {

    public void transition();

    public void setElementType(HashMap<String, String> keyMap);
}
