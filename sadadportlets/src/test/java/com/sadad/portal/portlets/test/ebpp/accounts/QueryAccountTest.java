package com.sadad.portal.portlets.test.ebpp.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.sadad.portal.test.PortalTest;

class QueryAccountTest extends PortalTest
{
	private static final String MODULE_NAME = "QueryAccount_";
	protected static final ResourceBundle MODULE_RESOURCE_PROPERTIES = ResourceBundle.getBundle("com.sadad.portal.ebpp.accounts.QueryAccount");
	private static final String SCREEN_SHOT_PATH = PORTAL_RESOURCE_PROPERTIES.getString("testing.snapshot.directory") + MODULE_NAME;
	private static final String MODULE_URL = PORTAL_BASE_URL + MODULE_RESOURCE_PROPERTIES.getString("module.url");

	@Test
	@Order(1)
	@DisplayName("Account Query Testing.")
	void accessAccountQueryTest()
	{
		shouldLoginToPortal();

		page.navigate(MODULE_URL, navOptions);

		Locator container_1 = page.locator("div[id='container_1']");
		Locator container_2 = page.locator("div[id='container_2']");

		assertTrue(container_1.innerHTML().length() > 0, "Portlet form loaded successfully.");
		assertEquals(0, container_2.innerHTML().length(), "Container 2 is empty, as expected.");

		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(SCREEN_SHOT_PATH + getPngPrefix())));

		shouldLogoutFromPortal();
	}

	@Test
	@Order(2)
	@DisplayName("Positive Account Query Test")
	void positiveAccountQueryTest()
	{
		shouldLoginToPortal();

		page.navigate(MODULE_URL, navOptions);

		Locator container_1 = page.locator("div[id='container_1']");
		Locator container_2 = page.locator("div[id='container_2']");
		Locator ajaxLoader = page.locator("div[id='ajaxLoader']");

		// Provide input to fields, and click Submit
		container_1.locator("select[id='cmbPartnerKey']").selectOption("001");
		container_1.locator("input[id='txtAccountNumber']").type("804_A01");
		container_1.locator("input[type='submit']").click();
		
		ajaxLoader.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
		
		assertTrue(container_2.innerHTML().length() > 0, "Container 2 is populated with result.");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(SCREEN_SHOT_PATH + getPngPrefix())));
		
		shouldLogoutFromPortal();
	}

//	@Test
//	void negativeAccountQueryTest()
//	{
//		Locator container_1 = page.locator("div[id='container_1']");
//		Locator container_2 = page.locator("div[id='container_2']");
//	}

}