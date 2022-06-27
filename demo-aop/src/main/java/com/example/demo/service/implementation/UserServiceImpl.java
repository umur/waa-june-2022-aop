package com.example.demo.service.implementation;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

  @Autowired
  ModelMapper modelMapper;
  @Autowired
  ListMapper<User, UserDto> listMapper;
  @Autowired
  UserRepo userRepo;

  @Override
  public List<UserDto> findAllUser() {
    List<User> users = (List<User>) userRepo.findAll();
    List<UserDto> userDto = (List<UserDto>) listMapper.mapList(users,new UserDto());
    return userDto;
  }

  @Override
  public void createUser(UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    userRepo.save(user);
  }

  @Override
  public void delete(int id) {
    userRepo.deleteById(id);
  }

  @Override
  public void update(int id, UserDto userDto) {
    User user = modelMapper.map(userDto, User.class);
    userRepo.findById(id).map(st -> {
      st.setAddress(user.getAddress());
      st.setEmail(user.getEmail());
      st.setFirstName(user.getFirstName());
      st.setLastname(user.getLastname());
      st.setPassword(user.getPassword());
      st.setReviewList(user.getReviewList());

      return userRepo.save(st);
    });

  }
}
