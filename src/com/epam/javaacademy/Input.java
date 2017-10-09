package com.epam.javaacademy;

public class Input {

	String command;	
	String parameter;
	
	public Input(){
		
	}
	public Input(String com, String param){
		this.command=com;
		this.parameter=param;
		
	}
	
	
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
