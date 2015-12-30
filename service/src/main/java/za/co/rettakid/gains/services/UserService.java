package za.co.rettakid.gains.services;

import za.co.rettakid.gains.common.dto.*;

public interface UserService    {

    UserListDto getUsers();
    UserDto getUsers(Long userId);

    UserListDto getMatches(UserDto userDto);

    UserDto postUsers(UserDto userDto);
    void putUsers(UserDto userDto);
    void deleteUsers(Long userId);

}