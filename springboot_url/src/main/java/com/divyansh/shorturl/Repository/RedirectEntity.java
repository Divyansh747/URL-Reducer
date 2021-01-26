package com.divyansh.shorturl.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RedirectEntity {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(unique = true, nullable = false )
	private Long Id;
	
	@NaturalId
	@Column(unique = true, nullable = false)
	private String alias;	
	
	@Column(nullable = false)
	private String url;
	
	public RedirectEntity() {
		super();
	}

	public RedirectEntity(final String alias, final String url) {
		super();
		this.alias = alias;
		this.url = url;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RedirectEntity [Id=" + Id + ", alias=" + alias + ", url=" + url + "]";
	}
	
	
	
}

