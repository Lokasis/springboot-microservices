package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserActionDto;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserAction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

    UserAction mapToUserAction(UserActionDto userActionDto);

    UserActionDto mapToUserActionDto(UserAction userAction);
}
