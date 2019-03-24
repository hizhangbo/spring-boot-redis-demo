package top.crazybanana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.crazybanana.entity.RolePermission;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/21 15:27
 */
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}