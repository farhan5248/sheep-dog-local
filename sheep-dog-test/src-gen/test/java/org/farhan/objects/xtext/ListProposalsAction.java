package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListProposalsAction {

    public void transition();

    public void setNodePath(HashMap<String, String> keyMap);
}
