package za.co.rettakid.gains.presentation.binding;

import java.util.ArrayList;
import java.util.List;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.presentation.vo.*;

public class BindPermission {

    public static PermissionVo bindPermission(PermissionDto permissionDto) {
        PermissionVo permissionVo = null;
        if (permissionDto != null)    {
            permissionVo = new PermissionVo();
            permissionVo.setPermissionId(permissionDto.getPermissionId());
            permissionVo.setPermissionName(permissionDto.getPermissionName());
        }
        return permissionVo;
    }

    public static List<PermissionVo> bindPermissionDtoList(List<PermissionDto> permissionDtos) {
    List<PermissionVo> permissionEntities = new ArrayList<PermissionVo>();
        for (PermissionDto permissionDto : permissionDtos) {
            permissionEntities.add(bindPermission(permissionDto));
        }
        return permissionEntities;
    }

    public static PermissionDto bindPermission(PermissionVo permissionVo) {
        PermissionDto permissionDto = null;
        if (permissionVo != null)    {
            permissionDto = new PermissionDto();
            permissionDto.setPermissionId(permissionVo.getPermissionId());
            permissionDto.setPermissionName(permissionVo.getPermissionName());
        }
        return permissionDto;
    }

    public static List<PermissionDto> bindPermissionVoList(List<PermissionVo> permissionVos) {
        List<PermissionDto> permissionDtos = new ArrayList<PermissionDto>();
        for (PermissionVo permissionVo : permissionVos) {
            permissionDtos.add(bindPermission(permissionVo));
        }
        return permissionDtos;
    }

}
