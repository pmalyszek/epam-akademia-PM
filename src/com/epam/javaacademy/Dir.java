package com.epam.javaacademy;

import java.io.File;

public class Dir implements Action {

	@Override
	public void doSomething(Input input) {
		File directory=new File(Utils.url);
		File[] fileList=directory.listFiles();
		System.out.println("Content of "+Utils.url);
		for(File f:fileList){
			if(f.isDirectory()){
				System.out.print("DIR");
			}
			else{
				System.out.print("FIL");
			}
			System.out.print("\t"+f.getName()+"\n");
		}

	}

}
