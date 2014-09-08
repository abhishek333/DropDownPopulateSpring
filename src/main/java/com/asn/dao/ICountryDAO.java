package com.asn.dao;

import java.util.List;

import com.asn.entity.Country;
import com.asn.entity.State;

public interface ICountryDAO {

	Country save(Country country);
	Country get(Integer id);
	Country getByName(String name);
	List<Country> list();
	State getState(Integer stateId);
	List<State> getStatesByCountryId(Integer id);
	
}
