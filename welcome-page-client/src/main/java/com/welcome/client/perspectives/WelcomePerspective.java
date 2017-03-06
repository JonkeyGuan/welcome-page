package com.welcome.client.perspectives;

import javax.enterprise.context.ApplicationScoped;

import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelPresenter;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.workbench.model.impl.PerspectiveDefinitionImpl;

import com.welcome.client.resources.i18n.WelcomeConstants;

@ApplicationScoped
@WorkbenchPerspective(identifier = "WelcomePerspective", isDefault = true)
public class WelcomePerspective {

	@Perspective
	public PerspectiveDefinition getPerspective() {
		final PerspectiveDefinition p = new PerspectiveDefinitionImpl(StaticWorkbenchPanelPresenter.class.getName());
		p.setName(WelcomeConstants.INSTANCE.welcomePerspectiveName());
		p.getRoot()
				.addPart(new PartDefinitionImpl(new DefaultPlaceRequest("WelcomeScreen")));
		return p;
	}

}
