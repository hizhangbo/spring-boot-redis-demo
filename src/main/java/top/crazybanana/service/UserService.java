package top.crazybanana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.crazybanana.dao.UserRepository;
import top.crazybanana.entity.User;

import java.util.List;

/**
 * @Author: Bob
 * @Datetime: 2019-03-14 0:28
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(cacheNames = "users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
