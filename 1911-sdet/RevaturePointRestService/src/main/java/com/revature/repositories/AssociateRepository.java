package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Associate;

@Repository
public interface AssociateRepository extends CrudRepository<Associate, Integer>{

	List<Associate> findByName(String name);
	List<Associate> findByPoints(int points);
	List<Associate> findByNameAndPoints(String name, int points);
}
