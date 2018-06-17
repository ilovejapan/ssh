package com.adiwood.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Continentss entity. @author MyEclipse Persistence Tools
 */

public class Continentss implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private Set stateses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Continentss() {
	}

	/** minimal constructor */
	public Continentss(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	/** full constructor */
	public Continentss(String cid, String cname, Set stateses) {
		this.cid = cid;
		this.cname = cname;
		this.stateses = stateses;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getStateses() {
		return this.stateses;
	}

	public void setStateses(Set stateses) {
		this.stateses = stateses;
	}

}