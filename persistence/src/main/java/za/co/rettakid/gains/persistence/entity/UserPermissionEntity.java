package za.co.rettakid.gains.persistence.entity;

import javax.persistence.*;
import java.util.List;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "MEDS_USER_PERMISSION")
public class UserPermissionEntity    {

    private Long userPermissionId;
    private UserEntity user;
    private PermissionEntity permission;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name="USER_PERMISSION_ID" , length=15 , nullable=false)
    public Long getUserPermissionId()   {
        return this.userPermissionId;
    }

    public void setUserPermissionId(Long userPermissionId)   {
        this.userPermissionId = userPermissionId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID", referencedColumnName="USER_ID")
    public UserEntity getUser()   {
        return this.user;
    }

    public void setUser(UserEntity user)   {
        this.user = user;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PERMISSION_ID", referencedColumnName="PERMISSION_ID")
    public PermissionEntity getPermission()   {
        return this.permission;
    }

    public void setPermission(PermissionEntity permission)   {
        this.permission = permission;
    }


}