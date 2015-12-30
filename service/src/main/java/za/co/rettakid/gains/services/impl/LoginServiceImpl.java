package za.co.rettakid.gains.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.rettakid.gains.common.dto.LoginDto;
import za.co.rettakid.gains.common.dto.UserDto;
import za.co.rettakid.gains.common.Utilz;
import za.co.rettakid.gains.common.enums.PermissionEnum;
import za.co.rettakid.gains.common.enums.PermissionSet;
import za.co.rettakid.gains.common.error.ProjectError;
import za.co.rettakid.gains.common.error.ProjectErrorException;
import za.co.rettakid.gains.persistence.dao.PermissionDao;
import za.co.rettakid.gains.persistence.dao.UserDao;
import za.co.rettakid.gains.persistence.dao.UserPermissionDao;
import za.co.rettakid.gains.persistence.entity.UserEntity;
import za.co.rettakid.gains.persistence.entity.UserPermissionEntity;
import za.co.rettakid.gains.services.LoginService;
import za.co.rettakid.gains.services.binding.BindUser;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserPermissionDao userPermissionDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public UserDto login(LoginDto loginDto) {
        LOGGER.info("login user");
        UserEntity userEntity = userDao.getUser(loginDto.getEmail(), Utilz.CRYPT(loginDto.getPassword()));
        return BindUser.bindUser(userEntity);
    }

    @Transactional
    @Override
    public void resister(UserDto userDto,PermissionSet permissionSet) throws ProjectErrorException {
        LOGGER.info("register user");
        if (userDao.getUser(userDto.getEmail()) != null)    {
            throw new ProjectErrorException(ProjectError.USER_ALREADY_EXIST);
        } else  {
            UserEntity userEntity = BindUser.bindUser(userDto);
            userEntity.setPassword(Utilz.CRYPT(userDto.getPassword()));
            userEntity.setUserAllowPush(true);
            userDao.createOrUpdate(userEntity);
        }

        UserEntity userEntity = userDao.getUser(userDto.getEmail());

        for (PermissionEnum permissionEnum : permissionSet.getPermission()) {
            UserPermissionEntity userPermissionEntity = new UserPermissionEntity();
            userPermissionEntity.setPermission(permissionDao.read(permissionEnum.getId()));
            userPermissionEntity.setUser(userEntity);
            userPermissionDao.createOrUpdate(userPermissionEntity);
        }
    }

}
