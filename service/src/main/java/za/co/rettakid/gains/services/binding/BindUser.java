package za.co.rettakid.gains.services.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.persistence.entity.*;

public class BindUser {

    public static UserEntity bindUser(UserDto userDto) {
        UserEntity userEntity = null;
        if (userDto != null)    {
            userEntity = new UserEntity();
            userEntity.setUserId(userDto.getUserId());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setName(userDto.getName());
            userEntity.setSurname(userDto.getSurname());
            userEntity.setPhone(userDto.getPhone());
            userEntity.setGender(userDto.getGender());
            userEntity.setAge(userDto.getAge());
            userEntity.setUserAllowPush(userDto.getUserAllowPush());
        }
        return userEntity;
    }

    public static UserEntity bindUser(UserDto userDto,UserEntity userEntity) {
        if (userDto != null && userEntity != null)    {
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setName(userDto.getName());
            userEntity.setSurname(userDto.getSurname());
            userEntity.setPhone(userDto.getPhone());
            userEntity.setGender(userDto.getGender());
            userEntity.setAge(userDto.getAge());
            userEntity.setUserAllowPush(userDto.getUserAllowPush());
        }
        return userEntity;
    }

    public static List<UserEntity> bindUserDtoList(List<UserDto> userDtos) {
    List<UserEntity> userEntities = new ArrayList<UserEntity>();
        for (UserDto userDto : userDtos) {
            userEntities.add(bindUser(userDto));
        }
        return userEntities;
    }

    public static UserDto bindUser(UserEntity userEntity) {
        UserDto userDto = null;
        if (userEntity != null)    {
            userDto = new UserDto();
            userDto.setUserId(userEntity.getUserId());
            userDto.setEmail(userEntity.getEmail());
            userDto.setPassword(userEntity.getPassword());
            userDto.setName(userEntity.getName());
            userDto.setSurname(userEntity.getSurname());
            userDto.setPhone(userEntity.getPhone());
            userDto.setGender(userEntity.getGender());
            userDto.setAge(userEntity.getAge());
            userDto.setUserAllowPush(userEntity.getUserAllowPush());
        }
        return userDto;
    }

    public static List<UserDto> bindUserEntityList(List<UserEntity> userEntitys) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        if (userEntitys != null)   {
            for (UserEntity userEntity : userEntitys) {
                userDtos.add(bindUser(userEntity));
            }
        }
        return userDtos;
    }

}
