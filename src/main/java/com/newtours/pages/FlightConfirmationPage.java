package com.newtours.pages;

import static com.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	@FindBy(xpath = "//font[contains(text(),'Flight')]")
	private WebElement flightConfirmationHeader;
	
	@FindBy(xpath = "//font[contains(text(), 'USD')]")
	private List<WebElement> prices;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffLink;
	
	public String getPrice() {
		PageFactory.initElements(getDriver(), this);
		new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
		System.out.println(this.flightConfirmationHeader.getText());
		System.out.println(this.prices.get(1).getText());
		String price = this.prices.get(1).getText();
		this.signOffLink.click();
		return price;
	}
}
