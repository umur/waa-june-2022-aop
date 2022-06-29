package com.example.lab5.bidirectional.service.impl;

import com.example.lab5.bidirectional.dto.UserDTO;
import com.example.lab5.bidirectional.entity.User;
import com.example.lab5.bidirectional.repository.UserRepository;
import com.example.lab5.bidirectional.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        if (null != user) {
            userRepository.delete(user);
        }
    }

    @Override
    public User findById(int id) {
        return (userRepository.findById(id).isPresent()) ? userRepository.findById(id).get() : null;
    }

    @Override
    public List<UserDTO> getAll() {
        return  userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    //use model mapper here

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
