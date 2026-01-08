package org.farhan.dsl.cucumber.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.farhan.dsl.cucumber.parser.antlr.internal.CucumberLexer;

public class CustomCucumberParser extends CucumberParser {

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new CucumberLexer(stream);
	}
}
