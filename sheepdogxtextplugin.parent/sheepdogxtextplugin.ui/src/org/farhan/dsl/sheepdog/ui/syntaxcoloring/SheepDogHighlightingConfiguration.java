package org.farhan.dsl.sheepdog.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class SheepDogHighlightingConfiguration implements IHighlightingConfiguration {

	public static final String DEFAULT_ID = "default";
	public static final String WORD_ID = "string";
	public static final String COMMENT_ID = "comment";
	public static final String STATEMENT_ID = "statement";
	public static final String TODO_ID = "todo";
	public static final String TAG_ID = "tag";
	public static final String KEYWORD_LVL_1 = "keywordobj";
	public static final String KEYWORD_LVL_2 = "keywordfse";
	public static final String KEYWORD_LVL_3 = "keywordgwt";
	public static final String DOC_ID = "text";
	public static final String TBL_ID = "table";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(WORD_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());

		acceptor.acceptDefaultHighlighting(STATEMENT_ID, "Description", statementTextStyle());
		acceptor.acceptDefaultHighlighting(TODO_ID, "Todo", todoTextStyle());
		acceptor.acceptDefaultHighlighting(TAG_ID, "Tag", tagTextStyle());

		acceptor.acceptDefaultHighlighting(KEYWORD_LVL_1, "Level 1", keywordLevel1TextStyle());
		acceptor.acceptDefaultHighlighting(KEYWORD_LVL_2, "Level 2", keywordLevel2TextStyle());
		acceptor.acceptDefaultHighlighting(KEYWORD_LVL_3, "Level 3", keywordLevel3TextStyle());

		acceptor.acceptDefaultHighlighting(DOC_ID, "Text", documentTextStyle());
		acceptor.acceptDefaultHighlighting(TBL_ID, "Table", tableTextStyle());
	}

	private TextStyle todoTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 192, 192));
		textStyle.setStyle(SWT.BOLD);
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	private TextStyle statementTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(64, 64, 64));
		return textStyle;
	}

	public static TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}

	public static TextStyle documentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 64, 0));
		return textStyle;
	}

	public static TextStyle keywordLevel1TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(64, 0, 64));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public static TextStyle keywordLevel2TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 0, 128));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public static TextStyle keywordLevel3TextStyle() {
		TextStyle textStyle = keywordLevel2TextStyle().copy();
		textStyle.setColor(new RGB(128, 0, 64));
		return textStyle;
	}

	public static TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255, 128, 0));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	public static TextStyle tagTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255, 201, 14));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public static TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(64, 64, 64));
		return textStyle;
	}

	public static TextStyle tableTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(163, 73, 164));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

}
