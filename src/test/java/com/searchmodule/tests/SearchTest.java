package com.searchmodule.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.searchmodule.pages.SearchPage;

public class SearchTest extends BaseTest {
	
	@Test
	@Parameters({"keyword"})
	public void search(String keyword) {
		SearchPage searchPage = new SearchPage();
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();
		
		assertTrue(size > 0);
	}

}
