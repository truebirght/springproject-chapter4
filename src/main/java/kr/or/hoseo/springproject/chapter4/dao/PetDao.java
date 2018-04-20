package kr.or.hoseo.springproject.chapter4.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.or.hoseo.springproject.chapter4.vo.Pet;

@Repository
public interface PetDao extends CrudRepository<Pet,Integer> {
	public List<Pet> findByName(String name);
}
