package com.asn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asn.dao.ICountryDAO;
import com.asn.entity.Country;
import com.asn.entity.State;
import com.asn.service.ICountryService;

@Service
public class CountryService implements ICountryService {

	@Autowired private ICountryDAO countryDAO;
	
	@Override
	public Country save(Country country) {
		return countryDAO.save(country);
	}

	@Transactional(readOnly=true)
	@Override
	public Country get(Integer id) {		
		return countryDAO.get(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Country getByName(String name) {
		return countryDAO.getByName(name);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Country> list() {
		return countryDAO.list();
	}

	@Transactional(readOnly=true)
	@Override
	public State getState(Integer stateId) {
		return countryDAO.getState(stateId);
	}

	@Transactional(readOnly=true)
	@Override
	public List<State> getStatesByCountryId(Integer id) {
		return countryDAO.getStatesByCountryId(id);
	}

}
