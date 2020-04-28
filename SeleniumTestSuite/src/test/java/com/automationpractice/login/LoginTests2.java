package com.automationpractice.login;

import org.testng.annotations.Test;

import net.timentraining.core.TestBase;







public class LoginTests2 extends TestBase{
	
	
	@Test
	public void Login_with_invalid_userid() {
		
		
		
		webui.launch("http://www.automationpractice.com");
		webui.click_element_by_className("login");

		
	}

	
}
