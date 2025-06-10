package jk.proj.com.Service;

import java.util.List;

import jk.proj.com.model.Student;

public interface StudentService {
	
	public void addStudentInfo(Student stu);
	public void deleteStudentInfo(int stuId); 
	public void updateStudentInfo(Student stu);
	public List<Student> searchAllStudent();
	public void searchStudentById(Student stu);
	public void searchStudentByName(Student stu);
	public void searchStudentByEmail(Student stu);
