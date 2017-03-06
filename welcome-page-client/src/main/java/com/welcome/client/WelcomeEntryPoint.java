package com.welcome.client;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;

import com.welcome.client.resources.WelcomeResources;

@EntryPoint
public class WelcomeEntryPoint {

	@AfterInitialization
	public void startApp() {
		WelcomeResources.INSTANCE.mainCss().ensureInjected();
	}
}
