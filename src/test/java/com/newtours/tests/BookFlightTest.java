package com.newtours.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.newtours.pages.FindFlightsPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

public class BookFlightTest extends BaseTest {
	
	@Test
	public void registrationPage() {
		RegistrationPage registrationPage = new RegistrationPage();
		registrationPage.goTo();
		registrationPage.enterUserDetails("selenium", "docker");
		registrationPage.enterUserCredentials("selenium", "docker");
		registrationPage.submit();
	}
	
	@Test(dependsOnMethods = "registrationPage")
	public void registrationConfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage();
		registrationConfirmationPage.goToFlightDetailsPage();
	}
	
	@Test(dependsOnMethods = "registrationConfirmationPage")
	@Parameters({"noOfPassengers"})
	public void flightDetailsPage(String noOfPassengers) {
		FlightDetailsPage flightDetailsPage = new FlightDetailsPage();
		flightDetailsPage.selectPassengers(noOfPassengers);
		flightDetailsPage.goToFindFlightsPage();
	}
	
	@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightsPage findFlightsPage = new FindFlightsPage();
		findFlightsPage.submitFindFlightPage();
		findFlightsPage.goToFlightConfirmationPage();		
	}
	
	@Test(dependsOnMethods = "findFlightPage")
	@Parameters({"expectedPrice"})
	public void flightConfirmationPage(String expectedPrice) {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage();
		String actualPrice = flightConfirmationPage.getPrice();	
		
		assertEquals(actualPrice, expectedPrice);
	}
}
