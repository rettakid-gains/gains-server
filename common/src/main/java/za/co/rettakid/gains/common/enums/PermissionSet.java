package za.co.rettakid.gains.common.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lwazi Prusent on 2015/10/31.
 */
public enum PermissionSet {
    TEST(PermissionEnum.TEST);

    private List<PermissionEnum> permission;

    PermissionSet(PermissionEnum... permission) {
        this.permission = Arrays.asList(permission);
    }

    public List<PermissionEnum> getPermission() {
        return permission;
    }

    public void setPermission(List<PermissionEnum> permission) {
        this.permission = permission;
    }
}