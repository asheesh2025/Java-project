package com.masai.services;

import java.util.Scanner;

import com.masai.implement.Demo;
import com.masai.interfaces.AccountDao;

public class Widhdraw {
	public static void main(String[] args) {
		AccountDao acdao=new Demo();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter id");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter balance");
			double amount=sc.nextDouble();
			System.out.println(acdao.withdraw(amount, id));
		}
	}

}
