package za.co.rettakid.gains.persistence.entity;

import javax.persistence.*;
import java.util.List;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "MEDS_PERMISSION")
public class PermissionEntity    {

    private Long permissionId;
    private String permissionName;
    private List<UserPermissionEntity> userPermissionPermissions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name="PERMISSION_ID" , length=15 , nullable=false)
    public Long getPermissionId()   {
        return this.permissionId;
    }

    public void setPermissionId(Long permissionId)   {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name="PERMISSION_NAME" , length=50 , nullable=false)
    public String getPermissionName()   {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName)   {
        this.permissionName = permissionName;
    }


    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    public List<UserPermissionEntity> getUserPermissionPermissions()   {
        return this.userPermissionPermissions;
    }

    public void setUserPermissionPermissions(List<UserPermissionEntity> userPermissionPermissions)   {
    this.userPermissionPermissions = userPermissionPermissions;
    }

}