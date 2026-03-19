package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.objects.xtext.AddDocumentAction;

public class AddDocumentActionImpl extends TestObjectSheepDogImpl implements AddDocumentAction {

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        setProperty("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setPerformedToCreateAStepObjectWith(HashMap<String, String> keyMap) {
        setProperty("cursor", getProperty("workspace"));
        if (getProperty("Step Object Full Name") != null) {
            addStepObjectWithFullName(getProperty("Step Object Full Name").toString());
            properties.remove("Step Object Full Name");
        }
    }

}
