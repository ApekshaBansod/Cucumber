package org.StepDefinitions;

import org.POM_Pages.DashBoardPage;
import org.factory.DriverFactory;
import io.cucumber.java.en.*;

public class CustomerStepDef {
	private DashBoardPage dpobj = new DashBoardPage(DriverFactory.getDriver());

	@Given("User is on login page")
	public void user_is_on_login_page() {
	}

	@Given("user enters username")
	public void user_enters_username() {
	}

	@When("User enters password")
	public void user_enters_password() {
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	}

	@When("Dashboard displays {int} tabs")
	public void dashboard_displays_tabs(Integer int1) {

	}

	@When("User clicks on {string} tab")
	public void user_clicks_on_tab(String string) {
		;
	}

	@Then("Task page is Displayed")
	public void task_page_is_displayed() {

	}

	@When("user clicks on new Add new Customer")
	public void user_clicks_on_new_add_new_customer() {

	}

	@Then("Add Customer page is displayed")
	public void add_customer_page_is_displayed() {

	}

	@Then("Verify Add Customer page")
	public void verify_add_customer_page() {

	}

	@When("user enters new customer details")
	public void user_enters_new_customer_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("clicks on create customer button")
	public void clicks_on_create_customer_button() {

	}

	@Then("Verify notification for newly created Customer")
	public void verify_notification_for_newly_created_customer() {

	}

	@Then("Created customer is displayed in customer & Project section")
	public void created_customer_is_displayed_in_customer_project_section() {

	}
}