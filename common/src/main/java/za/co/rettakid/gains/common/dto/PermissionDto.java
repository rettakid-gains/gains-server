package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "permissiondto")
public class PermissionDto    {

    private Long permissionId;
    private String permissionName;
    private UserPermissionListDto userPermissionPermissions;

    public Long getPermissionId()   {
        return this.permissionId;
    }

    @XmlElement(name = "permissionid" , required = false)
    public void setPermissionId(Long permissionId)   {
        this.permissionId = permissionId;
    }

    public String getPermissionName()   {
        return this.permissionName;
    }

    @XmlElement(name = "permissionname")
    public void setPermissionName(String permissionName)   {
        this.permissionName = permissionName;
    }


    public UserPermissionListDto getUserPermissionPermissions()   {
        return this.userPermissionPermissions;
    }

    public void setUserPermissionPermissions(UserPermissionListDto userPermissionPermissions)   {
        this.userPermissionPermissions = userPermissionPermissions;
    }

}