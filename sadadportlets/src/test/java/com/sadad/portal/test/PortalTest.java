package com.sadad.portal.test;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PortalTest
{
	// Shared between all tests in this class.
	static Playwright playwright;
	static Browser browser;
	protected static NavigateOptions navOptions = new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE);

	// For management and namgin convention purpose
	protected static final ResourceBundle PORTAL_RESOURCE_PROPERTIES = ResourceBundle.getBundle("com.sadad.portal.SadadPortal");
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
	protected static final String PORTAL_BASE_URL = PORTAL_RESOURCE_PROPERTIES.getString("portal.base.url");

	// New instance for each test method.
	protected BrowserContext context;
	protected Page page;

	@BeforeAll
	static void launchBrowser()
	{
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//				.setExecutablePath(Paths.get("C:\\Program Files\\Mozilla Firefox\\firefox.exe"))
				.setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"))
//				.setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"))
				.setSlowMo(100)
				.setHeadless(false)
				);
	}

	@AfterAll
	static void closeBrowser()
	{
		playwright.close();
	}

	@BeforeEach
	void createContextAndPage()
	{
		context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
		page = context.newPage();
	}

	@AfterEach
	void closeContext()
	{
		context.close();
	}
	
	protected void shouldLoginToPortal()
	{
		// Navigate to Login Page
		page.navigate(PORTAL_BASE_URL, navOptions);
		// Locate user id input field, provide username from resource bundle
		page.locator("input[id='wps.portlets.userid']").fill(PORTAL_RESOURCE_PROPERTIES.getString("portal.user.id"));
		// Locate password field, provide password from resource bundle
		page.locator("input[id='password']").fill(PORTAL_RESOURCE_PROPERTIES.getString("portal.user.password"));
		// Locate login button and click
		page.locator("input[id='login.button.login']").click();
	}
	
	protected void shouldLogoutFromPortal()
	{
		// Locate portal logout link and click 
		page.locator("a[id='portalLogoutLink']").click();
	}
	
	protected String getPngPrefix()
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return sdf.format(timestamp) + ".png";
	}
}