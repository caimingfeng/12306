package com.neuedu.tipd.my12306.bean;

public class Station {
	private int stationId;
	private String stationName;
	private String stationSName;
	private String railway;
	private String stationLv;
	private String region;
	private String stationaddress;
	
	public Station(int stationId, String stationName, String stationSName, String railway, String stationLv,
			String region, String stationaddress) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationSName = stationSName;
		this.railway = railway;
		this.stationLv = stationLv;
		this.region = region;
		this.stationaddress = stationaddress;
	}
	
	public Station() {
		super();
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationSName() {
		return stationSName;
	}
	public void setStationSName(String stationSName) {
		this.stationSName = stationSName;
	}
	public String getRailway() {
		return railway;
	}
	public void setRailway(String railway) {
		this.railway = railway;
	}
	public String getStationLv() {
		return stationLv;
	}
	public void setStationLv(String stationLv) {
		this.stationLv = stationLv;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStationaddress() {
		return stationaddress;
	}
	public void setStationaddress(String stationaddress) {
		this.stationaddress = stationaddress;
	}
}
