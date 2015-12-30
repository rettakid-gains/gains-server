package za.co.rettakid.gains.services.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.persistence.entity.*;

public class BindUserPermission {

    public static UserPermissionEntity bindUserPermission(UserPermissionDto userPermissionDto) {
        UserPermissionEntity userPermissionEntity = null;
        if (userPermissionDto != null)    {
            userPermissionEntity = new UserPermissionEntity();
            userPermissionEntity.setUserPermissionId(userPermissionDto.getUserPermissionId());
            userPermissionEntity.setUser(BindUser.bindUser(userPermissionDto.getUser()));
            userPermissionEntity.setPermission(BindPermission.bindPermission(userPermissionDto.getPermission()));
        }
        return userPermissionEntity;
    }

    public static UserPermissionEntity bindUserPermission(UserPermissionDto userPermissionDto,UserPermissionEntity userPermissionEntity) {
        if (userPermissionDto != null && userPermissionEntity != null)    {
            if (userPermissionEntity.getUser().getUserId() != null) {
                userPermissionEntity.setUser(BindUser.bindUser(userPermissionDto.getUser(), userPermissionEntity.getUser()));
            } else  {
                userPermissionEntity.setUser(BindUser.bindUser(userPermissionDto.getUser(), new UserEntity()));
            }
            if (userPermissionEntity.getPermission().getPermissionId() != null) {
                userPermissionEntity.setPermission(BindPermission.bindPermission(userPermissionDto.getPermission(), userPermissionEntity.getPermission()));
            } else  {
                userPermissionEntity.setPermission(BindPermission.bindPermission(userPermissionDto.getPermission(), new PermissionEntity()));
            }
        }
        return userPermissionEntity;
    }

    public static List<UserPermissionEntity> bindUserPermissionDtoList(List<UserPermissionDto> userPermissionDtos) {
    List<UserPermissionEntity> userPermissionEntities = new ArrayList<UserPermissionEntity>();
        for (UserPermissionDto userPermissionDto : userPermissionDtos) {
            userPermissionEntities.add(bindUserPermission(userPermissionDto));
        }
        return userPermissionEntities;
    }

    public static UserPermissionDto bindUserPermission(UserPermissionEntity userPermissionEntity) {
        UserPermissionDto userPermissionDto = null;
        if (userPermissionEntity != null)    {
            userPermissionDto = new UserPermissionDto();
            userPermissionDto.setUserPermissionId(userPermissionEntity.getUserPermissionId());
            userPermissionDto.setUser(BindUser.bindUser(userPermissionEntity.getUser()));
            userPermissionDto.setPermission(BindPermission.bindPermission(userPermissionEntity.getPermission()));
        }
        return userPermissionDto;
    }

    public static List<UserPermissionDto> bindUserPermissionEntityList(List<UserPermissionEntity> userPermissionEntitys) {
        List<UserPermissionDto> userPermissionDtos = new ArrayList<UserPermissionDto>();
        if (userPermissionEntitys != null)   {
            for (UserPermissionEntity userPermissionEntity : userPermissionEntitys) {
                userPermissionDtos.add(bindUserPermission(userPermissionEntity));
            }
        }
        return userPermissionDtos;
    }

}
