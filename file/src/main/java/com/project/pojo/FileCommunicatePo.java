package com.project.pojo;

import java.io.Serializable;

public class FileCommunicatePo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CloudDiscPo shareDisc;
	private CloudDiscPo ownerDisc;
	private FilePo file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CloudDiscPo getShareDisc() {
		return shareDisc;
	}

	public void setShareDisc(CloudDiscPo shareDisc) {
		this.shareDisc = shareDisc;
	}

	public CloudDiscPo getOwnerDisc() {
		return ownerDisc;
	}

	public void setOwnerDisc(CloudDiscPo ownerDisc) {
		this.ownerDisc = ownerDisc;
	}

	public FilePo getFile() {
		return file;
	}

	public void setFile(FilePo file) {
		this.file = file;
	}

}