package za.co.rettakid.gains.services.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.persistence.entity.*;

public class BindPermission {

    public static PermissionEntity bindPermission(PermissionDto permissionDto) {
        PermissionEntity permissionEntity = null;
        if (permissionDto != null)    {
            permissionEntity = new PermissionEntity();
            permissionEntity.setPermissionId(permissionDto.getPermissionId());
            permissionEntity.setPermissionName(permissionDto.getPermissionName());
        }
        return permissionEntity;
    }

    public static PermissionEntity bindPermission(PermissionDto permissionDto,PermissionEntity permissionEntity) {
        if (permissionDto != null && permissionEntity != null)    {
            permissionEntity.setPermissionName(permissionDto.getPermissionName());
        }
        return permissionEntity;
    }

    public static List<PermissionEntity> bindPermissionDtoList(List<PermissionDto> permissionDtos) {
    List<PermissionEntity> permissionEntities = new ArrayList<PermissionEntity>();
        for (PermissionDto permissionDto : permissionDtos) {
            permissionEntities.add(bindPermission(permissionDto));
        }
        return permissionEntities;
    }

    public static PermissionDto bindPermission(PermissionEntity permissionEntity) {
        PermissionDto permissionDto = null;
        if (permissionEntity != null)    {
            permissionDto = new PermissionDto();
            permissionDto.setPermissionId(permissionEntity.getPermissionId());
            permissionDto.setPermissionName(permissionEntity.getPermissionName());
        }
        return permissionDto;
    }

    public static List<PermissionDto> bindPermissionEntityList(List<PermissionEntity> permissionEntitys) {
        List<PermissionDto> permissionDtos = new ArrayList<PermissionDto>();
        if (permissionEntitys != null)   {
            for (PermissionEntity permissionEntity : permissionEntitys) {
                permissionDtos.add(bindPermission(permissionEntity));
            }
        }
        return permissionDtos;
    }

}
