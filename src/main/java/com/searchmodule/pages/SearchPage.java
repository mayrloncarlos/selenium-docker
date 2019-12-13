package com.searchmodule.pages;

import static com.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriverWait wait = new WebDriverWait(getDriver(), 15);

	@FindBy(id="search_form_input_homepage")
	private WebElement searchTxt;
	
	@FindBy(id = "search_button_homepage")
	private WebElement searchBtn;
	
	@FindBy(linkText = "Videos")
	private WebElement videosLink;
	
	@FindBy(className= "tile--vid")
	private List<WebElement> allVideos;
	
	
	public void goTo() {
		getDriver().get("https://duckduckgo.com/");
		PageFactory.initElements(getDriver(), this);
	}
	
	public void doSearch(String keyword) {
		wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
		this.searchTxt.sendKeys(keyword);
		this.searchBtn.click();
	}
	
	public void goToVideos() {
		wait.until(ExpectedConditions.visibilityOf(this.videosLink));
		this.videosLink.click();
	}
	
	public int getResult() {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("tile--vid"), 0));
		System.out.println(this.allVideos.size());
		return this.allVideos.size();
	}
}
