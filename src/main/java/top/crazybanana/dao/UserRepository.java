package top.crazybanana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.crazybanana.entity.User;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/20 19:12
 */
public interface UserRepository extends JpaRepository<User, Long> {

}