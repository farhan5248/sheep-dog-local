package org.farhan.dsl.sheepdog.parser.antlr;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.farhan.dsl.sheepdog.parser.antlr.internal.SheepDogLexer;

public class CustomSheepDogParser extends SheepDogParser {

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new SheepDogLexer(stream);
	}
}
