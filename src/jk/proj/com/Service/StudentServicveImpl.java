package jk.proj.com.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jk.pro.com.util.JDBCUtil;
import jk.proj.com.model.Address;
import jk.proj.com.model.Student;

public class StudentServicveImpl implements StudentService {
	
	public String STUDENT_ADD_QUERY = "insert into studentinfo_tbl values(?,?,?,?,?,?,?)";
	public String ADDRESS_ADD_QUERY = "insert into addressinfo_tbl values(?,?,?,?,?,?,?,?)";
	public String STUDENT_DELETE_QUERY = "delete from studentinfo_tbl where stu_id=?";
	public String STUDENT_SEARCH_QUERY = "select * from StudentInfo_tbl";  //NO PLACEHOLCER REFQUIRED 
	public String ADDRESS_SEARCH_QUERY = "select * from addressinfo_tbl where student_id=?";
	public String STUDENT_UPDATE_QUERY = "update StudentInfo_tbl set email=? where stu_id=?";
	
	private java.sql.Connection con = null;
	private PreparedStatement ps1 = null;
	private PreparedStatement ps2 = null;
	private PreparedStatement ps3=null;
	private PreparedStatement ps4=null;

	public void addStudentInfo(Student stu) {
		System.out.println(">>>>>>>>addStudentInfo>>>>>>>");
		try {
			con = JDBCUtil.getMysqlConnection();
			ps1 = con.prepareStatement(STUDENT_ADD_QUERY);
			ps1.setInt(1, stu.getStudentId());
			ps1.setString(2, stu.getName());
			ps1.setInt(3, stu.getAge());
			ps1.setString(4, stu.getEmail());
			ps1.setLong(5, stu.getPhoneNo());
			ps1.setDate(6, new Date(stu.getDOB().getTime()));//NOTE HERE PEOPLE TEND TO MAKE MISTAKE , BE CLEAR ABOUT THIS
			ps1.setDate(7, new Date(stu.getCrdate().getTime()));

			int stu_flag = ps1.executeUpdate();
			System.out.println("records instrted successfully " + stu_flag);
			
			for(Address add : stu.getAddList()) {
				
				ps1 = con.prepareStatement(ADDRESS_ADD_QUERY);
				ps1.setInt(1, add.getAddId());
				ps1.setInt(2, stu.getStudentId());
				ps1.setString(3, add.getLane());
				ps1.setInt(4, add.getPincode());
				ps1.setInt(5, add.getHouseNo());
				ps1.setString(6, add.getDistrict());
				ps1.setString(7, add.getStates());
				ps1.setDate(8, new Date(stu.getCrdate().getTime()));
				
				int add_flag = ps1.executeUpdate();
				
				System.out.println("records instrted successfully " + add_flag);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JDBCUtil.cleanUp(con, ps1);

		}

	}

	public void deleteStudentInfo(int stuId) {
		System.out.println("*******Call deleteStudentInfo()  ************");
		con = JDBCUtil.getMysqlConnection();
		try {
			ps2 = con.prepareStatement(STUDENT_DELETE_QUERY);
			ps2.setInt(1, stuId);
			int y= ps2.executeUpdate();
			if (y > 0) {
				System.out.println("Records has been  sucessfully deleted ");
			} else {
				System.out.println("Student id :"+stuId +" NOT FOUND so delete operation not completed.");
				try {
					throw new StudentIdNotFoundException();
				} catch (StudentIdNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateStudentInfo(Student stu) {
		// TODO Auto-generated method stub

	}

	public void searchStudentById(Student stu) {
		// TODO Auto-generated method stub

	}

	public void searchStudentByName(Student stu) {
		// TODO Auto-generated method stub

	}

	public void searchStudentByEmail(Student stu) {
		// TODO Auto-generated method stub

	}

	public List<Student> searchAllStudent() {
		List<Student> stuList=new ArrayList<Student>();
		List<Address> addList=null;
		Student stu=null;
		Address addres=null;
		con = JDBCUtil.getMysqlConnection();
		try {
			 ps3 = con.prepareStatement(STUDENT_SEARCH_QUERY);
			 ResultSet rs1 = ps3.executeQuery();  //SELECT STATEMNT SO RESULTSET
			while(rs1.next()) {
				stu=new Student();
				stu.setStudentId(rs1.getInt(1));  //RESULT SET INDEX STARTS FROMM 1 AND IST INDEX ID HAI SO ID MIL GYA AND SET KAR DIYE , SET METHOD WRITEN STU CLAS 
				stu.setName(rs1.getString(2));
				stu.setAge(rs1.getInt(3));
				stu.setEmail(rs1.getString(4));
				stu.setPhoneNo(rs1.getLong(5));
				stu.setDOB(rs1.getDate(6));
				stu.setCrdate(rs1.getDate(7));
				stuList.add(stu);
				
				
				addList=new ArrayList<Address>();
				//System.out.println(stu.getStudentId()); 
				ps4 = con.prepareStatement(ADDRESS_SEARCH_QUERY);
				ps4.setInt(1, stu.getStudentId());  //placeholder so 
				ResultSet rs2 = ps4.executeQuery();
				while(rs2.next()) {
					 addres=new Address();// 3 object will be created ,since 3 addres tha uss stude ka 
					 addres.setAddId(rs2.getInt(1));
					 addres.setLane(rs2.getString(3));  //studen tid not print so 2 nhi 
					 addres.setPincode(rs2.getInt(4));
					 addres.setHouseNo(rs2.getInt(5));
					 addres.setDistrict(rs2.getString(6));
					 addres.setStates(rs2.getString(7));
					 addres.setCrdate(rs2.getDate(8));
					 addList.add(addres);// 3 object will added in the list
					 
					}
				stu.setAddList(addList);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
		
	}

}
