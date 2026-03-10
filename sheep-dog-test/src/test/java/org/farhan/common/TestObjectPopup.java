package org.farhan.common;

import java.util.ArrayList;

public class TestObjectPopup extends TestObjectDSL {

    protected String listToString(ArrayList<?> proposals) {
        StringBuilder sb = new StringBuilder();
        for (Object p : proposals) {
            sb.append("\n").append(p.toString());
        }
        return sb.toString();
    }

}
