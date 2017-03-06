package com.welcome.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.welcome.client.resources.css.WelcomeCss;

public interface WelcomeResources extends ClientBundle {

	public WelcomeResources INSTANCE = GWT.create(WelcomeResources.class);

	@Source("css/Welcome.css")
	public WelcomeCss mainCss();

}
