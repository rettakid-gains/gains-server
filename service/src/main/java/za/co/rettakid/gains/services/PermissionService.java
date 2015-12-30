package za.co.rettakid.gains.services;

import za.co.rettakid.gains.common.dto.*;

public interface PermissionService    {

    PermissionListDto getPermissions();
    PermissionDto getPermissions(Long permissionId);
    PermissionDto postPermissions(PermissionDto permissionDto);
    void putPermissions(PermissionDto permissionDto);
    void deletePermissions(Long permissionId);

}