package com.project.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class FilePo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CloudDiscPo cloudDisc;
	private FilePo file;
	private String name;
	private String path;
	private Integer type;
	private Double size;
	private Timestamp createDate;
	private SysUserPo createUser;
	private Timestamp updateDate;
	private SysUserPo updateUser;
	private Boolean flag;
	private List<FileCommunicatePo> fileCommunicates;
	private List<FilePo> files;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CloudDiscPo getCloudDisc() {
		return cloudDisc;
	}

	public void setCloudDisc(CloudDiscPo cloudDisc) {
		this.cloudDisc = cloudDisc;
	}

	public FilePo getFile() {
		return file;
	}

	public void setFile(FilePo file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public SysUserPo getCreateUser() {
		return createUser;
	}

	public void setCreateUser(SysUserPo createUser) {
		this.createUser = createUser;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public SysUserPo getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(SysUserPo updateUser) {
		this.updateUser = updateUser;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<FileCommunicatePo> getFileCommunicates() {
		return fileCommunicates;
	}

	public void setFileCommunicates(List<FileCommunicatePo> fileCommunicates) {
		this.fileCommunicates = fileCommunicates;
	}

	public List<FilePo> getFiles() {
		return files;
	}

	public void setFiles(List<FilePo> files) {
		this.files = files;
	}

}