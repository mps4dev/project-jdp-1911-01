package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapToUserDto(final User user) {
        if (user == null) return null;
        return new UserDto(
                user.getId(),
                user.getName(),
                user.isBlocked());
    }

    public User mapToUser(final UserDto userDto) {
        if (userDto == null) return null;
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.isBlocked());
    }
}