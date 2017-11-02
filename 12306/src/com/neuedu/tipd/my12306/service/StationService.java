package com.neuedu.tipd.my12306.service;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Station;

public interface StationService {
	/*
	 * 增加车站信息
	 * 
	 * @author Game
	 * 
	 * @Param Station
	 * 
	 * @return boolean
	 */
	public boolean addStation(Station station);
	
	/*
	 * 删除车站信息
	 * 
	 * @author Game
	 * 
	 * @Param int stationId 
	 * 
	 * @return boolean 
	 * 
	 * 如果要删除的车站已经售票，不能删除。
	 */
	public boolean deleteStation(int stationId);
	
	/*
	 * 修改车站信息
	 * 
	 * @author Game
	 * 
	 * @Param Station
	 * 
	 * @return boolean
	 * 
	 * 按照车站ID修改
	 */
	public boolean updateStation(Station station);
	
	/*
	 * 按照ID查找车站信息
	 *
	 * @author Game
	 * 
	 * @Param int
	 * 
	 * @return Station
	 * 
	 */
	public Station findStationById(int Station);
	/*
	 * 按车站名查找
	 */
	public Station findStationByName(String stationName);
	/*
	 * 按拼音首字母查找
	 */
	public List<Station> findStationBySName(String sName);
	/*
	 * 按铁路局查找
	 */
	public List<Station> findStationByRailway(String railway);
	/*
	 * 查找全部
	 */
	public List<Station> findAllStation();
	/*
	 * 分页查找
	 */
	public List<Station> findStationByPages(int pageNO,int pageSize);
	
	/*
	 * 查找最大页数 
	 */
	public int findMaxPage(int pageSize);
}
