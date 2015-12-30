package za.co.rettakid.gains.presentation.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.rettakid.gains.common.enums.PermissionSet;
import za.co.rettakid.gains.presentation.binding.BindUser;
import za.co.rettakid.gains.presentation.common.PageDirectory;
import za.co.rettakid.gains.presentation.vo.UserVo;
import za.co.rettakid.gains.services.LoginService;

import javax.validation.Valid;

/**
 * Created by Lwazi Prusent on 2015/10/30.
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegister(Model model) {
        LOGGER.debug("get register");
        model.addAttribute("userVo", new UserVo());
        return PageDirectory.REGISTER;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postLoginPage(@ModelAttribute("userVo") @Valid UserVo userVo, BindingResult error, Model model,@RequestParam("confirm-password")String confirmPassword) {
        LOGGER.debug("create user");
        if (error.hasErrors())  {
            createToast(model,"Please complete form.");
        } else  {
            if (userVo.getPassword().equals(confirmPassword)) {
                loginService.resister(BindUser.bindUser(userVo), PermissionSet.TEST);
                createToast(model, "Please login");
                return doRedirect(PageDirectory.LOGIN);
            } else  {
                createToast(model, "Please confirm password.");
            }
        }
        return PageDirectory.REGISTER;
    }

}
