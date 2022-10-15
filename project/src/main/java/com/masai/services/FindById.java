package com.masai.services;

import java.util.Scanner;

import com.masai.implement.Demo;
import com.masai.interfaces.AccountDao;

public class FindById {

	public static void main(String[] args) {
		
		AccountDao acdao=new Demo();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println(acdao.findById(id));
		}
	}

}
