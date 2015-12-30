package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "userlistdto")
public class UserListDto   {

    @XmlElementWrapper(name = "users")
    @XmlElement(name = "userdto",type = UserDto.class)
    private List<UserDto> users = new ArrayList<UserDto>();

    public List<UserDto> getUserList()   {
        return this.users;
    }

    public void addUserList(List<UserDto> users)   {
        this.users.addAll(users);
    }
}