package top.crazybanana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.crazybanana.dao.UserRepository;
import top.crazybanana.entity.User;
import top.crazybanana.service.UserService;

import java.util.List;

/**
 * @author: zhangbo
 * @DateTime: 2019/2/25 14:45
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> users(){
        return userService.getAllUsers();
    }
}