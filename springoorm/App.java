package com.springoorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springoorm.dao.StudentDao;
import com.springoorm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		StudentDao studentDao =context.getBean("studentDao",StudentDao.class);
		//Student student=new Student(243,"Hmm","Chennai");
		//int r=studentDao.insert(student);
		//System.out.println("done record inserted: " + r);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean go = true;
		while (true) {
			System.out.println("PRESS 1 for add new student record");
			System.out.println("PRESS 2 for display all the student record");
			System.out.println("PRESS 3 for get all details of single student");
			System.out.println("PRESS 4 for delete student record");
			System.out.println("PRESS 5 for update record");
			System.out.println("PRESS 6 to end");
		
			try {int input = Integer.parseInt(br.readLine());
			switch(input) {
			case 1:
				System.out.println("Enter student id: ");
				int studentId = Integer.parseInt(br.readLine());
				System.out.println("Enter student name: ");
				String studentName = br.readLine();
				System.out.println("Enter student city: ");
				String studentCity = br.readLine();
				
				Student student = new Student();
				student.setStudentId(studentId);
				student.setStudentName(studentName);
				student.setStudentCity(studentCity);
				
				int r = studentDao.insert(student);
				System.out.println(r + "Student added");
				System.out.println("------------");
				System.out.println();
			break;
			
			case 2:
				List <Student> allStudents = studentDao.getAllStudents();
				for(Student st:allStudents) {
				System.out.println("ID: " +st.getStudentId());
				System.out.println("NAME: "+st.getStudentName());
				System.out.println("CITY: " +st.getStudentCity());
				}
				System.out.println(" ");
				break;
				
			case 3:
			     System.out.println("enter student id:");
		            int StudentId=Integer.parseInt(br.readLine());
		            Student stuOne=studentDao.getStudent(StudentId);
		            System.out.println("Id:"+stuOne.getStudentId());
		            System.out.println("Nmae:"+stuOne.getStudentName());
		            System.out.println("City:"+stuOne.getStudentCity());
		            System.out.println("----");
				break;
				
			case 4:
				 System.out.println("enter student Id:");
		          int id=Integer.parseInt(br.readLine());
		          studentDao.deleteStudent(id);
		          System.out.println("Student deleted..");
				break;
				
				
			case 5:
				
				
				break;
			case 6:
				go=false;
				break;
			default:
				System.out.println("Invalid Inpit");
				
			}
    }catch (Exception e) {
    	System.out.println("Invalid input, try with other input");
    }		
		
    }
}
}
