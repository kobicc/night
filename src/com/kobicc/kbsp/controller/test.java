package com.kobicc.kbsp.controller;

public class test {
	
	
	public static int show() {
		int i = 0;
		try {
			return i++;
		}finally {
			System.out.println("-------------");
			return i--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(show());
	}

}
