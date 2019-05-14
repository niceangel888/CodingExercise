package com.exercise;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryContents {
	
	private List<DirectoryInfo> dirs = new ArrayList<DirectoryInfo>();
	
	public List<DirectoryInfo> getListOfDirectory() {
		return dirs;
	}
	
	public void addDirectory(DirectoryInfo dir) {
		this.dirs.add(dir);
	}
	
	public void showDirectoryContents(String directoryName) {
		
		try {
			File file = new File(directoryName);
			if (!file.isDirectory()) {
				System.out.println(directoryName + " is not a directory. Please enter full path of directory name");
				return;
			}
			DirectoryInfo directory = new DirectoryInfo(file.getAbsolutePath(), file.getName());
			addDirectory(directory);
			getListOfFile(file, directory);
			
		} catch (RuntimeException e) {
			System.out.println("Unable to find directory: "+directoryName);
			return;
		}		
	}
	
	
	public void getListOfFile(File file, DirectoryInfo directory) {			
		File[] files =  file.listFiles();
		if (files == null || files.length == 0) {
			return;
		}
		for (File f : files) {
			if (f.isFile()) {
				directory.addFile(f);			
			} else if (f.isDirectory()) {			
				DirectoryInfo dir = new DirectoryInfo(f.getAbsolutePath(), f.getName());				
				addDirectory(dir);
				getListOfFile(f, dir);
			}
		}			
	}
	
	public void print() {		
		String prettyFormat = "";
		for (DirectoryInfo dir: getListOfDirectory()) {
			System.out.println(prettyFormat + "Directory: "+dir.getAbsolutePath()+ " : "+dir.getName());
			System.out.println(prettyFormat + "Directory Contents :" );
			if (dir.getFiles().isEmpty()) {
				System.out.println(prettyFormat + "---No Contents--");
			}
			for(File f : dir.getFiles()) {
				System.out.println(prettyFormat+ "  "+f.getAbsolutePath()+ " : "+f.getName()+" : "+f.length()+" bytes");
			}
			System.out.println();
			prettyFormat = prettyFormat + " ";
		}
	}
	
	public static void main(String[] args) {		
		DirectoryContents r = new DirectoryContents();
		String fileName = "/Users/irene/myDirectory";
		r.showDirectoryContents(fileName);		
		r.print();
	}

}
