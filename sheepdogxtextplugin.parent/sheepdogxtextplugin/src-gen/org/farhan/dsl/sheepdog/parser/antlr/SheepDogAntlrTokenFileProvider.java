/*
 * generated by Xtext 2.39.0.M1
 */
package org.farhan.dsl.sheepdog.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SheepDogAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/farhan/dsl/sheepdog/parser/antlr/internal/InternalSheepDog.tokens");
	}
}
