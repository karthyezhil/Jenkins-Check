package zero.security.testing;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import zero.security.common.ReadData;
import zero.security.base.BaseClass;
import zero.security.common.CommonFunctions;
import zero.security.pages.AddPayeePage;
import zero.security.pages.LoginPage;

public class EndtoEndTesting extends BaseClass {

	//validating logIn Functionality
	@Test(groups = { "Sanity"},priority = 1, dataProviderClass = ReadData.class, dataProvider = "logInTestData")
	private void ValidatingLoginFunctionality(String username, String password) throws InterruptedException {
		String failureReason = "";
		String profileDetails = "";
		CommonFunctions.logInSetup(username, password);
		LoginPage l = new LoginPage(webDriver);
		try {
			profileDetails = l.clickOnUserProfile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Profile Details " + profileDetails);
		if (profileDetails.length() == 0) {
			failureReason = l.inValidLoginCredentialsAlert();
		} else {
			l.clickOnLogoutButton();
		}
		Assert.assertEquals(profileDetails.length() > 0, true, failureReason);
	}

	// validating logOut Functionality
	@Test(groups = { "Sanity"},priority = 2, dataProviderClass = ReadData.class, dataProvider = "logOutTestData")
	private void validatingLogoutFunctionality(String username, String password) {
		CommonFunctions.logInSetup(username, password);
		LoginPage l = new LoginPage(webDriver);
		l.clickOnUserProfile();
		l.clickOnLogoutButton();
		webDriver.navigate().back();
		boolean userProfileVisiblity = l.checksVisibleOfUserProfile();
		Assert.assertEquals(userProfileVisiblity, false,
				"Browser is allowing the user to access the pages from the history");
	}

	// Validating forgot password functionality
	@Test(groups = { "Sanity"},priority = 3)
	private void ValidatingForgotPasswordFunctionality() {
		webDriver.get(properties.getProperty("url"));
		webDriver.findElement(By.xpath("//button[@id='signin_button']")).click();
		LoginPage l = new LoginPage(webDriver);
		l.clickOnForgotPasswordButton();
		String actualTitle = webDriver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Zero - Forgotten Password");
	}

	// validating add-payee functionality
	@Test(groups = { "Sanity"},priority = 4, dataProviderClass = ReadData.class, dataProvider = "logOutTestData")
	private void addPayeeValidation(String username, String password) {
		String payeeName = "John";
		CommonFunctions.logInSetup(username, password);
		AddPayeePage addPayee = new AddPayeePage(webDriver);
		addPayee.clickOnOnlineBankingLink();
		addPayee.clickOnAccountActivityLink();
		addPayee.clickOnpayBillsLink();
		addPayee.clickOnAddNewPayeeLink();
		addPayee.setPayeeName(payeeName);
		addPayee.setPayeeAddressField("1, Sun Shine View Beach, England");
		addPayee.setAccountDetailsField("6652791909");
		addPayee.setPayeeDetails("John Abraham");
		addPayee.clickOnAddButton();
		System.out.println(addPayee.getSuccessmessage());
		Assert.assertEquals(addPayee.getSuccessmessage(), "The new payee " + payeeName + " was successfully created.");
	}

}
