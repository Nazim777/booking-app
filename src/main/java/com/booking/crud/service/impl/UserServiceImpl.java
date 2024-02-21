package com.booking.crud.service.impl;

import com.booking.crud.dto.UserDto;
import com.booking.crud.dto.mapper.UserMappper;
import com.booking.crud.entity.User;
import com.booking.crud.repository.UserRepository;
import com.booking.crud.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepositry){
        this.userRepository = userRepositry;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMappper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMappper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found!"));
        return UserMappper.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user)->UserMappper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, String name) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        user.setName(name);
        User savedUser = userRepository.save(user);
        return UserMappper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
        userRepository.deleteById(id);

    }
}
