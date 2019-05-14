package com.exercise;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectoryInfo {
	
	private String absolutePath;
	private String name;	
	private List<File> files = new ArrayList<File>();
	
	public DirectoryInfo() {}
	
	public DirectoryInfo(String absolutePath, String name) {
		this.absolutePath = absolutePath;
		this.name = name;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getFiles() {
		Collections.sort(files, new FileSizeComparator());
		return files;
	}
	
	public void addFile(File file) {
		this.files.add(file);
	}
}
