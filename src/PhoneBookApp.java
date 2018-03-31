import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.midi.Synthesizer;

import com.sun.java_cup.internal.runtime.Scanner;

public class PhoneBookApp {
	

	public static void main(String[] args) {
		welcome();
		

	}

	private static void welcome() {
		
		System.out.println("Choose an option to continue..."+"\n");
		System.out.println("1. Add contact"+"\n"+"2. Search Contact"+
		"\n"+"3. Delete Record"+"\n"+"4. Update Contact");
		ConsoleStringInput in=new ConsoleStringInput();
		
		String c="";
		int choice=0;
		try {
			c=in.getConsole();
			choice=Integer.parseInt(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch(choice) {
		case 1:
		
			System.out.println("First Name: ");
			String f_name=in.getConsole();
			System.out.println("Last Name: ");
			String l_name=in.getConsole();
			System.out.println("Email: ");
			String email=in.getConsole();
			System.out.println("Home Phone: ");
			String h_phone=in.getConsole();
			System.out.println("Mobile Number: ");
			String m_phone=in.getConsole();
			System.out.println("Street: ");
			String street=in.getConsole();
			System.out.println("Postal Code: ");
			String p_code=in.getConsole();
			System.out.println("City: ");
			String city=in.getConsole();
			System.out.println("Province: ");
			String province=in.getConsole();
			System.out.println("Country: ");
			String country=in.getConsole();
			PhoneBook obj1=new PhoneBook(f_name,l_name,
					email,h_phone,m_phone,street,
					p_code,city,province,country);
			
			obj1.addNewRecord(obj1);
			break;
		case 2:
			PhoneBook obj2=new PhoneBook();
			obj2.getRecords();
			break;
		case 3:
			PhoneBook obj3=new PhoneBook();
			obj3.deleteRecords();
			break;
		case 4:
			PhoneBook obj4=new PhoneBook();
			obj4.updateRecords();
			break;
		default:
			System.out.println("Invalid Choice!!!");
			welcome();
			
			break;	
			
		}
	}

}
