package com.apap.tu05.service;
import java.util.List;

import com.apap.tu05.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	List<PilotModel> getAllPilot();
	void deletePilot(PilotModel pilot);
}