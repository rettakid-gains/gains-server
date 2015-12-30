package za.co.rettakid.gains.services;

import za.co.rettakid.gains.common.dto.*;

public interface UserPermissionService    {

    UserPermissionListDto getUserPermissions();
    UserPermissionDto getUserPermissions(Long userPermissionId);

    PermissionListDto getPermissionsForUser(Long userId);

    UserPermissionDto postUserPermissions(UserPermissionDto userPermissionDto);
    void putUserPermissions(UserPermissionDto userPermissionDto);
    void deleteUserPermissions(Long userPermissionId);

}