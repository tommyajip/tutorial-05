package com.apap.tu05.service;
import java.util.List;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	List<FlightModel> getAllFlight();
	void deleteFlight(PilotModel pilot, String flightNumber);
	FlightModel getFlight(PilotModel pilot, String flightNumber);
	void updateFlight(FlightModel flight);
	void deleteFlightById(long id);
}