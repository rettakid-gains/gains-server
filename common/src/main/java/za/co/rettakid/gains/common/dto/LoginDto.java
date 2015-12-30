package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
@XmlRootElement(name = "logindto")
public class LoginDto {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }
}
