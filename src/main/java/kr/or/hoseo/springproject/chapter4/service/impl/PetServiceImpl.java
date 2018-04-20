package kr.or.hoseo.springproject.chapter4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.or.hoseo.springproject.chapter4.dao.PetDao;
import kr.or.hoseo.springproject.chapter4.service.PetService;
import kr.or.hoseo.springproject.chapter4.vo.Pet;

public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetDao dao;
	
	public List<Pet> findByName(String name){
		return dao.findByName(name);
	}
}
