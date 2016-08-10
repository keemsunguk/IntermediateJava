package Lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileRead {
	
	private String fname;
	private File infile;
	private Scanner inp;
	private int size;

	double data[];

	FileRead() {
		fname="";
		infile = null;
	}

	
	FileRead(String f) {
		fname = f;
		infile = new File(fname);
		try {
			inp = new Scanner(infile);
			LookAhead();
			inp.close();
			inp = new Scanner(infile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	private void LookAhead() {
		size = 0;
		while( inp.hasNext()) {
			inp.next();
			size++;
		}
	}
	
	public void ReadInput() {
		data = new double [size];
		
		for(int i = 0; i < size; i++) {
			data[i] = inp.nextDouble();
		}
	}
	
	public void CheckContents() {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
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
