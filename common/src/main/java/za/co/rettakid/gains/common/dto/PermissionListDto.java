package za.co.rettakid.gains.common.dto;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "permissionlistdto")
public class PermissionListDto   {

    @XmlElementWrapper(name = "permissions")
    @XmlElement(name = "permissiondto",type = PermissionDto.class)
    private List<PermissionDto> permissions = new ArrayList<PermissionDto>();

    public List<PermissionDto> getPermissionList()   {
        return this.permissions;
    }

    public void addPermissionList(List<PermissionDto> permissions)   {
        this.permissions.addAll(permissions);
    }
}