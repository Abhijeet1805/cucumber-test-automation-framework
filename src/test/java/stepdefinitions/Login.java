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
	private LoginPage loginPage;
	
	@Given("^User is present on login page$")
	public void user_is_present_on_login_page() {
		// Expected page title
		final String expectedTitle = "Facebook – log in or sign up";
		
		// instance variables
		this.driver = DriverUtil.getDriver();
		this.wait = WaitUtil.getWait();
		
		this.driver.get(PropertyUtil.getPropertyValue("applicationUrl"));
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		// initialize page factory
		this.loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String email) {
		WaitUtil.presenceOfElementById(wait, "email");
		loginPage.enterUserName(email);
	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
//		waitUtil.presenceOfElementById(wait, "pass");
		loginPage.enterPassword(password);
	}
	
	@When("^User clicks on log in button$")
	public void user_clicks_on_log_in_button() {
	   loginPage.clickLogInBtn();
	}

//	@Then("^User should be logged in$")
//	public void user_should_be_logged_in() {
//		// Write code here that turns the phrase above into concrete actions
//		
//		WaitUtil.presenceOfElementById(wait, "pageTitle");
//		String title = driver.getTitle();
//		Assert.assertEquals("Facebook", title);
//	}

}