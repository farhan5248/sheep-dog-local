package org.farhan.objects.xtext;

import java.util.HashMap;

public interface ListQuickfixesDialog {
	public void assertEmpty(HashMap<String, String> keyMap);

	public void assertQuickfix(HashMap<String, String> keyMap);

	public void assertQuickfixName(HashMap<String, String> keyMap);

	public void assertQuickfixDescription(HashMap<String, String> keyMap);
}
