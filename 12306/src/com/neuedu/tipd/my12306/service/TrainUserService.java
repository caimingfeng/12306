package com.neuedu.tipd.my12306.service;

import java.util.List;

import com.neuedu.tipd.my12306.bean.TrainUser;

public interface TrainUserService{
	
	/*
	 * 增加用户信息
	 * 
	 * @author Game
	 * 
	 * @Param TrainUser
	 * 
	 * @return boolean
	 */
	public boolean addTrainUser(TrainUser trainUser);
	
	/*
	 * 删除用户信息
	 * 
	 * @author Game
	 * 
	 * @Param int trainUserId 
	 * 
	 * @return boolean 
	 * 
	 * 如果要删除的车站已经售票，不能删除。
	 */
	public boolean deleteTrainUser(int trainUserId);
	
	/*
	 * 修改用户信息
	 * 
	 * @author Game
	 * 
	 * @Param TrainUser
	 * 
	 * @return boolean
	 * 
	 * 按照用户ID修改
	 */
	public boolean updateTrainUser(TrainUser trainUser);
	
	/*
	 * 按照ID查找用户信息
	 *
	 * @author Game
	 * 
	 * @Param int
	 * 
	 * @return TrainUser
	 * 
	 */
	public TrainUser findTrainUserById(int TrainUserId);
	
	/*
	 * 按照用户邮箱查找用户信息
	 * 
	 * @author Game
	 * 
	 * @Param String
	 * 
	 * @return TrainUser
	 */
	public TrainUser findTrainUserByEmail(String Email);
	
	/*
	 * 查找最大页数 
	 */
	public int findMaxPage(int pageSize);
}
