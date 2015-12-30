package za.co.rettakid.gains.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import za.co.rettakid.gains.persistence.dao.*;
import za.co.rettakid.gains.persistence.entity.*;

import java.util.List;

@Service
public class UserPermissionDaoImpl extends BaseDaoImpl<UserPermissionEntity,Long> implements UserPermissionDao   {

    public Class getEntityClass() {
        return UserPermissionEntity.class;
    }

    @Override
    public List<PermissionEntity> getPermissionsForUser(UserEntity userEntity) {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq("user",userEntity))
                .setProjection(Projections.property("permission"));
        return criteria.list();
    }

}