package com.epam.javaacademy;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Utils {
	
	Scanner scanner=new Scanner(System.in);
	String url="C:\\\\Users\\Przemek\\workspace\\epam-akademia";
	String command;	
	String parameter;
	String prompt="$>";
	HashMap<String, Integer> sCounter;
	boolean isPromptCwd=false;
	private Input input;
	
	public Utils(){
		input=new Input();	
	}
	public Utils(String userInput){
		
		try{
			command=userInput.substring(0, userInput.indexOf(" "));	
			parameter=userInput.substring(userInput.indexOf(" ")+1);
		}catch(StringIndexOutOfBoundsException e){
			command=userInput;
			parameter=null;
		}
		this.input=new Input(command,parameter);	
		sCounter=new HashMap<>();
		sCounter.put("dir", 0);
		sCounter.put("cd", 0);
		sCounter.put("prompt", 0);
		sCounter.put("tree", 0);
		sCounter.put("statistics", 0);
		//sCounter.replace(command, 1);
	}
	public void setCommand(String com){
		input.setCommand(com);
	}
	
	public String getCommand(){
		return input.getCommand();
	}
	public void setParameter(String param){
		input.setParameter(param);
	}
	
	public String getParameter(){
		return input.getParameter();
	}
	public void runCommand(){
		
		switch(input.getCommand()){
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
			
			break;
		
		case "cd":
			url=changePath(url, parameter);
			if(isPromptCwd)
				prompt=changePrompt(url,"$cwd");
			//System.out.print(prompt);
			
			break;
		
		case "prompt":
			prompt=changePrompt(url,input.getParameter());
			//System.out.println("User said: ");
			break;
			
		case "tree":
			
			File path=new File(url);
			listFileTree(path,1);
			
			System.out.println("User said: ");
			break;
		
		case "exit":
			System.out.println("Bye");
			System.exit(0);
			break;
		
		case "statistics":
			Iterator it=sCounter.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair=(Map.Entry)it.next();
				System.out.println(pair.getKey()+":"+pair.getValue());
			}
			
			break;
		default: 
			System.out.println(input.getCommand()+": unknown commnd");
			break;
		}
		sCounter.replace(command,sCounter.get(command).intValue()+1 );
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
	private String changePrompt(String url, String param) {
		
		if(param.equals("$cwd"))
			prompt=url+">";
		else if(param.equals("reset"))
			prompt="$"+">";
		else
			prompt=param+">";
		this.isPromptCwd=true;
		return prompt;
	}
	private static String changePath(String url, String parameter) {

		if(parameter!=null)
		{if(parameter.equals("..")){
			url=url.substring(0, url.lastIndexOf("\\"));
		}
		else
		{
			File directory=new File(url);
			File[] fileList=directory.listFiles();
			for(File f: fileList){
				
			}
			url=url.concat("\\");
			url=url.concat(parameter);			
		}}
		return url;
	}
	
	public void newInput(String userInput){
		try{
			command=userInput.substring(0, userInput.indexOf(" "));	
			parameter=userInput.substring(userInput.indexOf(" ")+1);
			input.setParameter(parameter);
		}catch(StringIndexOutOfBoundsException e){
			command=userInput;
			parameter=null;
		}
		input.setCommand(command);
	
		
		
	}
	public String print()
	{
		System.out.print(prompt);	
		String userInput=scanner.nextLine();
		return userInput;
	}
}
