package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",imports = AccountMapper.class)
public interface UserMapper {
    @Mapping(target = "orderProducts", ignore = true)
    @Mapping(target = "account", ignore = true)
    User userDtoToUser(UserDTO userDTO);
    @Mapping(target = "orderProducts", ignore = true)
    @Mapping(target = "account", ignore = true)
    UserDTO userToUserDto(User user);
    List<UserDTO> listUserToListUserDto(List<User> users);
}
