package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Generated;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.machine.SimpleMachine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Generated(value = "src/main/resources/com/company/Vlan11.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowsing", groups = { "default" })
public class Vlan11Impl extends ExecutionContext implements Vlan11 {

	public final static Path MODEL_PATH = Paths.get("com/company/Vlan11.json");

	@Override
	public void v_UserAuthenticated() {
		System.out.println("Executing:v_UserAuthenticated");
	}

	@Override
	public void v_ClosedSession() {
		System.out.println("Executing:v_ClosedSession");
	}

	@Override
	public void e_CloseBrowser() {
		System.out.println("Executing:e_CloseBrowser");
		Vlan11ProxyUtils.tearDown();
	}

	@Override
	public void v_SplashPage() {
		System.out.println("Executing:v_SplashPage");
	}

	@Override
	public void e_StartBrowsing() {
		System.out.println("Executing:e_StartBrowsing");
		Vlan11ProxyUtils.setup();
		Vlan11ProxyUtils.getInstance().get("http://www.cnn.com");
	}

	@Override
	public void v_URLOpened() {
		System.out.println("Executing:v_URLOpened");
	}

	@Override
	public void e_Open_nonWhitelistURL() {
		System.out.println("Executing:e_Open_nonWhitelistURL");
	}

	@Override
	public void e_Authenticate() {
		System.out.println("Executing:e_Authenticate");
		//user having valid userID-Pwd trying to login/Authenticate.
		Vlan11ProxyUtils.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gogo-ifc']/div/section/div/section[1]/div/a"))).click();
		//Already registered user with valid pass -- authentication.
		Vlan11ProxyUtils.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginEmail']"))).sendKeys("teseter1@gmail.com");
		Vlan11ProxyUtils.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginPassword']"))).sendKeys("123456");
		Vlan11ProxyUtils.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sign-in-form']/div[6]/button"))).click();
		System.out.println("User is successfully authenticated.......!!!!!");
	}

	@Test()
	public void runModelBasedTest() {
		Vertex v_SplashPage = new Vertex().setName("v_SplashPage").setId("n1");
		Vertex v_UserAuthenticated = new Vertex().setName("v_UserAuthenticated").setId("n2");
		Vertex v_URLOpened = new Vertex().setName("v_URLOpened").setId("n3");
		Vertex v_ClosedSession = new Vertex().setName("v_ClosedSession").setId("n4");
		Model model = new Model();
		model.addEdge(new Edge().setTargetVertex(v_SplashPage).setName("e_StartBrowsing").setId("e0"));
		model.addEdge(new Edge().setSourceVertex(v_SplashPage).setTargetVertex(v_UserAuthenticated)
				.setName("e_Authenticate").setId("e1"));
		model.addEdge(new Edge().setSourceVertex(v_UserAuthenticated).setTargetVertex(v_URLOpened)
				.setName("e_Open_nonWhitelistURL").setId("e2"));
		model.addEdge(new Edge().setSourceVertex(v_URLOpened).setTargetVertex(v_ClosedSession).setName("e_CloseBrowser")
				.setId("e3"));
		Context context = this;
		context.setModel(model.build()).setPathGenerator(new RandomPath(new EdgeCoverage(100)));
		context.setNextElement(context.getModel().findElements("e_StartBrowsing").get(0));
		Machine machine = new SimpleMachine(context);
		while (machine.hasNextStep()) {
			machine.getNextStep();
			System.out.println(context.getCurrentElement().getName());
		}
	}

}
