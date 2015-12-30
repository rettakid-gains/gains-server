package za.co.rettakid.gains.presentation.vo;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Lwazi Prusent on 2015/10/20.
 */
public class LoginVo {

    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
