package hibernate_practisecrud;

import java.util.Scanner;

public class UserMain {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter your choice");
		System.out.println("1.insert");
		System.out.println("2.delete");
		System.out.println("3.update");
		System.out.println("4.find");
		
		int choice=scanner.nextInt();
		UserCRUD crud=new UserCRUD();
		User user=new User();
		
		switch(choice) {
		case 1:{
			crud.saveuser(user);
		}
		break;
		
		case 2:{
			crud.deleteuser();
		}
		break;
		
		case 3:{
			crud.updateuser();
		}
		break;
		
		case 4:{
			crud.fetchuser();
		}
		break;
		
		default: System.out.println("wrong choice entered");
		}
		
	}

}
