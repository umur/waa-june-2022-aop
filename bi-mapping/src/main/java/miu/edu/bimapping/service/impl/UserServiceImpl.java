package miu.edu.bimapping.service.impl;

import miu.edu.bimapping.dto.UserDto;
import miu.edu.bimapping.entity.User;
import miu.edu.bimapping.repository.UserRepository;
import miu.edu.bimapping.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        List<UserDto> userDto = users.stream()
                .map(st ->toDto(st))
                .collect(Collectors.toList());

        return userDto;
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = toEntity(userDto);
        return userRepository.save(user) ;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(UserDto userDto, Integer id) {
        User user = toEntity(userDto);
        userRepository.findById(id).map(users->{
            users.setEmail(user.getEmail());
            users.setFirstName(user.getFirstName());
            users.setLastName(user.getLastName());
            users.setPassword(user.getPassword());
            return this.userRepository.save(users);
        });
        return user;
    }

    public UserDto toDto(User user){
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }

    public User toEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        return user;
    }
}
