package com.kc.upload;

public class TFile {

	private Integer fileId;
	private String fileName;
	private String filePath;

	public TFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TFile(Integer fileId, String fileName, String filePath) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
