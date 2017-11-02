package com.neuedu.tipd.my12306.service.impl;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Circuit;
import com.neuedu.tipd.my12306.dao.CircuitDAO;
import com.neuedu.tipd.my12306.dao.impl.CircuitDAOImpl;
import com.neuedu.tipd.my12306.service.CircuitService;

/*
 * 线路Service实现
 */

public class CircuitServiceImpl implements CircuitService {
	
	private CircuitDAO ccdao = new CircuitDAOImpl();
	
	@Override
	public boolean addCircuit(Circuit circuit) {
		boolean result = ccdao.addCircuit(circuit);
		return result;
	}

	@Override
	public boolean deleteCircuit(int circuitId) {
		boolean result = ccdao.deleteCircuit(circuitId);
		return result;
	}

	@Override
	public boolean updateCircuit(Circuit circuit) {
		boolean result = ccdao.updateCircuit(circuit);
		return result;
	}

	@Override
	public Circuit findCircuitById(int CircuitId) {
		Circuit circuit = null;
		circuit = ccdao.findCircuitById(CircuitId);
		return circuit;
	}

	@Override
	public List<Circuit> findCircuitBySName(int stationId) {
		List<Circuit> circuits = null;
		circuits = ccdao.findCircuitBySName(stationId);
		return circuits;
	}

	@Override
	public List<Circuit> findCircuitByTrainId(String trainId) {
		List<Circuit> circuits = null;
		circuits = ccdao.findCircuitByTrainId(trainId);
		return circuits;
	}

	@Override
	public List<Circuit> findCircuitByPage(int pageNO, int pageSize) {
		List<Circuit> circuits = null;
		circuits = ccdao.findCircuitByPage(pageNO,pageSize);
		return circuits;
	}

	@Override
	public int findMaxPage(int pageSize) {
		int maxPage = 0;
		maxPage = ccdao.findMaxPage(pageSize);
		return maxPage;
	}

	@Override
	public List<Circuit> queryService(String trainId, int stationId) {
		//System.out.println("条件查询");
		return ccdao.queryDao(trainId, stationId);
	}

}
