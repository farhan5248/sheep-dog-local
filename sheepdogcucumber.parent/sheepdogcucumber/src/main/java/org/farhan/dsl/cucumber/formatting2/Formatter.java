package org.farhan.dsl.cucumber.formatting2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

public class Formatter {

	protected String indent = " ";
	protected int indentCnt = 0;
	// isLast has to be static for now for the Cell code to know if it
	// belongs to the last Row
	protected static boolean isLast;
	protected static boolean isFirst;
	protected boolean isLastEOLDouble = true;

	protected void isLast(boolean isLast) {
		Formatter.isLast = isLast;
	}

	protected void isFirst(boolean isFirst) {
		Formatter.isFirst = isFirst;
	}

	protected void isLastEOLDouble(boolean isEOLDouble) {
		this.isLastEOLDouble = isEOLDouble;
	}

	protected void setIndent(int indentCnt) {
		this.indentCnt = indentCnt;
	}

	protected String getIndent() {
		return indent.repeat(indentCnt);
	}

	@SuppressWarnings("rawtypes")
	protected boolean isLastElement(EObject o, EList l) {
		int lastIndex = l.size() - 1;
		return o.equals(l.get(lastIndex));
	}

	@SuppressWarnings("rawtypes")
	protected boolean isFirstElement(EObject o, EList l) {
		int firstIndex = 0;
		return o.equals(l.get(firstIndex));
	}

	protected void replace(IFormattableDocument doc, ISemanticRegion iSR, String replacement) {
		doc.addReplacer(new TextReplacer(doc, iSR, replacement));
	}

	// This is an example of how to access a keyword which is something between ''
	// in the xtext file
	protected void formatKeyword(ISemanticRegion iSR, IFormattableDocument doc) {
		doc.prepend(iSR, it -> it.noSpace());
		doc.append(iSR, it -> it.noSpace());
		replace(doc, iSR, getIndent() + iSR.getText() + " ");
	}

	protected void formatPhraseRuleCall(ISemanticRegion iSR, IFormattableDocument doc) {
		doc.append(iSR, it -> it.noSpace());
	}

	protected void formatEOL1RuleCall(ISemanticRegion iSR, IFormattableDocument doc) {
		replace(doc, iSR, "\n");
	}

	protected void formatEOL2RuleCall(ISemanticRegion iSR, IFormattableDocument doc) {
		replace(doc, iSR, "\n\n");
	}

	protected void formatEOL12RuleCall(ISemanticRegion iSR, IFormattableDocument doc) {

		if (isLast && isLastEOLDouble) {
			formatEOL2RuleCall(iSR, doc);
		} else {
			formatEOL1RuleCall(iSR, doc);
		}
	}
}
