package jk.proj.com.Service;

public class StudentIdNotFoundException extends Exception {
	
	public String getMessage() {
		return "Student Id Not Found in database";	
		
	}

}
