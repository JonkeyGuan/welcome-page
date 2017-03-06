package com.welcome.client.screens;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.TextBox;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.mvp.impl.DefaultPlaceRequest;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

@Dependent
public class WelcomeView extends Composite implements WelcomePresenter.View {

	interface WelcomeViewBinder extends UiBinder<Widget, WelcomeView> {

	}

	private static WelcomeViewBinder uiBinder = GWT.create(WelcomeViewBinder.class);

	@UiField
	TextBox termTextBox;

	private WelcomePresenter presenter;

	@Inject
	private PlaceManager placeManager;

	@Override
	public void init(WelcomePresenter presenter) {
		this.presenter = presenter;
	}

	@PostConstruct
	public void init() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setTerm(String term) {
		termTextBox.setText(term);
	}

	@UiHandler("search")
	public void onSearchClick(final ClickEvent e) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("repo", "the repo");
		placeManager.goTo(new DefaultPlaceRequest("AuthoringPerspective", parameters));
	}

}