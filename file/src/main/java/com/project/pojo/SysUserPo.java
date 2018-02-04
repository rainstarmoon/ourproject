package com.project.pojo;

import java.io.Serializable;
import java.util.List;

public class SysUserPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer no;
	private String id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Boolean flag;
	private List<CloudDiscPo> cloudDiscs;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<CloudDiscPo> getCloudDiscs() {
		return cloudDiscs;
	}

	public void setCloudDiscs(List<CloudDiscPo> cloudDiscs) {
		this.cloudDiscs = cloudDiscs;
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

}