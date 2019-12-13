package com.newtours.pages;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	@FindBy(name = "firstName")
	private WebElement firstNameTxt;
	
	@FindBy(name = "lastName")
	private WebElement lastNameTxt;
	
	@FindBy(name = "email")
	private WebElement userNameTxt;
	
	@FindBy(name = "password")
	private WebElement passwordTxt;
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordTxt;
	
	@FindBy(name = "register")
	private WebElement submitBtn;
	
	public void goTo() {
		getDriver().get("http://newtours.demoaut.com/mercuryregister.php");
		PageFactory.initElements(getDriver(), this);
		new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(this.firstNameTxt));
	}
	
	public void enterUserDetails(String firstName, String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		this.lastNameTxt.sendKeys(lastName);
	}
	
	public void enterUserCredentials(String userName, String password) {
		this.userNameTxt.sendKeys(userName);
		this.passwordTxt.sendKeys(password);
		this.confirmPasswordTxt.sendKeys(password);
	}
	
	public void submit() {
		this.submitBtn.click();
	}
}
