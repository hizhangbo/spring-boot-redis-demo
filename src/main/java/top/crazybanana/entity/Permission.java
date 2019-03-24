package top.crazybanana.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/20 20:02
 */
@Data
@Builder
@Entity
@ToString(exclude = "rolePermissions")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private Set<RolePermission> rolePermissions;
}