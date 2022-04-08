package com.ca.test.runner;

import io.cucumber.testng.*;
//import io.cucumber.junit.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/com/ca/test/features/"}, glue = {"com/ca/test/steps"})
public class TestRunner{

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void runTests(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws ClassNotFoundException {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[] [] features(ITestContext context) {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }
}
