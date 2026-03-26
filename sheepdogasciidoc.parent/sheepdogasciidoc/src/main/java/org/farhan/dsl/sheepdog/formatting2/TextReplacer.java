package org.farhan.dsl.sheepdog.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.internal.AbstractTextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

@SuppressWarnings("restriction")
public class TextReplacer extends AbstractTextReplacer {

	private String replacement;

	protected TextReplacer(IFormattableDocument document, ITextSegment region, String replacement) {
		super(document, region);
		this.replacement = replacement;
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		context.addReplacement(getRegion().replaceWith(replacement));
		return context;
	}
}
