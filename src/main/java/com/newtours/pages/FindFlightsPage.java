package com.newtours.pages;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.DriverFactory;

public class FindFlightsPage {
	
	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
	
	@FindBy(name = "reserveFlights")
	private WebElement firstSubmitBtn;
	
	@FindBy(name = "buyFlights")
	private WebElement secondSubmintBtn;
	
	public void submitFindFlightPage() {
		PageFactory.initElements(getDriver(), this);
		wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmitBtn));
		this.firstSubmitBtn.click();;
	}
	
	public void goToFlightConfirmationPage() {
		wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmintBtn));
		this.secondSubmintBtn.click();
	}
}
