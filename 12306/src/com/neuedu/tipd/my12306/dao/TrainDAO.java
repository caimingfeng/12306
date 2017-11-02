package com.neuedu.tipd.my12306.dao;

import com.neuedu.tipd.my12306.bean.Train;

public interface TrainDAO {
	public void addTrain(Train train);
	public void deleteTrain(int trainId);
	public void updateTrain(Train train);
	public Train findTrainById(String trainId);
}
