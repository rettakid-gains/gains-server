package za.co.rettakid.gains.presentation.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.presentation.vo.*;

public class BindUser {

    public static UserVo bindUser(UserDto userDto) {
        UserVo userVo = null;
        if (userDto != null)    {
            userVo = new UserVo();
            userVo.setUserId(userDto.getUserId());
            userVo.setEmail(userDto.getEmail());
            userVo.setPassword(userDto.getPassword());
            userVo.setName(userDto.getName());
            userVo.setSurname(userDto.getSurname());
            userVo.setPhone(userDto.getPhone());
            userVo.setGender(userDto.getGender());
            userVo.setAge(userDto.getAge());
            userVo.setUserAllowPush(userDto.getUserAllowPush());
        }
        return userVo;
    }

    public static List<UserVo> bindUserDtoList(List<UserDto> userDtos) {
    List<UserVo> userEntities = new ArrayList<UserVo>();
        for (UserDto userDto : userDtos) {
            userEntities.add(bindUser(userDto));
        }
        return userEntities;
    }

    public static UserDto bindUser(UserVo userVo) {
        UserDto userDto = null;
        if (userVo != null)    {
            userDto = new UserDto();
            userDto.setUserId(userVo.getUserId());
            userDto.setEmail(userVo.getEmail());
            userDto.setPassword(userVo.getPassword());
            userDto.setName(userVo.getName());
            userDto.setSurname(userVo.getSurname());
            userDto.setPhone(userVo.getPhone());
            userDto.setGender(userVo.getGender());
            userDto.setAge(userVo.getAge());
            userDto.setUserAllowPush(userVo.getUserAllowPush());
        }
        return userDto;
    }

    public static List<UserDto> bindUserVoList(List<UserVo> userVos) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (UserVo userVo : userVos) {
            userDtos.add(bindUser(userVo));
        }
        return userDtos;
    }

}
