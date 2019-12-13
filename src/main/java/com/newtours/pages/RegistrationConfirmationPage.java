package com.newtours.pages;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	
	@FindBy(partialLinkText = "sign-in")
	private WebElement signinLink;
	
	@FindBy(linkText = "Flights")
	private WebElement flightsLink;
	
	public void goToFlightDetailsPage() {
		PageFactory.initElements(getDriver(), this);
		new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(this.signinLink));
		this.flightsLink.click();
	}
	
}
