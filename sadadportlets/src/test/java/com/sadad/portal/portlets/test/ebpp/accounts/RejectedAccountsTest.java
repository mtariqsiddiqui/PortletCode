package com.sadad.portal.portlets.test.ebpp.accounts;

import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.microsoft.playwright.Page;
import com.sadad.portal.test.PortalTest;

class RejectedAccountsTest extends PortalTest
{
	private static final String MODULE_NAME = "RejectedAccount_";
	protected static final ResourceBundle MODULE_RESOURCE_PROPERTIES = ResourceBundle.getBundle("com.sadad.portal.ebpp.accounts.RejectedAccount");
	private static final String SCREEN_SHOT_PATH = PORTAL_RESOURCE_PROPERTIES.getString("testing.snapshot.directory") + MODULE_NAME;

	private static final String MODULE_URL = PORTAL_BASE_URL + MODULE_RESOURCE_PROPERTIES.getString("module.url");

	//	@Test
	void accessRejectedAccountTest()
	{
		shouldLoginToPortal();
		
		page.navigate(MODULE_URL, navOptions);
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(SCREEN_SHOT_PATH + getPngPrefix())));

		shouldLogoutFromPortal();
	}
}