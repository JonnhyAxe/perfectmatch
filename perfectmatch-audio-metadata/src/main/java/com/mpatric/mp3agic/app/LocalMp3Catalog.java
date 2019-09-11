package com.mpatric.mp3agic.app;

public class LocalMp3Catalog extends Mp3Catalog {
	
	private String lastError;
	private String lastOut;
	
	public LocalMp3Catalog() {
		super();
	}

	public LocalMp3Catalog(String filename) {
		super(filename);
	}

	protected void printError(String message) {
		lastError = message;
	}

	protected void printOut(String message) {
		setLastOut(message);
	}

	public String getLastOut() {
		return lastOut;
	}

	public void setLastOut(String lastOut) {
		this.lastOut = lastOut;
	}
	
}