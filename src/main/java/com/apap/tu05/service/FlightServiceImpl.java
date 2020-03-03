package com.apap.tu05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;
import com.apap.tu05.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override
	public List<FlightModel> getAllFlight(){
		return flightDb.findAll();
	}

	@Override
	public void deleteFlight(PilotModel pilot, String flightNumber) {
		flightDb.deleteByPilotAndFlightNumber(pilot, flightNumber);
	}

	@Override
	public FlightModel getFlight(PilotModel pilot, String flightNumber) {
		return flightDb.findByPilotAndFlightNumber(pilot, flightNumber);
	}

	@Override
	public void updateFlight(FlightModel flight) {
		flightDb.save(flight);
		
	}

	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
		
	}
}