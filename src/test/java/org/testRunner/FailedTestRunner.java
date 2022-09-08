package org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
         features={"@target/failedReRun.txt"},
         glue= {"org/StepDefinitions","org/ApplicationHooks"},
         monochrome=true,   // clear console
         dryRun=false,
         
         plugin = {"pretty",
		 "junit:target/junit_report/junit_report.xml",
		 "html:target/html_report/html_report.html",
		 "json:target/json_report/json_report.json",
		 
		 
		 //"rerun:target/FailedReRun.txt"   
        		 "rerun:target/failedRerun.txt"// only failed 
   }
   
   )
public class FailedTestRunner {
	

}
