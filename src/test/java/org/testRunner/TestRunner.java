package org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		 features="src/test/resources/org/features/LoginPage.feature",
		// features={"@target/failedReRun.txt"},
         glue= {"org/StepDefinitions","org/ApplicationHooks"},
         monochrome=true,   // clear console
         dryRun=false,
         tags ="@smoke",
         plugin = {"pretty",
        		 "junit:target/junit_report/junit_report.xml",
        		 "html:target/html_report/html_report.html",
        		 "json:target/json_report/json_report.json",
        		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		 "rerun:target/failedRerun.txt"// only failed 
}
		)

public class TestRunner { //extends AbstractTestNGCucumberTests{
	
}
