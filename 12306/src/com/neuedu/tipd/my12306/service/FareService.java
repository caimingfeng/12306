package com.neuedu.tipd.my12306.service;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Fare;

/*
 * 票价率
 */

public interface FareService {
	
	/*
	 * 修改票价
	 * 
	 * @author Game
	 * 
	 * @Param Fare
	 * 
	 * @return boolean
	 */
	public boolean updateFare(Fare fare);  
	/*
	 * 按票种查找
	 * 
	 * @author Game
	 * 
	 * @Param String
	 * 
	 * @return List<Fare>
	 */
	public List<Fare> findFareBytype(String fareType);
	/*
	 * 按ID查找
	 * 
	 * @author Game
	 * 
	 * @Param int
	 * 
	 * @return Fare
	 */
	public Fare findFareById(int fareId);
	/*
	 * 新增
	 * 
	 * @author Game
	 * 
	 * @Param Fare
	 * 
	 * @return boolean
	 */
	public boolean addFare(Fare fare);
	/*
	 * 删除
	 * 
	 * @author Game
	 * 
	 * @Param int
	 * 
	 * @return boolean
	 */
	public boolean deleteFare(int fareId);
}
