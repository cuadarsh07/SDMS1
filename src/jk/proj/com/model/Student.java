package jk.proj.com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	private int studentId;
	private String name;
	private int age;
	private String email;
	private long phoneNo;
	private Date DOB;
	private Date crdate;
	//student can have multiple address
	List<Address> addList=new ArrayList<Address>();
	
	public Student() {}
	
	public Student(int studentId, String name, int age, String email) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public Student(int studentId, String name, int age, String email, long phoneNo, Date dOB, Date crdate,
			List<Address> addList) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneNo = phoneNo;
		DOB = dOB;
		this.crdate = crdate;
		this.addList = addList;
	}
	
	
	public List<Address> getAddList() {
		return addList;
	}

	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Date getCrdate() {
		return crdate;
	}

	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", email=" + email + ", phoneNo="
				+ phoneNo + ", DOB=" + DOB + ", crdate=" + crdate + ", addList=" + addList + "]";
	}

	

}
