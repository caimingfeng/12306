package com.neuedu.tipd.my12306.dao;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Circuit;

public interface CircuitDAO {

	/*
	 * 增加线路信息ss
	 * 
	 * @author Game
	 * 
	 * @Param Circuit
	 * 
	 * @return boolean
	 */
	public boolean addCircuit(Circuit circuit);
	
	/*
	 * 删除线路信息
	 * 
	 * @author Game
	 * 
	 * @Param int circuitId 
	 * 
	 * @return boolean 
	 * 
	 * 如果要删除的车站已经售票，不能删除。
	 */
	public boolean deleteCircuit(int circuitId);
	
	/*
	 * 修改线路信息
	 * 
	 * @author Game
	 * 
	 * @Param Circuit
	 * 
	 * @return boolean
	 * 
	 * 按照线路ID修改
	 */
	public boolean updateCircuit(Circuit circuit);
	
	/*
	 * 按照ID查找线路信息
	 *
	 * @author Game
	 * 
	 * @Param int
	 * 
	 * @return Circuit
	 * 
	 */
	public Circuit findCircuitById(int CircuitId);
	
	/*
	 * 按照站名查找线路
	 * 
	 * @author Game
	 * 
	 * @Param String
	 * 
	 * @return List<Circuit>
	 */
	public List<Circuit> findCircuitBySName(int stationID);
	
	/*
	 * 按照车次查找线路
	 * 
	 * @author Game
	 * 
	 * @Param String
	 * 
	 * @return List<Circuit>
	 */
	public List<Circuit> findCircuitByTrainId(String trainId);
	
	/*
	 * 分页查找
	 * 
	 * @aucthor Game
	 * 
	 * @Param int , int
	 * 
	 * @return List<Circuit>
	 */
	public List<Circuit> findCircuitByPage(int pageNO,int pageSize);
	/*
	 * 查询最大页数
	 */
	public int findMaxPage(int pageSize);
	public List<Circuit> fuzzyQuery2(String trainId, int stationId);

	public List<Circuit> queryDao(String trainId, int stationId);
}
