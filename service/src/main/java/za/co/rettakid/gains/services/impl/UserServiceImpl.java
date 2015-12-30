package za.co.rettakid.gains.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.rettakid.gains.services.binding.*;
import za.co.rettakid.gains.services.*;
import za.co.rettakid.gains.common.dto.*;
import za.co.rettakid.gains.persistence.dao.*;
import za.co.rettakid.gains.persistence.entity.*;

@Service
@Transactional
public class UserServiceImpl implements UserService   {

    @Autowired
    private UserDao userDao;

    @Override
    public UserListDto getUsers()  {
        UserListDto userListDto = new UserListDto();
        userListDto.addUserList(BindUser.bindUserEntityList(userDao.read()));
        return userListDto;
    }

    @Override
    public UserDto getUsers(Long userId)  {
        return BindUser.bindUser(userDao.read(userId));
    }

    @Override
    public UserListDto getMatches(UserDto userDto) {
        UserListDto userListDto = new UserListDto();
        userListDto.addUserList(BindUser.bindUserEntityList(userDao.getMatches(BindUser.bindUser(userDto))));
        return userListDto;
    }

    @Override
    public UserDto postUsers(UserDto userDto)  {
        UserEntity userEntity = BindUser.bindUser(userDto);
        userDao.createOrUpdate(userEntity);
        return BindUser.bindUser(userEntity);
}

    @Override
    public void putUsers(UserDto userDto)  {
        userDao.createOrUpdate(BindUser.bindUser(userDto));
    }

    @Override
    public void deleteUsers(Long userId)  {
        userDao.delete(userDao.read(userId));
    }

}