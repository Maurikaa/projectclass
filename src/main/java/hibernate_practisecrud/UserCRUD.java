package hibernate_practisecrud;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserCRUD {
	
	Scanner scanner = new Scanner(System.in);
	
	public void saveuser(User user) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rakesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the location");
		String location=scanner.next();
		System.out.println("enter the phone number");
		long phone=scanner.nextLong();
		System.out.println("enter the sal");
		double sal=scanner.nextDouble();
		
		user.setId(id);
		user.setName(name);
		user.setLocation(location);
		user.setPhone(phone);
		user.setSal(sal);
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	
	public void deleteuser() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rakesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		System.out.println("enter the id to be deleted");
		int id = scanner.nextInt();
		User user = entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		
		
	}
	
	
	public void updateuser() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rakesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		System.out.println("enter the id details to be updated");
		int id = scanner.nextInt();
		User user = entityManager.find(User.class, id);
		
		
		System.out.println("name");
		String name = scanner.next();
		System.out.println("location");
		String location = scanner.next();
		System.out.println("phone number");
		long phone = scanner.nextLong();
		System.out.println("salary");
		double sal = scanner.nextDouble();
		
		user.setName(name);
		user.setLocation(location);
		user.setPhone(phone);
		user.setSal(sal);
		
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		
	}
	
	public void fetchuser() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rakesh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		System.out.println("enter the id details to be fetched");
		int id = scanner.nextInt();
		
		User user=entityManager.find(User.class, id);
		System.out.println(user);
	}

}
