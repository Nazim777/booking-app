package com.booking.crud.service;


import com.booking.crud.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
    UserDto updateUser(Long id,String name);
    void deleteUser(Long id);

}
