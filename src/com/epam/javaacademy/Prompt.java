package com.epam.javaacademy;

public class Prompt implements Action {

	String prompt;
	boolean isPromptCwd;
	@Override
	public void doSomething(Input input) {
	
		String param=input.getParameter();
		if(param.equals("$cwd"))
			prompt=Utils.url+">";
		else if(param.equals("reset"))
			prompt="$"+">";
		else
			prompt=param+">";
		this.isPromptCwd=true;
		
	}
	public String getPrompt(){
		return this.prompt;
	}
	public boolean getIsPromptCwd(){
		return this.isPromptCwd;
	}

}
