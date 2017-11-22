package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(id="email")
	WebElement userName;
	@FindBy(id="pass")
	WebElement password;
	@FindBy(id="u_0_2")
	WebElement logInBtn;
	
	public void enterUserName(String email) {
		userName.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLogInBtn() {
		logInBtn.submit();
	}
}
