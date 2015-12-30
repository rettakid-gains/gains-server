package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "userpermissiondto")
public class UserPermissionDto    {

    private Long userPermissionId;
    private UserDto user;
    private PermissionDto permission;

    public Long getUserPermissionId()   {
        return this.userPermissionId;
    }

    @XmlElement(name = "userpermissionid" , required = false)
    public void setUserPermissionId(Long userPermissionId)   {
        this.userPermissionId = userPermissionId;
    }

    public UserDto getUser()   {
        return this.user;
    }

    @XmlElement(name = "userdto")
    public void setUser(UserDto user)   {
        this.user = user;
    }

    public PermissionDto getPermission()   {
        return this.permission;
    }

    @XmlElement(name = "permissiondto")
    public void setPermission(PermissionDto permission)   {
        this.permission = permission;
    }


}