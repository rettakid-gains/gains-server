package za.co.rettakid.gains.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rettakid.gains.persistence.entity.UserPermissionEntity;
import za.co.rettakid.gains.services.binding.*;
import za.co.rettakid.gains.services.*;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.persistence.dao.*;

@Service
public class UserPermissionServiceImpl implements UserPermissionService   {

    @Autowired
    private UserPermissionDao userPermissionDao;
    @Autowired
    private UserDao userDao;

    @Override
    public UserPermissionListDto getUserPermissions()  {
        UserPermissionListDto userPermissionListDto = new UserPermissionListDto();
        userPermissionListDto.addUserPermissionList(BindUserPermission.bindUserPermissionEntityList(userPermissionDao.read()));
        return userPermissionListDto;
    }

    @Override
    public UserPermissionDto getUserPermissions(Long userPermissionId)  {
        return BindUserPermission.bindUserPermission(userPermissionDao.read(userPermissionId));
    }

    @Override
    public PermissionListDto getPermissionsForUser(Long userId)  {
        PermissionListDto permissionListDto = new PermissionListDto();
        permissionListDto.addPermissionList(BindPermission.bindPermissionEntityList(userPermissionDao.getPermissionsForUser(userDao.read(userId))));
        return permissionListDto;
    }

    @Override
    public UserPermissionDto postUserPermissions(UserPermissionDto userPermissionDto)  {
        UserPermissionEntity userPermissionEntity = BindUserPermission.bindUserPermission(userPermissionDto);
        userPermissionDao.createOrUpdate(userPermissionEntity);
        return BindUserPermission.bindUserPermission(userPermissionEntity);
    }

    @Override
    public void putUserPermissions(UserPermissionDto userPermissionDto)  {
        userPermissionDao.createOrUpdate(BindUserPermission.bindUserPermission(userPermissionDto));
    }

    @Override
    public void deleteUserPermissions(Long userPermissionId)  {
        userPermissionDao.delete(userPermissionDao.read(userPermissionId));
}

}