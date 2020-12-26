package com.rps.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_menu_bar")
public class MenuBar 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String url;
	String role;
	String xpos;
	String ypos;
	
	
	
	@Override
	public String toString() {
		return "MenuBar [id=" + id + ", url=" + url + ", role=" + role + ", xpos=" + xpos + ", ypos=" + ypos + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getXpos() {
		return xpos;
	}
	public void setXpos(String xpos) {
		this.xpos = xpos;
	}
	public String getYpos() {
		return ypos;
	}
	public void setYpos(String ypos) {
		this.ypos = ypos;
	}
	
	

}
