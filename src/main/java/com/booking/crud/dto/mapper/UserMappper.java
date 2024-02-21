package com.booking.crud.dto.mapper;

import com.booking.crud.dto.UserDto;
import com.booking.crud.entity.User;

public class UserMappper {
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail()

        );
        return user;
    }

    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        return userDto;
    }
}
