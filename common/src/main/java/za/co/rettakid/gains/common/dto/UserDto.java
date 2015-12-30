package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "userdto")
public class UserDto    {

    private Long userId;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String gender;
    private Integer age;
    private Boolean userAllowPush;
    private UserPermissionListDto userPermissionUsers;

    public Long getUserId()   {
        return this.userId;
    }

    @XmlElement(name = "userid" , required = false)
    public void setUserId(Long userId)   {
        this.userId = userId;
    }

    public String getEmail()   {
        return this.email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email)   {
        this.email = email;
    }

    public String getPassword()   {
        return this.password;
    }

    @XmlElement(name = "password")
    public void setPassword(String password)   {
        this.password = password;
    }

    public String getName()   {
        return this.name;
    }

    @XmlElement(name = "name" , required = false)
    public void setName(String name)   {
        this.name = name;
    }

    public String getSurname()   {
        return this.surname;
    }

    @XmlElement(name = "surname" , required = false)
    public void setSurname(String surname)   {
        this.surname = surname;
    }

    public String getPhone()   {
        return this.phone;
    }

    @XmlElement(name = "phone" , required = false)
    public void setPhone(String phone)   {
        this.phone = phone;
    }

    public String getGender()   {
        return this.gender;
    }

    @XmlElement(name = "gender" , required = false)
    public void setGender(String gender)   {
        this.gender = gender;
    }

    public Integer getAge()   {
        return this.age;
    }

    @XmlElement(name = "age" , required = false)
    public void setAge(Integer age)   {
        this.age = age;
    }

    public Boolean getUserAllowPush()   {
        return this.userAllowPush;
    }

    @XmlElement(name = "userallowpush")
    public void setUserAllowPush(Boolean userAllowPush)   {
        this.userAllowPush = userAllowPush;
    }


    public UserPermissionListDto getUserPermissionUsers()   {
        return this.userPermissionUsers;
    }

    public void setUserPermissionUsers(UserPermissionListDto userPermissionUsers)   {
        this.userPermissionUsers = userPermissionUsers;
    }

}