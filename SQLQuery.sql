Create database SMDB1;
use SMDB1;

CREATE TABLE StudentInfo_tbl (
 stu_id INT AUTO_INCREMENT PRIMARY KEY,
 Name VARCHAR(50) NOT NULL,
 Age INT NOT NULL, 
 email VARCHAR(60),
 phoneNo long, 
 DOB DATE,
 crdate DATE
 );
 
 CREATE TABLE AddressInfo_tbl (  
 Add_id INT AUTO_INCREMENT PRIMARY KEY,  
 student_id INT,  
 lane CHAR(60),
 pincode INT, 
 house_no INT, 
 district CHAR(60),  
 states CHAR(60), 
 crdate DATE,
  CONSTRAINT fk_student FOREIGN KEY (student_id)  REFERENCES StudentInfo_tbl(stu_id)  
  ON DELETE CASCADE  
  ON UPDATE CASCADE  
);  

 desc StudentInfo_tbl;
 select * from StudentInfo_tbl;
 desc AddressInfo_tbl;
 select * from AddressInfo_tbl;
 delete from StudentInfo_tbl where stu_id=101;
 update StudentInfo_tbl set email=? where stu_id=?
 
 