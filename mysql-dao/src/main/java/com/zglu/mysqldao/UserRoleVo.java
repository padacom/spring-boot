package com.zglu.mysqldao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleVo {
    private int id;
    private String name;
    private String roleName;

    public UserRoleVo(User u, UserRole ur) {
        this.id = u.getId();
        this.name = u.getName();
        this.roleName = ur.getRoleId() + "";
    }
}
