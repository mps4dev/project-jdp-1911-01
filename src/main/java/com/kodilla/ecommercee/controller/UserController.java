package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.domain.UserNotAuthenticated;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public UserDto get(@PathVariable long userId) throws EntityNotFoundException {
        return userService.get(userId);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable long userId) throws EntityNotFoundException {
        userService.delete(userId);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.create(userDto);
    }

    @PutMapping("/{userId}")
    public UserDto blockUser(@PathVariable long userId) throws EntityNotFoundException {
        return userService.blockUser(userId);
    }

    @GetMapping("/{userId}/uniqueKey")
    public Long getUniqueKey(@PathVariable long userId, @RequestParam String userName) throws EntityNotFoundException {
        return userService.getUniqueKey(userId, userName);
    }
}