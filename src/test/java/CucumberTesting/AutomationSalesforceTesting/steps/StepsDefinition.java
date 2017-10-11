package CucumberTesting.AutomationSalesforceTesting.steps;

import CucumberTesting.AutomationSalesforceTesting.page.*;
import CucumberTesting.AutomationSalesforceTesting.salesforce.*;
import CucumberTesting.AutomationSalesforceTesting.util.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDefinition extends DriverFactory{
	SalesforceAuthentication sfAuth;
	CreateRecordPage createRecPage;
	@Before
	public void setupData(){
		System.out.println("Before Test");
		sfAuth = new SalesforceAuthentication();
		createRecPage = new CreateRecordPage(driver,sfAuth.getBaseUrl());
	}
	
	@Given("^Navigate to account creation page$")
	public void navigateToRecordCreationPage() throws Throwable {
	    createRecPage.navigateToRecordCreationObject("/003");
	}

	@When("^I populate the required fields$")
	public void populateRequiredFields() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^Click create button$")
	public void clickCreateButton() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^New Account is created$")
	public void newAccountIsCreated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@After 
	public void endTest(){
		System.out.println("After Test");
		destroyDriver();
	}
}
