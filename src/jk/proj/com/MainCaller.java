package jk.proj.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jk.proj.com.Service.StudentService;
import jk.proj.com.Service.StudentServicveImpl;
import jk.proj.com.model.Address;
import jk.proj.com.model.Student;

public class MainCaller {

	public static void main(String[] args) throws ParseException {
		System.out.println("***********START MAIN CLASS*******************");
		
		StudentService stuService=new StudentServicveImpl();//dynamic dispatch 
		
		Date crdate = new Date();//today'Date
		
		List<Address> addList=new ArrayList<Address>();
		
		//1 add Student information into Database 
//		System.out.println("********started Adding Student Info and Address Info ************");
//		
//	    
//		//address Information // static data
//		Address add1=new Address(610, "Kalpana Hostel", 140307, 999, "Punjab", "Harayana", crdate);
//		Address add2=new Address(611, "Manpur patawatoli", 823003, 123, "Bihar", "Gaya", crdate);
//		Address add3=new Address(612, "Patna Bihar", 823005, 123, "Bihar", "Gaya", crdate);
//		addList.add(add1);
//		addList.add(add2);
//		addList.add(add3);
//		
//		//Students Informations 
//		Date dob=new SimpleDateFormat("dd/MM/yyyy").parse("12/09/1986"); 
//		Student stu1=new Student(5002, "Jitendra",24, "Surabhi@gmail.com", 8911229819L, dob, crdate, addList);
//		
//		//1. adding the student details 
//		stuService.addStudentInfo(stu1);//STudent object which ahs all infor 
//		
//		System.out.println("********Records Instrted successfully ************");
		
		//2. delete Student Information 
		//System.out.println("***********START DELETE Process*******************");
		//stuService.deleteStudentInfo(5001);
		
		//3. search All Students
		List<Student> studentList=stuService.searchAllStudent();
		Iterator it=studentList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		System.out.println("***********END MAIN CLASS*******************");

	}

}
