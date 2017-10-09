package com.epam.javaacademy;

import java.io.File;

public class Cd implements Action {

	@Override
	public void doSomething(Input input) {
		// TODO Auto-generated method stub
		String parameter=input.getParameter();
		if(parameter!=null)
		{if(parameter.equals("..")){
			Utils.url=Utils.url.substring(0, Utils.url.lastIndexOf("\\"));
		}
		else
		{
			File directory=new File(Utils.url);
			File[] fileList=directory.listFiles();
			for(File f: fileList){
				if(f.isDirectory()&&f.getName().equals(parameter))
				{	Utils.url=Utils.url.concat("\\");
				Utils.url=Utils.url.concat(parameter);	
				}
			
					
		}				
		}
	}
		
		}
	
}
