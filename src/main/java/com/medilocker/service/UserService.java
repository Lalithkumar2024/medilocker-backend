package com.medilocker.service;

import com.medilocker.entity.Doctor;
import com.medilocker.entity.Patient;
import com.medilocker.entity.Users;
import com.medilocker.exception.CustomException;
import com.medilocker.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Users addUser(Users user){
    	
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if("DOCTOR".equalsIgnoreCase(user.getRole())){
            Doctor doctor = new Doctor();
            doctor.setUsers(user);
            doctor.setDoctorName(user.getName());
            user.setDoctor(doctor);
        } else if ("PATIENT".equalsIgnoreCase(user.getRole())) {
            Patient patient = new Patient();
            patient.setUsers(user);
            patient.setPatientName(user.getName());
            user.setPatient(patient);
        }

        return userRepository.save(user);
    }

    public Users getUser(int user_id){
        Optional<Users> user = userRepository.findById(user_id);
        if (user.isPresent()){
            return user.get();
        }else {
            throw new CustomException("Users","user_id",user_id);
        }
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    public Users updateUser(Users user, int user_id){
        Users newUser = userRepository.findById(user_id)
                         .orElseThrow(()-> new CustomException("Users","user_id",user_id));
        newUser.setName(user.getName());
        newUser.setEmailId(user.getEmailId());
        newUser.setPhone(user.getPhone());
        newUser.setAddress(user.getAddress());
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setGender(user.getGender());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());

        return userRepository.save(newUser);
    }

    public Users deleteUser(int user_id){
        Users user = userRepository.findById(user_id)
                .orElseThrow(()-> new CustomException("Users","user_id",user_id));
        userRepository.delete(user);
        return user;
    }

    public Users findByEmailIdAndRole(String emailId,String role){
        return userRepository.findByEmailIdAndRole(emailId,role);
    }
    
    public Users findByNameAndDateOfBirth(String name,LocalDate dateOfBirth) {
    	return userRepository.findByNameAndDateOfBirth(name, dateOfBirth);
    }

    public Users findByEmailId(String emailId) {
    	return userRepository.findByEmailId(emailId);
    }

    public Users forgetPassword(String emailId,String password) {
    	Users user = userRepository.findByEmailId	(emailId);
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return userRepository.save(user);
    }
}
