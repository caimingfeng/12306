package com.neuedu.tipd.my12306.service.impl;

import com.neuedu.tipd.my12306.bean.TrainUser;
import com.neuedu.tipd.my12306.dao.TrainUserDAO;
import com.neuedu.tipd.my12306.dao.impl.TrainUserDAOImpl;
import com.neuedu.tipd.my12306.service.TrainUserService;

public class TrainUserServiceImpl implements TrainUserService {
	
	private TrainUserDAO tudao = new TrainUserDAOImpl();
	
	@Override
	public boolean addTrainUser(TrainUser trainUser) {
		boolean result = tudao.addTrainUser(trainUser);
		return result;
	}

	@Override
	public boolean deleteTrainUser(int trainUserId) {
		boolean result = tudao.deleteTrainUser(trainUserId);
		return result;
	}

	@Override
	public boolean updateTrainUser(TrainUser trainUser) {
		boolean result = tudao.updateTrainUser(trainUser);
		return result;
	}

	@Override
	public TrainUser findTrainUserById(int TrainUserId) {
		TrainUser trainUser= tudao.findTrainUserById(TrainUserId);
		return trainUser;
	}

	@Override
	public TrainUser findTrainUserByEmail(String Email) {
		TrainUser trainUser= tudao.findTrainUserByEmail(Email);
		return trainUser;
	}

	@Override
	public int findMaxPage(int pageSize) {
		int maxPage = tudao.findMaxPage(pageSize);
		return maxPage;
	}

}
