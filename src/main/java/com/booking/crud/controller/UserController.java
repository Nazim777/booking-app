package com.booking.crud.controller;

import com.booking.crud.dto.UserDto;
import com.booking.crud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    // create user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return  new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserByid( @PathVariable  Long id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
  }

  @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
      List<UserDto> userDtos = userService.getAllUser();
      return ResponseEntity.ok(userDtos);
  }
  @PutMapping("/{id}")
    public  ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody Map<String, String> request){
      String name = request.get("name");
      UserDto userDto = userService.updateUser(id,name);
      return ResponseEntity.ok(userDto);
  }


  @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable  Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");

  }
}

