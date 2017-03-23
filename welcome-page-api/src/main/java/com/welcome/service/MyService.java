package com.welcome.service;

import org.jboss.errai.bus.server.annotations.Remote;

import com.welcome.model.RepoOptions;

@Remote
public interface MyService {

	void prepare(final RepoOptions repoOptions);
	
	void saveRepoChange(final String currentRepo, final String repoChangeFrom);

}
