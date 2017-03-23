package com.welcome.backend.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.organizationalunit.OrganizationalUnitService;
import org.guvnor.structure.repositories.Repository;
import org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations;
import org.guvnor.structure.repositories.RepositoryService;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.bus.server.api.RpcContext;
import org.jboss.errai.security.shared.api.identity.User;
import org.uberfire.ext.security.management.service.GroupManagerServiceImpl;

import com.welcome.model.RepoOptions;
import com.welcome.service.MyService;

@Service
@ApplicationScoped
public class MyServiceImpl implements MyService {

	@Inject
	private OrganizationalUnitService organizationalUnitService;

	@Inject
	private RepositoryService repositoryService;

	@Inject
	private GroupManagerServiceImpl groupManagerSerivce;

	@Inject
	private User identity;

	@Override
	public void prepare(RepoOptions options) {
		String ouName = options.getOu();
		List<String> allRepos = options.getAllRepos();

		OrganizationalUnit ou = organizationalUnitService.getOrganizationalUnit(ouName);
		if (ou == null) {
			ou = organizationalUnitService.createOrganizationalUnit(ouName, "", "");
		}

		if (ou != null && allRepos != null) {
			Collection<Repository> existingRepos = ou.getRepositories();
			for (String repoName : allRepos) {
				boolean found = false;
				for (Repository repo : existingRepos) {
					if (repo.getAlias().equals(repoName)) {
						found = true;
					}
				}

				if (!found) {
					final RepositoryEnvironmentConfigurations configurations = new RepositoryEnvironmentConfigurations();
					configurations.setManaged(false);
					Repository repo = repositoryService.createRepository("git", repoName, configurations);
					String groupName = repoName;
//					repositoryService.addGroup(repo, groupName);
					organizationalUnitService.addRepository(ou, repo);

					groupManagerSerivce.assignUsers(groupName, Arrays.asList(identity.getIdentifier()));
				}
			}
		}
	}
	
	@Override
	public void saveRepoChange(final String currentRepo, final String repoChangeFrom){
		HttpSession session = RpcContext.getHttpSession();
		session.setAttribute("currentRepo", currentRepo);
		session.setAttribute("repoChangeFrom", repoChangeFrom);
	}
}
