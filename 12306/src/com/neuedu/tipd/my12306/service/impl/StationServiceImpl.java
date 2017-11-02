package com.neuedu.tipd.my12306.service.impl;

import java.util.List;

import com.neuedu.tipd.my12306.bean.Station;
import com.neuedu.tipd.my12306.dao.StationDAO;
import com.neuedu.tipd.my12306.dao.impl.StationDAOImpl;
import com.neuedu.tipd.my12306.service.StationService;

public class StationServiceImpl implements StationService {
	
	StationDAO sdao = new StationDAOImpl();
	
	@Override
	public boolean addStation(Station station) {
		boolean result = sdao.addStation(station);
		return result;
	}

	@Override
	public boolean deleteStation(int stationId) {
		boolean result = sdao.deleteStation(stationId);
		return result;
	}

	@Override
	public boolean updateStation(Station station) {
		boolean result = sdao.updateStation(station);
		return result;
	}

	@Override
	public Station findStationById(int StationId) {
		Station station = sdao.findStationById(StationId);
		return station;
	}

	@Override
	public Station findStationByName(String stationName) {
		Station station = sdao.findStationByName(stationName);
		return station;
	}

	@Override
	public List<Station> findStationBySName(String sName) {
		List<Station> stations = sdao.findStationBySName(sName);
		return stations;
	}

	@Override
	public List<Station> findStationByRailway(String railway) {
		List<Station> stations = sdao.findStationByRailway(railway);
		return stations;
	}

	@Override
	public List<Station> findAllStation() {
		List<Station> stations = sdao.findAllStation();
		return stations;
	}

	@Override
	public List<Station> findStationByPages(int pageNO, int pageSize) {
		List<Station> stations = sdao.findStationByPages(pageNO, pageSize);
		return stations;
	}

	@Override
	public int findMaxPage(int pageSize) {
		int maxPage = sdao.findMaxPage(pageSize);
		return maxPage;
	}

}
