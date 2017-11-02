package com.neuedu.tipd.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.tipd.my12306.bean.Station;
import com.neuedu.tipd.my12306.dao.StationDAO;
import com.neuedu.tipd.my12306.util.DButil;
import com.sun.org.apache.regexp.internal.recompile;

public class StationDAOImpl implements StationDAO {
	
	private Connection con = null;
	
	public Connection getCon() {
		return con;
	}

	public StationDAOImpl() {
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
	public boolean addStation(Station station) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "insert into Station(station_id,station_name,station_sname,railway,station_lv,region,station_address) "
								+ "values(SEQ_STATION.nextval,?,?,?,?,?,?)";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, station.getStationName());
			stmt.setString(2, station.getStationSName());
			stmt.setString(3, station.getRailway());
			stmt.setString(4, station.getStationLv());
			stmt.setString(5, station.getRegion());
			stmt.setString(6, station.getStationaddress());
			
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
	public boolean deleteStation(int stationId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "delete Station where station_Id = ?";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, stationId);
			
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
	public boolean updateStation(Station station) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "update station set station_name = ?,station_sname = ?,"
				+ "railway = ?,station_lv = ?,region = ?,station_address = ? where station_id = ?";
		boolean rs = false;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, station.getStationName());
			stmt.setString(2, station.getStationSName());
			stmt.setString(3, station.getRailway());
			stmt.setString(4, station.getStationLv());
			stmt.setString(5, station.getRegion());
			stmt.setString(6, station.getStationaddress());
			stmt.setInt(7, station.getStationId());
			
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
	public Station findStationById(int stationId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from station where station_Id = ?";
		ResultSet rs = null;
		Station station = null;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, stationId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				station = new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return station;
	}

	@Override
	public Station findStationByName(String stationName) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from station where station_Name = ?";
		ResultSet rs = null;
		Station station = null;
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, stationName);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				station = new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return station;
	}

	@Override
	public List<Station> findStationBySName(String sName) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from station where station_SName like ?";
		ResultSet rs = null;
		List<Station> stations = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, sName);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				stations.add(new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return stations;
	}

	@Override
	public List<Station> findStationByRailway(String railway) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from station where railway = ?";
		ResultSet rs = null;
		List<Station> stations = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, railway);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				stations.add(new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return stations;
	}

	@Override
	public List<Station> findAllStation() {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from station";
		ResultSet rs = null;
		List<Station> stations = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				stations.add(new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return stations;
	}

	@Override
	public List<Station> findStationByPages(int pageNO, int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select station_id,station_name,station_sname,railway,station_lv,region,station_address"
				+ " from (select s.*,rownum rn from Station s) where rn < ? and rn > ?";
		ResultSet rs = null;
		List<Station> stations =  new ArrayList<>();
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, pageNO*pageSize+1);
			stmt.setInt(2, (pageNO-1)*pageSize);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				stations.add(new Station(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return stations;
	}

	@Override
	public int findMaxPage(int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select count(*) from station";
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
