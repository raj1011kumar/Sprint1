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
	s.removeById(2);
	System.out.println("------------------------------------------------------------");
	
	Course c1 = new Course();
	  c1.setCourseName("Java Programming");
	  c1.setCourseCode("CS101");

	  Course c2 = new Course();
	  c2.setCourseName("Database Management");
	  c2.setCourseCode("DB101");

	  Course c3 = new Course();
	  c3.setCourseName("Web Development");
	  c3.setCourseCode("WD101");

	  CourseDAO courseDAO = new CourseDAO(em);

	  // Adding courses
	  courseDAO.createCourse(c1);
	  courseDAO.createCourse(c2);
	  courseDAO.createCourse(c3);

	  System.out.println("Course details successfully added");
	  System.out.println("----------------------------------------------------------------");

	  // Updating course details
	  int newCourseId = 3;
	  String newCourseName = "Advanced Web Development";
	  String newCourseCode = "AWD101";
	  courseDAO.updateCourse(newCourseId, newCourseName, newCourseCode);
	  System.out.println("------------------------------------------------------------");

	  // Retrieving course details based on ID
	  System.out.println("Course details based on ID");
	  Optional<Course> courseDetails = courseDAO.getById(2);
	  System.out.println(courseDetails);
	  System.out.println("------------------------------------------------------------");

	  // Retrieving all courses
	  System.out.println("All course details");
	  List<Course> allCourses = courseDAO.getAll();
	  System.out.println(allCourses);
	  System.out.println("------------------------------------------------------------");

	  // Removing a course by ID
	  System.out.println("Removing 1st course based on ID");
	  System.out.println("Data removed successfully");
	  courseDAO.removeById(1);
	
   }
  
  catch (HibernateException e) {
		 e.printStackTrace();
	}
  catch (Exception e) {
	 e.printStackTrace();
	}

	}
}

