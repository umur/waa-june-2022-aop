package edu.miu.aop.service.impl;

import edu.miu.aop.dto.UserDto;
import edu.miu.aop.entity.User;
import edu.miu.aop.repo.UserRepo;
import edu.miu.aop.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private ModelMapper mapper;

    @Override
    public void save(UserDto userDto) {
        userRepo.save(dtoToEntity(userDto));
    }

    @Override
    public void updateUser(UserDto userDto, Integer id){
        User user = getById(id);
        user.setEmail(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());

        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<UserDto> getAll() {
        var users = userRepo.findAll();
        var result = new ArrayList<UserDto>();

        for(User user: users){
            UserDto dto = new UserDto();
            var userDto = toDto(user);
            result.add(userDto);
        }
        return result;
    }

    private UserDto toDto(User user){
        UserDto dto = mapper.map(user, UserDto.class);
        return dto;
    }
    public User dtoToEntity(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        return user;
    }
}
