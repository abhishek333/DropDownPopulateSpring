package com.asn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asn.dao.ICountryDAO;
import com.asn.entity.Country;
import com.asn.entity.State;

@Repository
public class CountryDAO implements ICountryDAO {

	@Autowired private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Country save(Country country) {		
		getSession().saveOrUpdate(country);
		return getByName(country.getName());
	}

	@Override
	public Country get(Integer id) {
		return (Country) getSession().get(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> list() {
		String hql = "from "+Country.class.getName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public State getState(Integer stateId) {	
		return (State) getSession().get(State.class, stateId);
	}

	@Override
	public List<State> getStatesByCountryId(Integer id) {				
		return new ArrayList<State>(get(id).getStates());
	}

	@Override
	public Country getByName(String name) {
		String hql = "from "+Country.class.getName()+" where name = '"+name+"'";
		return (Country) getSession().createQuery(hql).uniqueResult();
	}

}
