package za.co.rettakid.gains.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import za.co.rettakid.gains.persistence.dao.*;
import za.co.rettakid.gains.persistence.entity.*;

import java.util.List;

@Service
public class UserDaoImpl extends BaseDaoImpl<UserEntity,Long> implements UserDao   {

    public Class getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public UserEntity getUser(String email)  {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq("email", email))
                .setMaxResults(1);
        List<UserEntity> userEntities = criteria.list();
        return (!userEntities.isEmpty()) ? userEntities.get(0) : null;
    }

    @Override
    public UserEntity getUser(String email,String password)  {
        Criteria criteria = createCriteria()
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password))
                .setMaxResults(1);
        List<UserEntity> userEntities = criteria.list();
        return (!userEntities.isEmpty()) ? userEntities.get(0) : null;
    }

    @Override
    public List<UserEntity> getMatches(UserEntity userEntity)    {
        Criteria criteria = createCriteria();
        if (userEntity.getName() != null && !userEntity.getName().isEmpty()) {
            criteria.add(Restrictions.eq("name", userEntity.getName()).ignoreCase());
        }
        if (userEntity.getSurname() != null && !userEntity.getSurname().isEmpty()) {
            criteria.add(Restrictions.eq("surname", userEntity.getSurname()).ignoreCase());
        }
        if (userEntity.getEmail() != null && !userEntity.getEmail().isEmpty()) {
            criteria.add(Restrictions.eq("email", userEntity.getEmail()).ignoreCase());
        }
        if (userEntity.getPhone() != null && !userEntity.getPhone().isEmpty()) {
            criteria.add(Restrictions.eq("phone", userEntity.getPhone().trim()));
        }
        return criteria.list();
    }

}