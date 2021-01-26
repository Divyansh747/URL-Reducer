package com.divyansh.shorturl.Request;

import javax.validation.constraints.NotNull;

public class RedirectRequest {
	
	@NotNull
	private String alias;
	@NotNull
	private String url;
	
	public RedirectRequest(final String alias, final String url) {
		super();
		this.alias = alias;
		this.url = url;
	}

	public String getAlias() {
		return alias;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "RedirectRequest [alias=" + alias + ", url=" + url + "]";
	}	
	
}
