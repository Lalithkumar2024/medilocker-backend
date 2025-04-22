package com.medilocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medilocker.entity.GraphData;

@Repository
public interface GraphDataRepository extends JpaRepository<GraphData, Integer>{
	

}
