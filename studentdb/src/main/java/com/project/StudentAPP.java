package com.project;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentAPP {

	public static void main(String[] args) {
	 EntityManagerFactory factory =null;	
  try {
	factory=Persistence.createEntityManagerFactory("rs");
	
	EntityManager em = factory.createEntityManager();
	
	Student s1 = new Student(1,"Raj","kumar","raj@gmail.com","8977436777","male");
	Student s2 = new Student(2,"Mohan","gorli","mohan@gmail.com","9765647854","male");
	Student s3 = new Student(3,"Gopi","krishna","gopi@gmail.com","9764457854","male");
	Student s4 = new Student(4,"Manikanta","Nagurthi","manikanta@gmail.com","9765646654","male");
	Student s5 = new Student(5,"Ram","krishna","ram@gmail.com","9554457854","male");
	StudentDAO s=new StudentDAO(em);
	s.createStudent(s1);
	s.createStudent(s2);
	s.createStudent(s3);
	s.createStudent(s4);
	s.createStudent(s5);
	System.out.println("Student details successfully added");
   System.out.println("----------------------------------------------------------------");
	System.out.println("updating studeent details");
	int  newid = 5;
	String newfirstName ="sai" ;
	String newLastName = "satya" ;
	String newemail = "sai@gmail.com";
	String newphoneNum = "8921465132" ;
	String newgender  ="male";
	
	s.updateStudent(newid, newfirstName, newLastName, newemail, newphoneNum, newgender);
	
	System.out.println("------------------------------------------------------------");
	System.out.println("student details based on id");
	Optional<Student> details = s.getById(2);
	System.out.println(details);
	
	System.out.println("------------------------------------------------------------");
	System.out.println("All students details");	 
	List<Student> all = s.getAll();
	System.out.println(all);
	
	System.out.println("------------------------------------------------------------");
	System.out.println("Removing student details based on id");	
	s.removeById(4);
   }
  
  catch (HibernateException e) {
		 e.printStackTrace();
	}
  catch (Exception e) {
	 e.printStackTrace();
	}

	}

}
