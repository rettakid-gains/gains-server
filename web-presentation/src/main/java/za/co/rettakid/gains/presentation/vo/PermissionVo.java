package za.co.rettakid.gains.presentation.vo;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

public class PermissionVo    {

    private Long permissionId;
    @NotBlank @NotNull
    private String permissionName;

    public Long getPermissionId()   {
        return this.permissionId;
    }

    public void setPermissionId(Long permissionId)   {
        this.permissionId = permissionId;
    }

    public String getPermissionName()   {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName)   {
        this.permissionName = permissionName;
    }

}