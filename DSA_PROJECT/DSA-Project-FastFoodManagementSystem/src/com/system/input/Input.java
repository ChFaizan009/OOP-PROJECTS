package com.system.input;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Input {

	public Integer inputInt() {
		Scanner scan = new Scanner(System.in);
		Integer integer = 0;
		while(true){
			try{
				integer = scan.nextInt();
				break;
			}
			catch(Exception ex){
				System.out.print("[InValid Input!!!]\n[Enter a Number]:->");
				scan.next();
				continue;
			}
		}
		return integer;
	}

	public long inputLong() {
		Scanner scan = new Scanner(System.in);
		Long longValue = (long) 0;
		while(true){
			try{
				longValue = scan.nextLong();
				break;
			}
			catch(Exception ex){
				System.out.print("[InValid Input!!!]\n[Enter a Number]:->");
				scan.next();
				continue;
			}
		}
		return longValue;
	}

	public String inputString() {
		Scanner scan = new Scanner(System.in);
		String string = "";
		while(true){
			try{
				string = scan.nextLine();
				if (string.matches("[a-zA-Z]+") == true) {
					return toCapitalize(string);
				} else if(string.matches("[a-zA-Z0-9]+") == true) {
					System.out.print("Invalid Input\nEnter Again: ");
					continue;
				}
				break;
			}
			catch(Exception ex){
				System.out.print("[InValid Input!!!]\n[Enter a String]:->");
				scan.next();
				continue;
			}
		}
		return toCapitalize(string);
	}

	public char inputChar() {
		Scanner scan = new Scanner(System.in);
		char ch = ' ';
		while(true){
			try{
				ch = scan.next().charAt(0);
				break;
			}
			catch(Exception ex){
				System.out.print("[InValid Input!!!]\n[Enter a Number]:->");
				scan.next();
				continue;
			}
		}
		return ch;
	}

	public boolean inputBoolean() {
		Scanner scan = new Scanner(System.in);
		boolean bool = false;
		while(true){
			try{
				bool = scan.nextBoolean();
				break;
			}
			catch(Exception ex){
				System.out.print("[InValid Input!!!]\n[Enter a Valid Input]:->");
				scan.next();
				continue;
			}
		}
		return bool;
	}

	public static String toCapitalize(String string) {
		if(string == null || string =="" || string==" ") {
			return string;
		} else {
			String[] str = string.split(" ");
			String result = "";
			for(int i=0; i<str.length ; i++) {
				result += str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
				result += " ";
			}
			return result.substring(0, result.length()-1);
		}
	}
}
