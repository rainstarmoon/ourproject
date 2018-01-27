package com.project.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CloudDiscPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private SysUserPo sysUser;
	private BigDecimal totalsize;
	private BigDecimal freesize;
	private BigDecimal imagesize;
	private BigDecimal documentsize;
	private Boolean flag;
	private List<FileCommunicatePo> shareDiscs;
	private List<FilePo> files;
	private List<FileCommunicatePo> ownerDiscs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysUserPo getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUserPo sysUser) {
		this.sysUser = sysUser;
	}

	public BigDecimal getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(BigDecimal totalsize) {
		this.totalsize = totalsize;
	}

	public BigDecimal getFreesize() {
		return freesize;
	}

	public void setFreesize(BigDecimal freesize) {
		this.freesize = freesize;
	}

	public BigDecimal getImagesize() {
		return imagesize;
	}

	public void setImagesize(BigDecimal imagesize) {
		this.imagesize = imagesize;
	}

	public BigDecimal getDocumentsize() {
		return documentsize;
	}

	public void setDocumentsize(BigDecimal documentsize) {
		this.documentsize = documentsize;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<FileCommunicatePo> getShareDiscs() {
		return shareDiscs;
	}

	public void setShareDiscs(List<FileCommunicatePo> shareDiscs) {
		this.shareDiscs = shareDiscs;
	}

	public List<FilePo> getFiles() {
		return files;
	}

	public void setFiles(List<FilePo> files) {
		this.files = files;
	}

	public List<FileCommunicatePo> getOwnerDiscs() {
		return ownerDiscs;
	}

	public void setOwnerDiscs(List<FileCommunicatePo> ownerDiscs) {
		this.ownerDiscs = ownerDiscs;
	}

}