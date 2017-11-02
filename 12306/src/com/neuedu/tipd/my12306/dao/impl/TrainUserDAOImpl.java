package com.neuedu.tipd.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.tipd.my12306.bean.TrainUser;
import com.neuedu.tipd.my12306.dao.TrainUserDAO;
import com.neuedu.tipd.my12306.util.DButil;

public class TrainUserDAOImpl implements TrainUserDAO {
private Connection con = null;
	
	public Connection getCon() {
		return con;
	}

	public TrainUserDAOImpl() {
		//构造时直接进行连接
		con = DButil.getConnection();
	}
	
	public void closeAll(){
		DButil.closeAll(con, null, null);
	}
	
	public void reConnection(){
		if (con != null) {
			DButil.closeAll(con, null, null);
		}
		con = DButil.getConnection();
	}

	@Override
	public boolean addTrainUser(TrainUser trainUser) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "insert into Train_User(USER_ID,USER_EMAIL,USER_PASSWORD,USER_NAME,USER_SEX,IDCARD,PHONE,LAST_LOGIN,USER_STATUS) "
						+ "values(SEQ_TRAIN_USER.nextval,?,?,?,?,?,?,?,?)";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, trainUser.getUserEmail());
			stmt.setString(2, trainUser.getUserPassword());
			stmt.setString(3, trainUser.getUserName());
			stmt.setString(4, trainUser.getUserSex());
			stmt.setString(5, trainUser.getIdCard());
			stmt.setString(6, trainUser.getPhone());
			stmt.setTimestamp(7, new Timestamp(trainUser.getLastLogin().getTime()));
			stmt.setString(8, trainUser.getUserStatus());
			
			int count = stmt.executeUpdate();
			
			if (count != 1) {
				throw new SQLException("数据库新增失败!");
			} else {
				rs = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DButil.closeAll(con, stmt, null);
		}
		return rs;
	}

	@Override
	public boolean updateTrainUser(TrainUser trainUser){
		reConnection();
		PreparedStatement stmt = null;
		String sql = "update Train_user set USER_EMAIL = ?,USER_PASSWORD = ?,USER_NAME = ?,USER_SEX = ?,IDCARD = ?,PHONE = ?,LAST_LOGIN = ?,USER_STATUS = ? where User_ID = ?";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, trainUser.getUserEmail());
			stmt.setString(2, trainUser.getUserPassword());
			stmt.setString(3, trainUser.getUserName());
			stmt.setString(4, trainUser.getUserSex());
			stmt.setString(5, trainUser.getIdCard());
			stmt.setString(6, trainUser.getPhone());
			stmt.setTimestamp(7, new Timestamp(trainUser.getLastLogin().getTime()));
			stmt.setString(8, trainUser.getUserStatus());
			stmt.setInt(9, trainUser.getUserId());
			
			int count = stmt.executeUpdate();
			
			if (count != 1) {
				throw new SQLException("数据库修改失败!");
			} else {
				rs = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DButil.closeAll(con, stmt, null);
		}
		return rs;
	}

	@Override
	public boolean deleteTrainUser(int trainUserId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "delete train_User where user_id = ?";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, trainUserId);
			
			int count = stmt.executeUpdate();
			
			if (count != 1) {
				throw new SQLException("数据库删除失败!");
			} else {
				rs = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DButil.closeAll(con, stmt, null);
		}
		return rs;
	}

	@Override
	public TrainUser findTrainUserById(int trainUserId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select * from Train_User where User_id = ?";
		ResultSet rs = null;
		TrainUser trainUser = null; 
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, trainUserId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				trainUser = new TrainUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return trainUser;
	}

	@Override
	public TrainUser findTrainUserByEmail(String Email) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select * from Train_User where User_Email = ?";
		ResultSet rs = null;
		TrainUser trainUser = null; 
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, Email);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				trainUser = new TrainUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return trainUser;
	}

	@Override
	public List<TrainUser> findTrainUserByPages(int pageNO, int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select USER_ID,USER_EMAIL,USER_PASSWORD,USER_NAME,USER_SEX,IDCARD,PHONE,LAST_LOGIN,USER_STATUS from (Select t.*,rownum rn from Train_user t ) where rn > ? and rn < ?";
		ResultSet rs = null;
		List<TrainUser> trainUsers = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, (pageNO-1)*pageSize);
			stmt.setInt(2, pageNO*pageSize+1);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				trainUsers.add(new TrainUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return trainUsers;
	}

	@Override
	public int findMaxPage(int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select count(*) from Train_User";
		ResultSet rs = null;
		int maxPage = 0;
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				int count = rs.getInt(1);
				maxPage = count / pageSize + (count%pageSize==0?0:1) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return maxPage;
	}
}
