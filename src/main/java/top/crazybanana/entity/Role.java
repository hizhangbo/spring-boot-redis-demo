package top.crazybanana.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/20 20:00
 */
@Data
@Builder
@Entity
@ToString(exclude = {"userRoles", "rolePermissions"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<RolePermission> rolePermissions;
}