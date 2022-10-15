package com.masai.implement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.details.Account;
import com.masai.interfaces.AccountDao;

public class Demo implements AccountDao{

	@Override
	public Account findById(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, id);
		if(ac!=null) {
			em.close();
			return ac;
		}
		return null;
	}

	@Override
	public String save(Account account) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, account.getId());
		if(ac!=null) {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			em.close();
			return "Done";
		}else {
			return "Data already in table";
		}
	}

	@Override
	public String update(Account account) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, account.getId());
		if(ac!=null) {
			em.getTransaction().begin();
			ac.setId(15);
			ac.setAddress("Varanasi");
			em.getTransaction().commit();
			em.close();
			return "Done";
		}else {
			return "Data is not in table";
		}
	}

	@Override
	public String remove(int id) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, id);
		if(ac!=null) {
			em.getTransaction().begin();
			em.remove(ac);
			em.getTransaction().commit();
			em.close();
			return "Done";
		}else {
			return "Data is not in table";
		}
	}

	@Override
	public String withdraw(double amount, int accountId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, accountId);
		if(ac!=null) {
			em.getTransaction().begin();
			ac.setBalance(ac.getBalance()-amount);
			em.getTransaction().commit();
			em.close();
			return "Done";
		}else {
			return "Data is not in table";
		}

	}

	@Override
	public String deposit(double amount, int accountId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em=emf.createEntityManager();
		Account ac=em.find(Account.class, accountId);
		if(ac!=null) {
			em.getTransaction().begin();
			ac.setBalance(ac.getBalance()+amount);
			em.getTransaction().commit();
			em.close();
			return "Done";
		}else {
			return "Data is not in table";
		}	}

}
