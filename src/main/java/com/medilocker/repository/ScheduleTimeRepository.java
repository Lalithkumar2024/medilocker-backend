package com.medilocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medilocker.entity.ScheduleTime;

@Repository
public interface ScheduleTimeRepository extends JpaRepository<ScheduleTime, Integer>{

}
