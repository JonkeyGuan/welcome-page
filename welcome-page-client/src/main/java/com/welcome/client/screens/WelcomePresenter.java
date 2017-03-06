package com.welcome.client.screens;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;

@Dependent
@WorkbenchScreen(identifier = "WelcomeScreen")
public class WelcomePresenter {

	public interface View extends UberView<WelcomePresenter> {
		void setTerm(final String term);
	}

	@Inject
	private View view;

	@WorkbenchPartTitle
	public String getTitle() {
		return "WelcomeScreen";
	}

	@WorkbenchPartView
	public UberView<WelcomePresenter> getView() {
		return view;
	}

}