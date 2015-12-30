package za.co.rettakid.gains.presentation.binding;

import za.co.rettakid.gains.common.dto.LoginDto;
import za.co.rettakid.gains.presentation.vo.LoginVo;

import java.util.ArrayList;
import java.util.List;

public class BindLogin {

    public static LoginVo bindLogin(LoginDto loginDto) {
        LoginVo loginVo = null;
        if (loginDto != null)    {
            loginVo = new LoginVo();
            loginVo.setEmail(loginDto.getEmail());
            loginVo.setPassword(loginDto.getPassword());
        }
        return loginVo;
    }

    public static LoginDto bindLogin(LoginVo loginVo) {
        LoginDto loginDto = null;
        if (loginVo != null)    {
            loginDto = new LoginDto();
            loginDto.setEmail(loginVo.getEmail());
            loginDto.setPassword(loginVo.getPassword());
        }
        return loginDto;
    }


}
