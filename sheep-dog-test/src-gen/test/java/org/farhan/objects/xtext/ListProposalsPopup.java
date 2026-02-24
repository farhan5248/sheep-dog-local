package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListProposalsPopup {

    public void assertEmpty(HashMap<String, String> keyMap);

    public void assertProposalValue(HashMap<String, String> keyMap);

    public void assertProposalId(HashMap<String, String> keyMap);

    public void assertProposalDescription(HashMap<String, String> keyMap);
}
