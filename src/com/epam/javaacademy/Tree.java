package com.epam.javaacademy;

import java.io.File;

public class Tree implements Action {

	@Override
	public void doSomething(Input input) {

		File path=new File(Utils.url);
		listFileTree(path,1);
		
	}
	private void listFileTree(File path, int count) {

		File[] listPath=path.listFiles();
		for(File f:listPath){
			if(!f.isDirectory())
			{
				for(int i=0;i<count;i++)
				System.out.print("-");
				System.out.print(f.getName()+"\n");
			}
				
			else{
				listFileTree(f,count+1);
			}
		}		
	}

}
