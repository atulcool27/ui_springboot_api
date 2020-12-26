package com.rps.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tbl_race_users")
public class RaceUsers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String username;
	String password;
	String role;
	String email;
	String phone;
	String account_name;
	String gst_number;
	String state;
	
	boolean isEnabled;
	boolean isCredentialsNonExpired;
	boolean isAccountNonLocked;
	boolean isAccountNonExpired;
	
	
	@PrePersist
	public void preInsert()
	{
		this.isEnabled = true;
		this.isCredentialsNonExpired=true;
		this.isAccountNonLocked = true;
		this.isAccountNonExpired = true;
	}
	
	
	
	
	@Override
	public String toString() {
		return "RaceUsers [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", email=" + email + ", phone=" + phone + ", account_name=" + account_name + ", gst_number="
				+ gst_number + ", state=" + state + ", isEnabled=" + isEnabled + ", isCredentialsNonExpired="
				+ isCredentialsNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isAccountNonExpired="
				+ isAccountNonExpired + "]";
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getGst_number() {
		return gst_number;
	}
	public void setGst_number(String gst_number) {
		this.gst_number = gst_number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
