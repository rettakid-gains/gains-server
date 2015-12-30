package za.co.rettakid.gains.presentation.vo;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

public class UserPermissionVo    {

    private Long userPermissionId;
    @Valid
    @NotNull
    private UserVo user;
    @Valid
    @NotNull
    private PermissionVo permission;

    public Long getUserPermissionId()   {
        return this.userPermissionId;
    }

    public void setUserPermissionId(Long userPermissionId)   {
        this.userPermissionId = userPermissionId;
    }

    public UserVo getUser()   {
        return this.user;
    }

    public void setUser(UserVo user)   {
        this.user = user;
    }

    public PermissionVo getPermission()   {
        return this.permission;
    }

    public void setPermission(PermissionVo permission)   {
        this.permission = permission;
    }

}