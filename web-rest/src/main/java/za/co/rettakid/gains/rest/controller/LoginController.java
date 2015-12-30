package za.co.rettakid.gains.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.co.rettakid.gains.services.*;
import za.co.rettakid.gains.common.dto.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public UserDto postLogin(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

}