package com.masai.services;

import java.util.Scanner;

import com.masai.details.Account;
import com.masai.implement.Demo;
import com.masai.interfaces.AccountDao;

public class SaveData {

	public static void main(String[] args) {
		
			
			AccountDao acdao=new Demo();
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter id");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter address");
				String address=sc.nextLine();
				System.out.println("Enter email");
				String email=sc.nextLine();
				System.out.println("Enter balance");
				double balance=sc.nextDouble();
				Account account=new Account(id, email, address, balance);
				System.out.println(acdao.save(account));
			}
		

	}

}
