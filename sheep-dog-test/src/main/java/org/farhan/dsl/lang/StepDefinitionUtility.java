package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Static helper methods for grammar element operations.
 * <p>
 * Separates utility operations from grammar model classes, keeping interfaces
 * focused on data access.
 * </p>
 */
public class StepDefinitionUtility {

	/**
	 * Performs parsing, formatting, or computation operations on grammar elements
	 * without maintaining state.
	 *
	 * @param theStepDefinition the step definition to search
	 * @param row the row to match
	 * @return IStepParameters matching the row, or null if not found
	 */
	public static IStepParameters getStepParameters(IStepDefinition theStepDefinition, IRow row) {
		return getStepParameters(theStepDefinition, cellsToString(row.getCellList()));
	}

	/**
	 * Performs parsing, formatting, or computation operations on grammar elements
	 * without maintaining state.
	 *
	 * @param theStepDefinition the step definition to search
	 * @param theText the text element to match
	 * @return IStepParameters matching the text, or null if not found
	 */
	public static IStepParameters getStepParameters(IStepDefinition theStepDefinition, IText theText) {
		return StepDefinitionUtility.getStepParameters(theStepDefinition, "| Content");
	}

	/**
	 * Performs parsing, formatting, or computation operations on grammar elements
	 * without maintaining state.
	 *
	 * @param stepDefinition the step definition to search
	 * @param pipeDelimitedString the pipe-delimited string to match
	 * @return IStepParameters matching the string, or null if not found
	 */
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

	/**
	 * Performs parsing, formatting, or computation operations on grammar elements
	 * without maintaining state.
	 *
	 * @param cells the list of cells to convert
	 * @return pipe-delimited string of sorted cell names
	 */
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

	/**
	 * Performs parsing, formatting, or computation operations on grammar elements
	 * without maintaining state.
	 *
	 * @param pipeDelimitedString the string to normalize
	 * @return normalized pipe-delimited string with sorted cells
	 */
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
}
