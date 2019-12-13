package com.newtours.pages;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	@FindBy(name = "passCount")
	private WebElement passengers;
	
	@FindBy(name = "findFlights")
	private WebElement submitBtn;
	
	public void selectPassengers(String noOfPassengers) {
		PageFactory.initElements(getDriver(), this);
		new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(passengers));
		Select select = new Select(passengers);
		select.selectByValue(noOfPassengers);
	}
	
	public void goToFindFlightsPage() {
		this.submitBtn.click();
	}
}
