package zero.security.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import zero.security.waittime.WaitMechanism;

public class AddPayeePage extends WaitMechanism {

	WebDriver webDriver;

	public AddPayeePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	By onlineBankingLink = By.xpath("(//*[text()='Online Banking'])[1]");
	
	By accountActivityLink = By.xpath("//span[text()='Account Activity']");
	
	By payBillsLink = By.xpath("//a[text()='Pay Bills']");
	
	By addNewPayeeLink = By.xpath("//a[text()='Add New Payee']");
	
	By payeeNameField = By.xpath("//input[@name='name']");
	
	By payeeAddressField = By.xpath("//*[@name='address']"); 
	
	By accountDetailsField = By.xpath("//input[@name='account']");
	
	By payeeDetailsField = By.xpath("//input[@name='details']");
	
	By addButton = By.xpath("//input[@value='Add']");
	
	By successMsg = By.xpath("//div[@id='alert_container']//div");
	
	public void clickOnOnlineBankingLink() {
		waitMechanism(webDriver, onlineBankingLink);
		webDriver.findElement(onlineBankingLink).click();
	}
	
	public void clickOnAccountActivityLink() {
		waitMechanism(webDriver, accountActivityLink);
		webDriver.findElement(accountActivityLink).click();
	}
	
	public void clickOnpayBillsLink() {
		waitMechanism(webDriver, payBillsLink);
		webDriver.findElement(payBillsLink).click();
	}
	
	public void clickOnAddNewPayeeLink() {
		waitMechanism(webDriver, addNewPayeeLink);
		webDriver.findElement(addNewPayeeLink).click();
	}
	
	public void setPayeeName(String name) {
		waitMechanism(webDriver, payeeNameField);
		webDriver.findElement(payeeNameField).sendKeys(name);
	}
	
	public void setPayeeAddressField(String address) {
		waitMechanism(webDriver, payeeAddressField);
		webDriver.findElement(payeeAddressField).sendKeys(address);
	}
	
	public void setAccountDetailsField(String acccountNumber) {
		waitMechanism(webDriver, accountDetailsField);
		webDriver.findElement(accountDetailsField).sendKeys(acccountNumber);
	}
	
	public void setPayeeDetails(String payeeDetails) {
		waitMechanism(webDriver, payeeDetailsField);
		webDriver.findElement(payeeDetailsField).sendKeys(payeeDetails);
	}
	
	public void clickOnAddButton() {
		waitMechanism(webDriver, addButton);
		webDriver.findElement(addButton).click();
	}
	
	public String getSuccessmessage(){
		waitMechanism(webDriver, successMsg);
		return webDriver.findElement(successMsg).getText();
	}
}
