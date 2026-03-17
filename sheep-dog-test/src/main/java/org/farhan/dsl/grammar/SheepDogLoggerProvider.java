package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public interface SheepDogLoggerProvider {

    public Logger getLogger(Class<?> clazz);

}
