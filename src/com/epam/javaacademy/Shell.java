package com.epam.javaacademy;

import java.io.File;
import java.util.Scanner;

public class Shell {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String url="C:\\\\Users\\Przemek\\workspace\\epam-akademia";
		while(true){
			
			System.out.print("$>");
			
			String userInput=scanner.nextLine();
			String condition;
			try{
				condition=userInput.substring(0, userInput.indexOf(" "));	
			}catch(StringIndexOutOfBoundsException e){
				condition=userInput;
			}
			switch(condition){
			case "dir":
				File directory=new File(url);
				File[] fileList=directory.listFiles();
				System.out.println("Content of "+url);
				for(File f:fileList){
					if(f.isDirectory()){
						System.out.print("DIR");
					}
					else{
						System.out.print("FIL");
					}
					System.out.print("\t"+f.getName()+"\n");
				}
				
				System.out.println("User said: "+userInput);
				break;
			
			case "cd":
				String parameter=userInput.substring(userInput.indexOf(" ")+1);
				url=changePath(url, parameter);
				//System.out.println(url);
				//System.out.println("User said: "+userInput);
				break;
			
			case "prompt":
				System.out.println("User said: "+userInput);
				break;
				
			case "tree":
				System.out.println("User said: "+userInput);
				break;
			
			case "exit":
				System.out.println("User said: "+userInput);
				
				break;
			
			case "statistics":
				System.out.println("User said: "+userInput);
				break;
			default: 
				System.out.println(userInput+": unknown commnd");
				break;
			}
			
		}
	}

	private static String changePath(String url, String parameter) {

		if(parameter.equals("..")){
			url=url.substring(0, url.lastIndexOf("\\"));
		}
		else
		{
			url=url.concat("\\");
			url=url.concat(parameter);			
		}
		return url;
	}

}
