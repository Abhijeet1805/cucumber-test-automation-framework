package stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import utilities.DriverUtil;
import utilities.PropertyUtil;
import utilities.WaitUtil;

public class Login {
	private WebDriver driver;
	private WebDriverWait wait;

	@Given("^User is present on login page$")
	public void launchUrl() {
		// Expected page title
		final String expectedTitle = "Facebook – log in or sign up";

		// instance variables
		driver = DriverUtil.getDriver();
		wait = WaitUtil.getWait();

		// launch web url and maximize browser
		driver.get(PropertyUtil.getPropertyValue("applicationUrl"));
//		driver.manage().window().maximize();
		
		// read title
		wait.until(ExpectedConditions.titleIs(expectedTitle));

		PageFactory.initElements(driver, LoginPage.class);
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enterUserNameAndPassword(String username, String password) {
		WaitUtil.presenceOfElement(LoginPage.userName);
		LoginPage.enterUserName(username);
		LoginPage.enterPassword(password);
	}

	@When("^User clicks on log in button$")
	public void clickLoginBtn() {
		WaitUtil.presenceOfElement(LoginPage.logInBtn);
		LoginPage.clickLogInBtn();
	}

//	@Then("^User should be logged in$")
//	public void user_should_be_logged_in() {
//		// Write code here that turns the phrase above into concrete actions
//		// wait till element with id=pageTitle is present;
//		WaitUtil.presenceOfElement(element);
//		String title = driver.getTitle();
//		Assert.assertEquals("Facebook", title);
//	}

}