package com.revature.util;

import java.util.Scanner;

public class CurrencyConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Amount in USD: ");
		int USD = sc.nextInt();
		float INR = 82.27f * USD;
		sc.close();
		System.out.println(USD+" USD in INR is equal to: "+INR+"Rs. ");

	}

}
