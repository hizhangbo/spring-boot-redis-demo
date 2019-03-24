package top.crazybanana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.crazybanana.entity.UserRole;

/**
 * @Author: Bob
 * @Datetime: 2019-02-21 1:39
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
