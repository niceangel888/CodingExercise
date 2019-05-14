package com.exercise;

import java.io.File;
import java.util.Comparator;

public class FileSizeComparator implements Comparator<File>{

	public Long fileSize(File file) {
		return file.length();
	}
	
	@Override
	public int compare(File file1, File file2) {		
		return fileSize(file1).compareTo(fileSize(file2));
	}
	
	

}
