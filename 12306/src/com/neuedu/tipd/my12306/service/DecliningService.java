package com.neuedu.tipd.my12306.service;

import com.neuedu.tipd.my12306.bean.Declining;

/*
 * 递远递减率
 */

public interface DecliningService {
	
	/*
	 * 按ID修改
	 * 
	 * @author Game
	 * 
	 * @Param Declining
	 * 
	 * @return boolean
	 */
	public boolean updateDeclining(Declining declining);
	
	/*
	 * 按ID查找
	 * 
	 * @author Game
	 * 
	 * @Param int DecliningId
	 * 
	 * @return Declining
	 */
	public Declining findDecliningById(int DecliningId);
	
	/*
	 * 新增
	 * 
	 * @author Game
	 * 
	 * @Param Declining
	 * 
	 * @return boolean
	 * 
	 */
	public boolean addDeclining(Declining declining);
	
	/*
	 * 删除
	 * 
	 * @author Game
	 * 
	 * @Param int decliningId
	 * 
	 * @return boolean
	 * 
	 */
	public boolean deleteDeclining(int decliningId);
}
