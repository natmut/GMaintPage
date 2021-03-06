package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.net.www.content.text.plain;

import javax.ws.rs.OPTIONS;

import org.openqa.selenium.Proxy;

public class Vlan11ProxyUtils {

	private static class WebDriverHolder {
		// Create proxy class object
				private static Proxy p = new Proxy();
				// Create desired Capability object
				private static DesiredCapabilities cap = new DesiredCapabilities();

				static {
					// Set HTTP Port as below
					p.setHttpProxy("obiwan.virtual.lru.gogoair.com:2301");
					p.setSslProxy("obiwan.virtual.lru.gogoair.com:2301");
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
		return new WebDriverWait(getInstance(), 25);
	}

	public static WebDriver getInstance() {

		return WebDriverHolder.INSTANCE;
	}

	public static void tearDown() {
		getInstance().quit();
	}

}
