package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListProposalsAction {

    public void setSelectedElement(HashMap<String, String> keyMap);

    public void transition();
}
