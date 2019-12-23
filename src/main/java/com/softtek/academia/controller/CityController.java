package com.softtek.academia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.softtek.academia.entity.City;
import com.softtek.academia.service.CityService;
import com.softtek.academia.service.StateService;

@Controller
public class CityController {
	// Constructor based Dependency Injection
	private CityService cityService;

	public CityController() {

	}

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	@Autowired
	private StateService stateService;

//	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
//	public ModelAndView hello2(HttpServletResponse response) throws IOException {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
//		return mv;
//	}

	// Get All Users
	@RequestMapping(value = "/allCities", method = RequestMethod.POST)
	public ModelAndView displayAllCites() {
		System.out.println("User Page Requested : All Cities");
		ModelAndView mv = new ModelAndView();
		List<City> cityList = cityService.getAllCities();
		mv.addObject("cityList", cityList);
		mv.setViewName("allCities");
		return mv;
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.GET)
	public ModelAndView displayNewCityForm() {
		ModelAndView mv = new ModelAndView("addCity");
		mv.addObject("headerMessage", "Add City Details");
		mv.addObject("city", new City());
		mv.addObject("stateList", stateService.getAllStates());
		return mv;
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.POST)
	public ModelAndView saveNewCity(@ModelAttribute City city, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");

		if (result.hasErrors()) {
			return new ModelAndView("error");
		}
		boolean isAdded = cityService.saveCity(city);
		if (isAdded) {
			mv.addObject("message", "New city successfully added");
		} else {
			return new ModelAndView("error");
		}

		return mv;
	}

	@RequestMapping(value = "/editCity/{id}", method = RequestMethod.GET)
	public ModelAndView displayEditCityForm(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/editCity");
		City city = cityService.getCityById(id);
		mv.addObject("headerMessage", "Edit City Details");
		mv.addObject("city", city);
		mv.addObject("stateList", stateService.getAllStates());
		return mv;
	}

	@RequestMapping(value = "/editCity/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedCity(@ModelAttribute City city, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/home");

		if (result.hasErrors()) {
			System.out.println(result.toString());
			return new ModelAndView("error");
		}
		boolean isSaved = cityService.saveCity(city);
		if (!isSaved) {

			return new ModelAndView("error");
		}

		return mv;
	}

	@RequestMapping(value = "/deleteCity/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCityById(@PathVariable Long id) {
		boolean isDeleted = cityService.deleteCityById(id);
		System.out.println("City deletion respone: " + isDeleted);
		ModelAndView mv = new ModelAndView("redirect:/home");
		return mv;

	}

}
