package com.welcome.model;

import java.io.Serializable;
import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class RepoOptions implements Serializable {

	private static final long serialVersionUID = 5153416630646973582L;
	
	private String ou;
	private String currentRepo;
	private List<String> allRepos;

	public RepoOptions() {
		super();
	}
	
	public RepoOptions(String ou, String currentRepo, List<String> allRepos) {
		super();
		this.ou = ou;
		this.currentRepo = currentRepo;
		this.allRepos = allRepos;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}
	
	public String getCurrentRepo() {
		return currentRepo;
	}

	public void setCurrentRepo(String currentRepo) {
		this.currentRepo = currentRepo;
	}

	public List<String> getAllRepos() {
		return allRepos;
	}

	public void setAllRepos(List<String> allRepos) {
		this.allRepos = allRepos;
	}

}
