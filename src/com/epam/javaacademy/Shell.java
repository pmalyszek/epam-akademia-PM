package com.epam.javaacademy;

import java.io.File;
import java.util.Scanner;

public class Shell {

	
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		String input;
		Utils com;
		System.out.print("$>");
		
		String userInput=scanner.nextLine();
		com=new Utils(userInput);
		com.runCommand();
		while(true){
			
			input=com.print();
			com.newInput(input);
			com.runCommand();
								
		}
	}
}
