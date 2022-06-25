package edu.miu.cs545.aop.utils;

import edu.miu.cs545.aop.dto.UserDto;
import edu.miu.cs545.aop.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserUtils {
    static ModelMapper mapper;
    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        UserUtils.mapper=modelMapper;
    }

    public static UserDto parseUserToUserDto(User user){
        return mapper.map(user, UserDto.class);
    }

    public static User parseUserDtoToUser(UserDto userDto){
        return mapper.map(userDto,User.class);
    }
}
