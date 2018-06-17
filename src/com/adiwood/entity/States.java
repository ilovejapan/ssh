package com.adiwood.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * States entity. @author MyEclipse Persistence Tools
 */

public class States implements java.io.Serializable {

	// Fields

	private String sid;
	private Continentss continentss;
	private String sname;
	private Set areases = new HashSet(0);

	// Constructors

	/** default constructor */
	public States() {
	}

	/** minimal constructor */
	public States(String sid, Continentss continentss, String sname) {
		this.sid = sid;
		this.continentss = continentss;
		this.sname = sname;
	}

	/** full constructor */
	public States(String sid, Continentss continentss, String sname, Set areases) {
		this.sid = sid;
		this.continentss = continentss;
		this.sname = sname;
		this.areases = areases;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Continentss getContinentss() {
		return this.continentss;
	}

	public void setContinentss(Continentss continentss) {
		this.continentss = continentss;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set getAreases() {
		return this.areases;
	}

	public void setAreases(Set areases) {
		this.areases = areases;
	}

}