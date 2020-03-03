package com.apap.tu05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu05.model.PilotModel;
import com.apap.tu05.service.PilotService;

@Controller
public class PilotController {
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return "add";
	}
	
	@RequestMapping(value= "/pilot/viewAll")
	public String viewAllPilot(Model model2) {
		List<PilotModel> pilot = pilotService.getAllPilot();
		model2.addAttribute("pilot", pilot);
		return "viewall-pilot.html";	
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	public String viewPilot(@RequestParam(value="licenseNumber") String licenseNumber, Model model) {
			PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
			model.addAttribute("pilot", pilot);
			return "view-pilot";
	}
	
	@RequestMapping(value= "/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
	public String deletePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
			try {
			PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
			pilotService.deletePilot(pilot);
			return "delete.html";	
			}
			catch (Exception e) {
				return "error-message.html";
			}
	}
	
	@RequestMapping(value= "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	public String updatePilot(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		return "update-pilot.html";	
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute PilotModel pilot, Long id) {
		pilotService.addPilot(pilot);
		return "update.html";
	}
}