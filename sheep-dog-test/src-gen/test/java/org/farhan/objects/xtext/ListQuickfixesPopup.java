package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListQuickfixesPopup {

    public String getSetAsFollows(HashMap<String, String> keyMap);

    public String getProposalId(HashMap<String, String> keyMap);

    public String getProposalDescription(HashMap<String, String> keyMap);

    public String getProposalValue(HashMap<String, String> keyMap);

    public String getEmpty(HashMap<String, String> keyMap);

    public void setSetAsFollows(HashMap<String, String> keyMap);

    public void setProposalId(HashMap<String, String> keyMap);

    public void setProposalDescription(HashMap<String, String> keyMap);

    public void setProposalValue(HashMap<String, String> keyMap);
}
