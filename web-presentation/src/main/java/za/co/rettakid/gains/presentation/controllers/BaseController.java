package za.co.rettakid.gains.presentation.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import za.co.rettakid.gains.common.ProjectConstants;
import za.co.rettakid.gains.common.dto.PermissionDto;
import za.co.rettakid.gains.common.dto.UserDto;
import za.co.rettakid.gains.common.error.ProjectError;
import za.co.rettakid.gains.common.error.ProjectErrorException;
import za.co.rettakid.gains.presentation.binding.BindLogin;
import za.co.rettakid.gains.presentation.common.PageDirectory;
import za.co.rettakid.gains.presentation.vo.LoginVo;
import za.co.rettakid.gains.presentation.vo.UserVo;
import za.co.rettakid.gains.services.LoginService;
import za.co.rettakid.gains.services.UserPermissionService;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class BaseController {

    private static final Logger LOGGER = Logger.getLogger(BaseController.class);

    @Value("${file.dir}")
    protected String FILE_DIR;

    public static final String TOAST_TEXT = "toastText";
    public static final String TOAST_ERROR_TEXT = "toastErrorText";

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserPermissionService userPermissionService;

    protected void createToast(Model model, String... toastText) {
        model.addAttribute(TOAST_TEXT, toastText);
    }

    protected void createErrorToast(Model model, HttpServletResponse response, List<FieldError> fieldErrors) {
        List<String> toastText = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            toastText.add(fieldError.getField().replaceAll("\\.", " ") + " - " + fieldError.getDefaultMessage());
        }
        model.addAttribute(TOAST_ERROR_TEXT, toastText);
        response.setStatus(203);
    }

    protected String doRedirect(String page) {
        return String.format("redirect:/%s", page);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Date date = null;
                String dateInMilliPattern = "[\\d]{13}";
                String defaultDatePattern = "[\\w]{3}\\s[\\w]{3}\\s[\\d]{2}\\s[\\d]{2}:[\\d]{2}:[\\d]{2}\\s[\\w]{3}\\s[\\d]{4}";
                String dateTimeFormatPattern = "[\\d]{4}-[\\d]{2}-[\\d]{2}\\s[\\d]{2}:[\\d]{2}";
                String dateFormatPattern = "[\\d]{4}-[\\d]{2}-[\\d]{2}";
                String timeFormatPattern = "[\\d]{2}:[\\d]{2}";
                Matcher dateInMilliMatcher = Pattern.compile(dateInMilliPattern).matcher(text);
                Matcher defaultDateMatcher = Pattern.compile(defaultDatePattern).matcher(text);
                Matcher dateTimeMatcher = Pattern.compile(dateTimeFormatPattern).matcher(text);
                Matcher dateMatcher = Pattern.compile(dateFormatPattern).matcher(text);
                Matcher timeMatcher = Pattern.compile(timeFormatPattern).matcher(text);
                try {
                    if (dateInMilliMatcher.find()) {
                        date = new Date(Long.parseLong(text));
                    } else if (defaultDateMatcher.find()) {
                        date = new SimpleDateFormat(ProjectConstants.DATE_DEFAULT_FORMAT).parse(text);
                    } else if (dateTimeMatcher.find()) {
                        date = new SimpleDateFormat(ProjectConstants.DATE_TIME_FORMAT).parse(text);
                    } else if (dateMatcher.find()) {
                        date = new SimpleDateFormat(ProjectConstants.DATE_FORMAT).parse(text);
                    } else if (timeMatcher.find()) {
                        date = new SimpleDateFormat(ProjectConstants.TIME_FORMAT).parse(text);
                    }
                } catch (ParseException e) {
                    LOGGER.error(String.format("could not bind date %s",text),e);
                }

                setValue(date);
            }
        });

    }

    /*login and permissions*/
    protected Boolean loginUser(LoginVo loginVo) {
        UserDto userDto = loginService.login(BindLogin.bindLogin(loginVo));
        if (userDto != null) {
            List<GrantedAuthority> grantedAuthorities = addGenericPermissions(userDto.getUserId());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDto, null, grantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return true;
        }
        return false;
    }

    private List<GrantedAuthority> addGenericPermissions(final Long userId) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (final PermissionDto permissionDto : userPermissionService.getPermissionsForUser(userId).getPermissionList()) {
            grantedAuthorities.add(
                    new GrantedAuthority() {
                        @Override
                        public String getAuthority() {
                            return permissionDto.getPermissionName();
                        }
                    }
            );
        }
        return grantedAuthorities;
    }

    protected UserDto getPrinciple() {
        return (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    protected Boolean hasPermission(String permission) {
        for (GrantedAuthority grantedAuthority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            if (grantedAuthority.getAuthority().equals(permission)) {
                return true;
            }
        }
        return false;
    }

    protected Boolean hasAnyPermission(String... permissions) {
        for (GrantedAuthority grantedAuthority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            if (Arrays.asList(permissions).contains(grantedAuthority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    public String denyPermission(Model model) {
        LOGGER.debug("Error 403");
        model.addAttribute("error", "403 you are not authorised to view this page");
        return PageDirectory.ERROR;
    }

    /*errors*/
    @ExceptionHandler(ProjectErrorException.class)
    public ModelAndView catchProjectError(ProjectErrorException ex) {
        LOGGER.info(ex.getMessage(), ex);
        ModelAndView model = new ModelAndView(PageDirectory.ERROR);
        switch (ex.getProjectError()) {
            case LOGIN_DOES_NOT_EXIST:
                model.setViewName(PageDirectory.LOGIN);
                model.addObject("loginVO", new LoginVo());
                break;
            case USER_ALREADY_EXIST:
                model.setViewName(PageDirectory.REGISTER);
                model.addObject("userVo", new UserVo());
                model.addObject(TOAST_TEXT, ProjectError.USER_ALREADY_EXIST.getError());
                break;
        }
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView catchGeneralError(Exception exception, HttpServletResponse response) throws IOException {
        LOGGER.error(exception.getMessage(), exception);
        ModelAndView model = new ModelAndView(PageDirectory.ERROR);
        model.addObject("error", "Sorry something broke");
        response.setStatus(500);
        return model;
    }

}
