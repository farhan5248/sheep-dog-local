package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StepDefinitionUtility {

	public static IStepParameters getStepParameters(IStepDefinition stepDefinition, String pipeDelimitedString) {
		String normalizedInput = normalizePipeDelimitedString(pipeDelimitedString);
		for (IStepParameters sp : stepDefinition.getStepParameterList()) {
			IRow firstRow = sp.getTable().getRowList().getFirst();
			String rowAsString = cellsToString(firstRow.getCellList());
			if (normalizedInput.contentEquals(rowAsString)) {
				return sp;
			}
		}
		return null;
	}

	private static String normalizePipeDelimitedString(String pipeDelimitedString) {
		String normalized = "";
		List<String> sortedCells = new ArrayList<String>();
		for (String cell : pipeDelimitedString.split("\\|")) {
			String trimmedCell = cell.trim();
			if (!trimmedCell.isEmpty()) {
				sortedCells.add(trimmedCell);
			}
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			normalized += "| " + cell;
		}
		return normalized.trim();
	}

	private static String cellsToString(List<ICell> cells) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (ICell cell : cells) {
			sortedCells.add(cell.getName());
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}
}
