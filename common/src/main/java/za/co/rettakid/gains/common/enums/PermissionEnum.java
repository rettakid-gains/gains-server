package za.co.rettakid.gains.common.enums;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
public enum PermissionEnum {

    TEST(1L,PermissionEnumType.TEST);

    private Long id;
    private PermissionEnumType type;

    PermissionEnum(Long id,PermissionEnumType type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public PermissionEnumType getType() {
        return type;
    }

    public static PermissionEnum get(String permissionEnumString)    {
        for (PermissionEnum permissionEnum : values()) {
            if (permissionEnum.name().equals(permissionEnumString)) {
                return permissionEnum;
            }
        }
        return null;
    }

    public String getCustomPermission(Long id) {
        return name() + "_" + id;
    }

}
