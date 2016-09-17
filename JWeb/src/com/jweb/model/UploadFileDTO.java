package com.jweb.model;

import java.io.File;

public class UploadFileDTO {
	private String file;
	private String fileName;//ÎÄ¼þÃû¡£txt
	private long size;
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
