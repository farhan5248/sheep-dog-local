package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RowUtility {

    public static String getCellListAsString(IRow row) {
        String cellsAsString = "";
        List<String> theList = new ArrayList<String>();
        for (ICell cell : row.getCellList()) {
            theList.add(cell.getName());
        }
        Collections.sort(theList);
        for (String cell : theList) {
            cellsAsString += "| " + cell;
        }
        return cellsAsString.trim();
    }
}
