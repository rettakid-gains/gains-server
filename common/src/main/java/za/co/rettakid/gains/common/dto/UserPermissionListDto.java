package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "userpermissionlistdto")
public class UserPermissionListDto   {

    @XmlElementWrapper(name = "userpermissions")
    @XmlElement(name = "userpermissiondto",type = UserPermissionDto.class)
    private List<UserPermissionDto> userPermissions = new ArrayList<UserPermissionDto>();

    public List<UserPermissionDto> getUserPermissionList()   {
        return this.userPermissions;
    }

    public void addUserPermissionList(List<UserPermissionDto> userPermissions)   {
        this.userPermissions.addAll(userPermissions);
    }
}