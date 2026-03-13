package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;

public class CellIssueDetector {

    public static String validateNameOnly(ICell theCell) {
        IRow row = theCell.getParent();
        ITable table = row.getParent();
        if (table.getRowList().indexOf(row) == 0) {
            String name = theCell.getName();
            if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
                return CellIssueTypes.CELL_NAME_ONLY.description;
            }
        }
        return "";
    }
}
