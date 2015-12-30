package za.co.rettakid.gains.persistence.dao;

import java.util.List;
import za.co.rettakid.gains.persistence.entity.*;

public interface UserPermissionDao extends BaseDao<UserPermissionEntity,Long>    {

    List<PermissionEntity> getPermissionsForUser(UserEntity userEntity);
}