package zero.security.common;


import org.openqa.selenium.By;

import zero.security.base.BaseClass;
import zero.security.pages.LoginPage;

public class CommonFunctions extends BaseClass {

	public static void logInSetup(String username, String password) {
		webDriver.get(properties.getProperty("url"));
		webDriver.findElement(By.xpath("//button[@id='signin_button']")).click();
		LoginPage l = new LoginPage(webDriver);
		l.setUsername(username);
		l.setPassword(password);
		l.clickOnSigninButton();
		try {
			String connectionErrorMsg = l.connectionError();
			if (connectionErrorMsg.length() > 0) {
				System.out.println("Connection Error " + connectionErrorMsg + "-- Navigate back");
				webDriver.navigate().back();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
