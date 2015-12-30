package za.co.rettakid.gains.persistence.dao.impl;

import org.springframework.stereotype.Service;
import za.co.rettakid.gains.persistence.dao.*;
import za.co.rettakid.gains.persistence.entity.*;

@Service
public class PermissionDaoImpl extends BaseDaoImpl<PermissionEntity,Long> implements PermissionDao   {

    public Class getEntityClass() {
        return PermissionEntity.class;
    }

}