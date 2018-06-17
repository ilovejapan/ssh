package com.adiwood.entity;

/**
 * Areas entity. @author MyEclipse Persistence Tools
 */

public class Areas implements java.io.Serializable {

	// Fields

	private String aid;
	private States states;
	private String aname;

	// Constructors

	/** default constructor */
	public Areas() {
	}

	/** full constructor */
	public Areas(String aid, States states, String aname) {
		this.aid = aid;
		this.states = states;
		this.aname = aname;
	}

	// Property accessors

	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public States getStates() {
		return this.states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

}