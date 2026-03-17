package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class SheepDogLoggerFactory {

    private static SheepDogLoggerProvider provider = null;

    public static void setLoggerImplementation(SheepDogLoggerProvider provider) {
        SheepDogLoggerFactory.provider = provider;
    }

    public static Logger getLogger(Class<?> clazz) {
        if (org.slf4j.LoggerFactory.getILoggerFactory() instanceof org.slf4j.helpers.NOPLoggerFactory) {
            if (provider != null) {
                return provider.getLogger(clazz);
            }
        }
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }

}
