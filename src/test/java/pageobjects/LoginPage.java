package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	@FindBy(id="email")
	public static WebElement userName;
	@FindBy(id="pass")
	public static WebElement password;
	@FindBy(id="loginbutton")
	public static WebElement logInBtn;
	
	public static void enterUserName(String email) {
		userName.sendKeys(email);
	}
	
	public static void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}
	
	public static void clickLogInBtn() {
		logInBtn.click();
	}
}
