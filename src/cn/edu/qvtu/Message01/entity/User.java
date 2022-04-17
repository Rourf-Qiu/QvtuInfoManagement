package cn.edu.qvtu.Message01.entity;

import cn.edu.qvtu.Message00.base.NumberTool;

//表user_的实体类
public class User {
	private long userID;
	private String userName;
	private String userSex;
	private String userClass;
	private String userType;
	private String userIdentity;
	private long ID;
	private String userPSW;
	private String userPhone;
	private String userHome;

public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserHome() {
		return userHome;
	}

	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}

	//		bigint
//		varchar
//		varchar
//		varchar
//		varchar
//		varchar
//		bigint
	public long getUserID() {
		return userID;
	}

	public String getUserPSW() {
		return userPSW;
	}

	public void setUserPSW(String userPSW) {
		this.userPSW = userPSW;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
	public void setsetUserID(String userID) {
		this.setUserID(NumberTool.toLong(userID));
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userSex=" + userSex + ", userClass=" + userClass
				+ ", userType=" + userType + ", userIdentity=" + userIdentity + ", ID=" + ID + ", userPSW=" + userPSW
				+ ", userPhone=" + userPhone + ", userHome=" + userHome + "]";
	}
	
}
