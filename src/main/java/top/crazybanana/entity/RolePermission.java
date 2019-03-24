package top.crazybanana.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/21 15:03
 */
@Data
@Builder
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "permission_id")
    private Permission permission;
}