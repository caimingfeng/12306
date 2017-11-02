package com.neuedu.tipd.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.neuedu.tipd.my12306.bean.Circuit;
import com.neuedu.tipd.my12306.dao.CircuitDAO;
import com.neuedu.tipd.my12306.util.DButil;

public class CircuitDAOImpl implements CircuitDAO {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public CircuitDAOImpl() {
		// 构造时直接进行连接s
		con = DButil.getConnection();
	}

	public void closeAll() {
		// 结束前调用此方法
		DButil.closeAll(con, null, null);
	}

	public void reConnection() {
		// 若提前结束则用此方法重启
		if (con != null) {
			DButil.closeAll(con, null, null);
		}
		con = DButil.getConnection();
	}

	@Override
	public boolean addCircuit(Circuit circuit) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "insert into Circuit(Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO)"
				+ "values(SEQ_CIRCUIT.nextval,?,?,?,?,?,?,?,?)";
		boolean rs = false;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, circuit.getTrainId());
			stmt.setInt(2, circuit.getStationId());
			stmt.setTimestamp(3, new Timestamp(circuit.getStartTime().getTime()));
			stmt.setTimestamp(4, new Timestamp(circuit.getEndTime().getTime()));
			stmt.setString(5, circuit.getMileage());
			stmt.setTimestamp(6, new Timestamp(circuit.getStayTime().getTime()));
			stmt.setTimestamp(7, new Timestamp(circuit.getTakeTime().getTime()));
			stmt.setInt(8, circuit.getStationNo());

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
	public boolean deleteCircuit(int circuitId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "delete from circuit where Circuit_Id = ?";
		boolean rs = false;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, circuitId);

			int count = stmt.executeUpdate();
			System.out.println("count的值:" + count);
			if (count < 0) {
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
	public boolean updateCircuit(Circuit circuit) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "update Circuit set TRAIN_ID = ?,STATION_ID = ?,START_TIME = ?,END_TIME = ?,MILEAGE = ?,STAY_TIME = ?,TAKE_TIME = ?,STATION_NO = ? where Circuit_Id = ?";
		boolean rs = false;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, circuit.getTrainId());
			stmt.setInt(2, circuit.getStationId());
			stmt.setTimestamp(3, new Timestamp(circuit.getStartTime().getTime()));
			stmt.setTimestamp(4, new Timestamp(circuit.getEndTime().getTime()));
			stmt.setString(5, circuit.getMileage());
			stmt.setTimestamp(6, new Timestamp(circuit.getStayTime().getTime()));
			stmt.setTimestamp(7, new Timestamp(circuit.getTakeTime().getTime()));
			stmt.setInt(8, circuit.getStationNo());
			stmt.setInt(9, circuit.getCircuitId());

			int count = stmt.executeUpdate();

			if (count != 1) {
				throw new SQLException("数据库更新失败!");
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
	public Circuit findCircuitById(int CircuitId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from circuit where Circuit_ID = ? ";
		ResultSet rs = null;
		Circuit circuit = null;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, CircuitId);

			rs = stmt.executeQuery();

			while (rs.next()) {
				circuit = new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getString(6), rs.getTimestamp(7), rs.getTimestamp(8), rs.getInt(9));
				System.out.println(circuit.getStartTime());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return circuit;
	}

	@Override
	public List<Circuit> findCircuitBySName(int stationID) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from circuit where Station_ID = ?";
		ResultSet rs = null;
		List<Circuit> circuits = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, stationID);

			rs = stmt.executeQuery();

			while (rs.next()) {
				circuits.add(new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getString(6), rs.getTimestamp(7), rs.getTimestamp(8), rs.getInt(9)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return circuits;
	}

	@Override
	public List<Circuit> findCircuitByTrainId(String trainId) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from circuit where Train_Id = ?";
		ResultSet rs = null;
		List<Circuit> circuits = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, trainId);

			rs = stmt.executeQuery();

			while (rs.next()) {
				circuits.add(new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getInt(9)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return circuits;
	}

	@Override
	public List<Circuit> findCircuitByPage(int pageNO, int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from (select c.*,rownum rn from Circuit c) where rn > ? and rn < ?";
		ResultSet rs = null;
		List<Circuit> circuits = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, (pageNO - 1) * pageSize);
			stmt.setInt(2, pageNO * pageSize + 1);

			rs = stmt.executeQuery();

			while (rs.next()) {
				circuits.add(new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getString(6), rs.getTimestamp(7), rs.getTimestamp(8), rs.getInt(9)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DButil.closeAll(con, stmt, rs);
		}
		return circuits;
	}

	@Override
	public int findMaxPage(int pageSize) {
		reConnection();
		PreparedStatement stmt = null;
		String sql = "select count(*) from circuit";
		ResultSet rs = null;
		int maxPage = 0;

		try {
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				int count = rs.getInt(1);
				maxPage = count / pageSize + (count % pageSize == 0 ? 0 : 1);
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

	@Override
	public List<Circuit> fuzzyQuery2(String trainId, int stationId) {
		List<Circuit> list = new ArrayList<>();
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from circuit where 5>2 ";
		PreparedStatement statm = null;
		ResultSet rs = null;
		int i = 0;
		java.util.Map<String, Integer> map = new HashMap<>();
		try {

			if (!trainId.equals("")) {
				sql = sql + "and Train_Id = ?";
				map.put("trainId", ++i);
			}
			if (stationId != -1) {
				sql = sql + "and Station_ID = ?";
				map.put("stationId", ++i);
			}
			if (con==null) {
				System.out.println("已关闭数据库连接");
				return null;
			}
			statm = con.prepareStatement("select * from circuit");
			System.out.println(i);
			if (map.containsKey("stationId")) {
				statm.setInt(map.get("stationId").intValue(), stationId);
			}
			if (map.containsKey("trainId")) {
				statm.setString(map.get("trainId").intValue(), trainId);

			}

			rs = statm.executeQuery();
			while (rs.next()) {
				list.add(new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeAll(con, statm, rs);
		}
		return list;
	}

	@Override
	public List<Circuit> queryDao(String trainId, int stationId) {
		reConnection();
		List<Circuit> list = new ArrayList<>();
		
		String sql = "select Circuit_ID,TRAIN_ID,STATION_ID,START_TIME,END_TIME,MILEAGE,STAY_TIME,TAKE_TIME,STATION_NO from circuit where 5>2 ";
		PreparedStatement statm = null;
		ResultSet rs = null;
		
		int i = 0;
		java.util.Map<String, Integer> map = new HashMap<>();
		try {

			if (!trainId.equals("")) {
				sql = sql + "and Train_Id = ?";
				map.put("trainId", ++i);
			}
			if (stationId != -1) {
				sql = sql + "and Station_ID = ?";
				map.put("stationId", ++i);
			}
			if (con==null) {
				System.out.println("已关闭数据库连接");
				return null;
			}
			System.out.println(sql);
			statm = con.prepareStatement(sql);
			System.out.println(i);
			if (map.containsKey("stationId")) {
				statm.setInt(map.get("stationId").intValue(), stationId);
			}
			if (map.containsKey("trainId")) {
				statm.setString(map.get("trainId").intValue(), trainId);

			}

			rs = statm.executeQuery();
			while (rs.next()) {
				list.add(new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.closeAll(con, statm, rs);
		}
		return list;
	}

}
