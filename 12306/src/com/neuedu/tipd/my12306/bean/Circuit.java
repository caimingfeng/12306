package com.neuedu.tipd.my12306.bean;
import java.io.Serializable;
/*
 * 线路管理
 * 
 * @aucthor Game
 * 
 * @property 
 * 
 * @Param
 * 
 */
import java.util.Date;

public class Circuit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int circuitId;
	private String trainId;
	private int stationId;
	private Date startTime;
	private Date endTime;
	private String mileage;
	private Date stayTime;
	private Date takeTime;
	private int stationNo;
	
	
	
	public Circuit(int circuitId, String trainId, int stationId, Date startTime, Date endTime, String mileage,
			Date stayTime, Date takeTime, int stationNo) {
		super();
		this.circuitId = circuitId;
		this.trainId = trainId;
		this.stationId = stationId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mileage = mileage;
		this.stayTime = stayTime;
		this.takeTime = takeTime;
		this.stationNo = stationNo;
	}
	public Circuit() {
		super();
	}

	public int getCircuitId() {
		return circuitId;
	}
	public void setCircuitId(int circuitId) {
		this.circuitId = circuitId;
	}
	public String getTrainId() {
		return trainId;
	}
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public Date getStayTime() {
		return stayTime;
	}
	public void setStayTime(Date stayTime) {
		this.stayTime = stayTime;
	}
	public Date getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}
	public int getStationNo() {
		return stationNo;
	}
	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}
	
	
}
