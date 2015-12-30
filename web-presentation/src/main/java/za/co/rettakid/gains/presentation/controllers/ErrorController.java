package za.co.rettakid.gains.presentation.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.rettakid.gains.presentation.common.PageDirectory;

@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ErrorController.class);

    @RequestMapping("/403")
    public String get403Error(Model model) {
        LOGGER.debug("Error 403");
        model.addAttribute("error","403 you are not authorised to view this page");
        return PageDirectory.ERROR;
    }

    @RequestMapping("/404")
    public String get404Error(Model model) {
        LOGGER.debug("Error 404");
        model.addAttribute("error","404 this page does not exist");
        return PageDirectory.ERROR;
    }

    @RequestMapping("/500")
    public String get500Error(Model model) {
        LOGGER.debug("Error 500");
        model.addAttribute("error","Sorry something broke");
        return PageDirectory.ERROR;
    }

}
