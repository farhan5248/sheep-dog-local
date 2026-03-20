package org.farhan.common;

import io.cucumber.java.Before;
import org.farhan.impl.TestObjectSheepDogImpl;

public class TestHooks {

    @Before
    public void resetTestProject() throws Exception {
        TestObject.reset();
        TestObjectSheepDogImpl.reset();
    }
}
