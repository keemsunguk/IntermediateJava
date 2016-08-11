package Lesson4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReadList {
	
	private String fname;
	private File infile;
	private Scanner inp;
	private int size;

	ArrayList <Double> data;

	FileReadList() {
		fname="";
		infile = null;
		data = new ArrayList <Double>();
	}

	
	FileReadList(String f) {
		fname = f;
		infile = new File(fname);
		try {
			inp = new Scanner(infile);
			data = new ArrayList <Double>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	
	public void ReadInput() {
		while( inp.hasNext() == true ) {
			data.add(inp.nextDouble());
		}
		size = data.size();
	}
	
	public void CheckContents() {
		for(double f:data) {
			System.out.println(f);
		}	
	}
	
	public int GetSize() {
		return size;
	}
	
	public void WhatAmI() {
		System.out.println("Read a file of double numbers into data");
	}
	
	
	public void closeFile() {
		inp.close();
	}
}
