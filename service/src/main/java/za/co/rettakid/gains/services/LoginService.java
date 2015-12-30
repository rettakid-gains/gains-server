package za.co.rettakid.gains.services;

import org.springframework.transaction.annotation.Transactional;
import za.co.rettakid.gains.common.dto.LoginDto;
import za.co.rettakid.gains.common.dto.UserDto;
import za.co.rettakid.gains.common.enums.PermissionSet;
import za.co.rettakid.gains.common.error.ProjectErrorException;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
public interface LoginService {
    UserDto login(LoginDto loginDto);

    @Transactional
    void resister(UserDto userDto,PermissionSet permissionSet) throws ProjectErrorException;
}
