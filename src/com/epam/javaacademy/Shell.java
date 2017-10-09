package com.epam.javaacademy;

import java.util.Scanner;

public class Shell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while(true){
			System.out.print("$>");
			String userInput=scanner.nextLine();
			System.out.println("User said: "+userInput);
		}
	}

}
