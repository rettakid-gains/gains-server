package za.co.rettakid.gains.presentation.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.rettakid.gains.common.error.ProjectError;
import za.co.rettakid.gains.presentation.common.PageDirectory;
import za.co.rettakid.gains.presentation.vo.LoginVo;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        LOGGER.debug("accessed login");
        model.addAttribute("loginVo", new LoginVo());
        return PageDirectory.LOGIN;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postLoginPage(@ModelAttribute("loginVo") @Valid LoginVo loginVo, BindingResult error, Model model) {
        LOGGER.debug("post login");
        if (error.hasErrors()) {
            createToast(model, "Please complete form.");
            return PageDirectory.LOGIN;
        } else {
            if (loginUser(loginVo)) {
                return doRedirect(PageDirectory.HOME);
            } else {
                createToast(model, ProjectError.LOGIN_DOES_NOT_EXIST.getError());
                loginVo.setPassword("");
            }
        }
        return PageDirectory.LOGIN;
    }


}
