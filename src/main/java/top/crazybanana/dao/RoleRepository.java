package top.crazybanana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.crazybanana.entity.Role;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/20 20:04
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}