package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Generated(value = "src/main/resources/com/company/MaintPageLogin.json")
@GraphWalker(value = "shortest_all_paths(edge_coverage(100))", start = "e_StartBrowserwithMaintPage", groups = {
		"default" })
public class MaintPageLoginImpl extends ExecutionContext implements MaintPageLogin {

	public final static Path MODEL_PATH = Paths.get("com/company/MaintPageLogin.json");

	@Override
	public void e_StartBrowserwithMaintPage() {
		System.out.println("Executing:e_StartBrowserwithMaintPage");
		BrowserProxyUtils.setup();
		BrowserProxyUtils.getInstance().get("http://172.19.134.2:9084/maintenance");
		setAttribute("a", true);
	}

	@Override
	public void e_InvalidLogin() {
		System.out.println("Executing:e_InvalidLogin");
		if (BrowserProxyUtils.getInstance().findElements(By.xpath("//*[@id='form:j_idt21']")).size() > 0) {
			LoginInvalid();
		} else {
			BrowserProxyUtils.getWaiter()
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form']/center/a"))).click();
			LoginInvalid();
		}
	}

	@Override
	public void v_successfulLogin() {
		System.out.println("Executing:v_successfulLogin");
		Boolean exp = BrowserProxyUtils.getWaiter().until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath("//*[@id='form:j_idt12_button']/span[2]"), "engineer"));
		System.out.println("TEXT IN THE element is: " + exp);
	}

	@Override
	public void v_LoginPage() {
		System.out.println("Executing:v_LoginPage");
	}

	@Override
	public void e_ValidLogin() {
		System.out.println("Executing:e_ValidLoginCredentials");
		if (BrowserProxyUtils.getInstance().findElements(By.xpath("//*[@id='form:j_idt21']")).size() > 0) {
			LoginValid();
		} else {
			BrowserProxyUtils.getWaiter()
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form']/center/a"))).click();
			LoginValid();
		}

	}

	@Override
	public void v_FailurePage() {
		// TODO Auto-generated method stub
		System.out.println("Executing: v_FailurePage");
//		Boolean exp = BrowserProxyUtils.getWaiter().until(ExpectedConditions.textToBePresentInElementLocated(
//				By.xpath("//*[@id='form:messages']/div/ul/li/span"), "Invalid Username or Password"));
//		System.out.println("TEXT IN THE element is: " + exp);
	}

	@Override
	public void e_Logout() {
		// TODO Auto-generated method stub
		System.out.println("Executing: e_logout");
		WebElement logoutdrop = BrowserProxyUtils.getInstance()
				.findElement(By.xpath("//*[@id='form:j_idt12_menuButton']/span[1]"));
		Actions builder = new Actions(BrowserProxyUtils.getInstance());
		builder.moveToElement(logoutdrop).click().perform();
		BrowserProxyUtils.getWaiter().until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form:j_idt12_menu']/ul/li/a/span[2]")))
				.click();
	}

	public boolean checkLoginPage(By by) {
		try {
			BrowserProxyUtils.getInstance().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void LoginValid() {
		WebElement usrname = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:j_idt21']"));
		WebElement pwd = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:password-entry']"));
		WebElement login = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:j_idt28']/span[2]"));
		usrname.clear();
		usrname.sendKeys("engineer");
		pwd.clear();
		pwd.sendKeys("5*a%U5setW3n");
		login.click();
	}

	public static void LoginInvalid() {
		WebElement usrname = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:j_idt21']"));
		WebElement pwd = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:password-entry']"));
		WebElement login = BrowserProxyUtils.getInstance().findElement(By.xpath("//*[@id='form:j_idt28']/span[2]"));
		usrname.clear();
		usrname.sendKeys("engineer");
		pwd.clear();
		pwd.sendKeys("*a%U5setW3n");
		login.click();
	}

	@Override
	public void e_CloseBrowser() {
		// TODO Auto-generated method stub
		System.out.println("Executing: e_CloseBrowser");
		BrowserProxyUtils.tearDown();

	}

}
