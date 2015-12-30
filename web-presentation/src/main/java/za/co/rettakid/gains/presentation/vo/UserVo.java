package za.co.rettakid.gains.presentation.vo;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

public class UserVo    {

    private Long userId;
    @NotBlank @NotNull
    private String email;
    @NotBlank @NotNull
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String gender;
    private Integer age;
    @NotNull
    private Boolean userAllowPush;

    public Long getUserId()   {
        return this.userId;
    }

    public void setUserId(Long userId)   {
        this.userId = userId;
    }

    public String getEmail()   {
        return this.email;
    }

    public void setEmail(String email)   {
        this.email = email;
    }

    public String getPassword()   {
        return this.password;
    }

    public void setPassword(String password)   {
        this.password = password;
    }

    public String getName()   {
        return this.name;
    }

    public void setName(String name)   {
        this.name = name;
    }

    public String getSurname()   {
        return this.surname;
    }

    public void setSurname(String surname)   {
        this.surname = surname;
    }

    public String getPhone()   {
        return this.phone;
    }

    public void setPhone(String phone)   {
        this.phone = phone;
    }

    public String getGender()   {
        return this.gender;
    }

    public void setGender(String gender)   {
        this.gender = gender;
    }

    public Integer getAge()   {
        return this.age;
    }

    public void setAge(Integer age)   {
        this.age = age;
    }

    public Boolean getUserAllowPush()   {
        return this.userAllowPush;
    }

    public void setUserAllowPush(Boolean userAllowPush)   {
        this.userAllowPush = userAllowPush;
    }

}