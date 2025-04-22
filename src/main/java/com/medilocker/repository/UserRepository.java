package com.medilocker.repository;

import com.medilocker.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findByEmailIdAndRole(String emailId,String role);
    
    public Users findByNameAndDateOfBirth(String name,LocalDate dateOfBirth);
    
    public Users findByEmailId(String emailId);
}
