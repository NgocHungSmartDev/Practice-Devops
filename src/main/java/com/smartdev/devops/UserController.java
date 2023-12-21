package com.smartdev.devops;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class UserController {
  @Autowired private UserRepository userRepository;

  @PostMapping(path = "/add")
  public String addNewUser(@RequestBody UserDto userDto) {
    User user =
        User.builder()
            .email(userDto.getEmail())
            .name(userDto.getName())
            .age(userDto.getAge())
            .build();
    userRepository.save(user);
    return "Saved";
  }

  @GetMapping(path = "/all")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
