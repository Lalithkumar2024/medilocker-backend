package com.medilocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilocker.entity.Users;
import com.medilocker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/addUser")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @GetMapping("/getUser/{user_id}")
    public Users getUser(@PathVariable int user_id){
        return userService.getUser(user_id);
    }

    @GetMapping("/getAllUser")
    public List<Users> getALLUser(){
        return userService.getAllUser();
    }

    @PutMapping("/updateUser/{user_id}")
    public Users updateUser(@RequestBody Users user , @PathVariable int user_id){
        return userService.updateUser(user,user_id);
    }

    @DeleteMapping("deleteUser/{user_id}")
    public Users deleteUser(@PathVariable int user_id){
        return userService.deleteUser(user_id);
    }

    @SuppressWarnings("unchecked")
	@PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user){

        Users users = userService.findByEmailIdAndRole(user.getEmailId(), user.getRole());

        if(passwordEncoder.matches(user.getPassword(), users.getPassword()) || user.getPassword().equals(users.getPassword())){
            return ResponseEntity.ok(users);
        }
        else{
            return (ResponseEntity<Users>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }
    }
    
    @SuppressWarnings("unchecked")
	@PostMapping("/emergenceLogin")
    public ResponseEntity<Users> emergenceLogin(@RequestBody Users user) {
        Users users = userService.findByNameAndDateOfBirth(user.getName(), user.getDateOfBirth());

        if (users == null) {
        	return (ResponseEntity<Users>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        if (!"patient".equalsIgnoreCase(users.getRole())) {
        	return (ResponseEntity<Users>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }

        if (user.getName().equals(users.getName()) && user.getDateOfBirth().equals(users.getDateOfBirth())) {
            return ResponseEntity.ok(users);
        } else {
        	return (ResponseEntity<Users>) ResponseEntity.status(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/forgetpassword")
    public Users forgetPassword(@RequestBody Users user) {
    	return userService.forgetPassword(user.getEmailId(), user.getPassword());
    }

}
