package com.epam.javaacademy;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Utils {
	
	static String url=System.getProperty("user.dir");
	Scanner scanner=new Scanner(System.in);
	String command;	
	String parameter;
	String prompt="$>";
	static HashMap<String, Integer> sCounter;
	Action action;
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
			
			action=new Dir();
			action.doSomething(input);
			sCounter.replace(command,sCounter.get(command).intValue()+1 );
			break;
		
		case "cd":

			action=new Cd();
			action.doSomething(input);
			sCounter.replace(command,sCounter.get(command).intValue()+1 );
			if(isPromptCwd)
			{
				action=new Prompt();
				action.doSomething(input);
				prompt=((Prompt) action).getPrompt();
				isPromptCwd=((Prompt) action).getIsPromptCwd();
			}
			
			break;
		
		case "prompt":
			action=new Prompt();
			action.doSomething(input);
			prompt=((Prompt) action).getPrompt();
			sCounter.replace(command,sCounter.get(command).intValue()+1 );
			isPromptCwd=((Prompt) action).getIsPromptCwd();
			break;
			
		case "tree":
			
			action=new Tree();
			action.doSomething(input);
			sCounter.replace(command,sCounter.get(command).intValue()+1 );
			
			break;
		
		case "exit":
			System.out.println("Bye");
			System.exit(0);
			break;
		
		case "statistics":
			action=new Statistics();
			action.doSomething(input);	
			sCounter.replace(command,sCounter.get(command).intValue()+1 );
			break;
		default: 
			System.out.println(input.getCommand()+": unknown commnd");
			break;
		}
	
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
