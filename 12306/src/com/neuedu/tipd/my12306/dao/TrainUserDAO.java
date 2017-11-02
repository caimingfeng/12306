package com.neuedu.tipd.my12306.dao;

import java.util.List;

import com.neuedu.tipd.my12306.bean.TrainUser;

public interface TrainUserDAO {
	/*
	 * 新增用户
	 */
	public boolean addTrainUser(TrainUser trainUser);
	/*
	 * 修改用户
	 */
	public boolean updateTrainUser(TrainUser trainUser);
	/*
	 * 删除用户
	 */
	public boolean deleteTrainUser(int trainUserId);
	/*
	 * 按ID查找用户
	 */
	public TrainUser findTrainUserById(int TrainUserId);
	/*
	 * 按邮箱账号查找用户
	 */
	public TrainUser findTrainUserByEmail(String Email);
	/*
	 * 分页查找用户
	 */
	public List<TrainUser> findTrainUserByPages(int pageNO,int pageSize);
	/*
	 * 查找最大页数
	 */
	public int findMaxPage(int pageSize);
}
