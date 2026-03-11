package org.farhan.impl.objects;

import java.util.ArrayList;

public class TestObjectPopupImpl extends TestObjectSheepDogImpl {

    protected String listToString(ArrayList<?> proposals) {
        StringBuilder sb = new StringBuilder();
        for (Object p : proposals) {
            sb.append("\n").append(p.toString());
        }
        return sb.toString();
    }

}
