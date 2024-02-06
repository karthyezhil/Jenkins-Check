package zero.security.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import zero.security.waittime.WaitMechanism;

public class LoginPage {

	WebDriver webDriver;

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	By username = By.xpath("//input[@id='user_login']");

	By password = By.xpath("//input[@id='user_password']");

	By signInButton = By.xpath("//input[@type='submit']");

	By connectionError = By.xpath("(//*[contains(text(),'This site can’t')])[1]");

	By userDetails = By.xpath("(//a[@class='dropdown-toggle'])[2]");

	By userProfile = By.xpath("//*[text()='My Profile']");

	By userprofileDropDownMenu = By.xpath("(//ul[@class='dropdown-menu'])[2]");

	By logoutButton = By.xpath("//*[text()='Logout']");

	By loginAlertMsg = By.xpath("//div[@class='alert alert-error']");

	By forgetPasswordButton = By.xpath("//a[text()='Forgot your password ?']");

	public void setUsername(String uname) {
		webDriver.findElement(username).sendKeys(uname);
	}

	public void setPassword(String pwd) {
		webDriver.findElement(password).sendKeys(pwd);
	}

	public void clickOnSigninButton() {
		webDriver.findElement(signInButton).click();
	}

	public String connectionError() {
		return webDriver.findElement(connectionError).getText();
	}

	public String clickOnUserProfile() {
		webDriver.findElement(userDetails).click();
		return webDriver.findElement(userProfile).getText();
	}

	public String inValidLoginCredentialsAlert() {
		return webDriver.findElement(loginAlertMsg).getText();
	}

	public void clickOnLogoutButton() {
		webDriver.findElement(logoutButton).click();
	}

	public void clickOnForgotPasswordButton() {
		webDriver.findElement(forgetPasswordButton).click();
	}

	public boolean checksVisibleOfUserProfile() {
		try {
			webDriver.findElement(userDetails).isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
