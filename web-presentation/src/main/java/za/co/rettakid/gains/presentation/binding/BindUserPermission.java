package za.co.rettakid.gains.presentation.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.presentation.vo.*;

public class BindUserPermission {

    public static UserPermissionVo bindUserPermission(UserPermissionDto userPermissionDto) {
        UserPermissionVo userPermissionVo = null;
        if (userPermissionDto != null)    {
            userPermissionVo = new UserPermissionVo();
            userPermissionVo.setUserPermissionId(userPermissionDto.getUserPermissionId());
            userPermissionVo.setUser(BindUser.bindUser(userPermissionDto.getUser()));
            userPermissionVo.setPermission(BindPermission.bindPermission(userPermissionDto.getPermission()));
        }
        return userPermissionVo;
    }

    public static List<UserPermissionVo> bindUserPermissionDtoList(List<UserPermissionDto> userPermissionDtos) {
    List<UserPermissionVo> userPermissionEntities = new ArrayList<UserPermissionVo>();
        for (UserPermissionDto userPermissionDto : userPermissionDtos) {
            userPermissionEntities.add(bindUserPermission(userPermissionDto));
        }
        return userPermissionEntities;
    }

    public static UserPermissionDto bindUserPermission(UserPermissionVo userPermissionVo) {
        UserPermissionDto userPermissionDto = null;
        if (userPermissionVo != null)    {
            userPermissionDto = new UserPermissionDto();
            userPermissionDto.setUserPermissionId(userPermissionVo.getUserPermissionId());
            userPermissionDto.setUser(BindUser.bindUser(userPermissionVo.getUser()));
            userPermissionDto.setPermission(BindPermission.bindPermission(userPermissionVo.getPermission()));
        }
        return userPermissionDto;
    }

    public static List<UserPermissionDto> bindUserPermissionVoList(List<UserPermissionVo> userPermissionVos) {
        List<UserPermissionDto> userPermissionDtos = new ArrayList<UserPermissionDto>();
        for (UserPermissionVo userPermissionVo : userPermissionVos) {
            userPermissionDtos.add(bindUserPermission(userPermissionVo));
        }
        return userPermissionDtos;
    }

}
