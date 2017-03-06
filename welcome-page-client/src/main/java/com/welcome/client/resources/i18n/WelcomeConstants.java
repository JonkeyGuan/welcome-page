package com.welcome.client.resources.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;

public interface WelcomeConstants extends Messages {

	WelcomeConstants INSTANCE = GWT.create(WelcomeConstants.class);

	String welcomePerspectiveName();

}