package com.asn.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asn.entity.State;
import com.asn.service.ICountryService;

@Controller
public class IndexController {

	@Autowired private ICountryService countryService;
	
	private final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		LOG.info("GET came to /");
		model.addAttribute("countries", countryService.list());
		return "index";
	}

	@RequestMapping(value="/getstates/{countryId}", method=RequestMethod.GET)
	public @ResponseBody List<State> getStates(Model model, @PathVariable("countryId")Integer countryId){
		LOG.info("GET came to /{countryId}/getstates with country id: {}",countryId);		
		return countryService.getStatesByCountryId(countryId);
	}
		
}
