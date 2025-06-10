package jk.proj.com.model;

import java.util.Date;

public class Address {
	
	private int addId;
	private String lane;
	private int pincode;
	private int houseNo;
	private String district;
	private String states;
	private Date crdate;
	
	public Address() {}
	
	public Address(int addId, String lane, int pincode, int houseNo, String district, String states, Date crdate) {
		super();
		this.addId = addId;
		this.lane = lane;
		this.pincode = pincode;
		this.houseNo = houseNo;
		this.district = district;
		this.states = states;
		this.crdate = crdate;
	}




	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", lane=" + lane + ", pincode=" + pincode + ", houseNo=" + houseNo
				+ ", district=" + district + ", states=" + states + ", crdate=" + crdate + "]";
	}
	
	
	
	
	
	

}
