package com.neuedu.tipd.my12306.bean;

import java.util.Date;

/*
 * 用户信息实体类
 * 
 * @author Game
 * 
 * @property 
 * 		userId			用户Id,识别用户的唯一编码
 * 		userEmail		用户邮箱,同时作为用户登录的账号
 * 		userPassword	用户密码,存入之前须用MD5加密算法加密
 * 		userName		用户姓名
 *		userSex			用户性别,填入时请用MALE或FEMALE
 *		idCard			用户身份证号
 *		phone			用户电话
 *		lastLogin		用户上一次登陆时间
 *		userStatus		用户的状态,填入时请用CAN_BUY、CAN_NOT_BUY、或者CAN_NOT_TODAY
 *
 * @Param
 * 		CAN_BUY			可以购买
 * 		CAN_NOT_BUY		不可购买
 * 		CAN_NOT_TODAY	当天不可购买
 * 		MALE			男性
 * 		FEMALE			女性
 */

public class TrainUser {
	private int userId;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userSex;
	private String idCard;
	private String phone;
	private Date lastLogin;
	private String userStatus;
	
	public static String CAN_BUY = "可购买";
	public static String CAN_NOT_BUY = "不可购买";
	public static String CAN_NOT_TODAY = "当天禁止购买";
	public static String MALE = "男性";
	public static String FEMALE = "女性";
	
	public TrainUser(int userId, String userEmail, String userPassword, String userName, String userSex, String idCard,
			String phone, Date lastLogin, String userStatus) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.idCard = idCard;
		this.phone = phone;
		this.lastLogin = lastLogin;
		this.userStatus = userStatus;
	}

	public TrainUser() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
}
