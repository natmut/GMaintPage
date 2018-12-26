package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Proxy;

public class BrowserProxyUtils {

	private static class WebDriverHolder {
		// Create proxy class object
		private static Proxy p = new Proxy();
		// Create desired Capability object
		private static DesiredCapabilities cap = new DesiredCapabilities();

		static {
			// Set HTTP Port as below
			p.setHttpProxy("r2d2.virtual.lru.gogoair.com:9084");
			// Pass proxy object p
			cap.setCapability(CapabilityType.PROXY, p);
		}

		private static final WebDriver INSTANCE = new ChromeDriver(cap);

	}

	public static void setup() {
		// Create proxy class object

		// Set HTTP Port to 7777
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
	}

	public static WebDriverWait getWaiter() {
		return new WebDriverWait(getInstance(), 10);
	}

	public static WebDriver getInstance() {

		return WebDriverHolder.INSTANCE;
	}

	public static void tearDown() {
		getInstance().quit();
	}

}
