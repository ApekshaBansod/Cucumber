package org.StepDefinitions;

import org.POM_Pages.DashBoardPage;
import org.factory.DriverFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class DashBoardStepDef {
	
	private DashBoardPage dpobj = new DashBoardPage(DriverFactory.getDriver());
	
	@Then("Dashboard URL is {string}")
	public void dashboard_url_is(String string) {
	Assert.assertTrue(dpobj.verifyDashboardTitle(), "Dashboard title is not Matched");
	}
	@Then("Dashboard Displays {int} tabs")
	public void dashboard_displays_tabs(Integer Tabs) {
	Assert.assertTrue(dpobj.isTimetrackTabDispalyed(), "TimeTrack is not displayed");
	Assert.assertTrue(dpobj.isTaskTabDispalyed(), "Task Tab is  not displayed");
	Assert.assertTrue(dpobj.isReportTabDispalyed(), "Report is not displayed");
	Assert.assertTrue(dpobj.isUserTabDispalyed(), "UserTab is not displayed");


	
	
	
	
	}
}
