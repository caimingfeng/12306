package com.neuedu.tipd.my12306.test;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Circuit;
import com.neuedu.tipd.my12306.dao.CircuitDAO;
import com.neuedu.tipd.my12306.dao.impl.CircuitDAOImpl;

/**
* @author 蔡名锋:
* @version 创建时间：2017年10月16日 下午2:50:13
* 类说明
*/
public class TestCircuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircuitDAO dao = new CircuitDAOImpl();
		String trainId = "9999";
		int stationId = -1;
		List<Circuit> list = dao.fuzzyQuery2(trainId, stationId);
		if (list==null) {
			System.out.println("没有数据");
		}
		for (Circuit circuit : list) {
			System.out.println(" stationId:" + circuit.getTrainId() + " stationId:" + circuit.getStationId());
		}

	}

}
