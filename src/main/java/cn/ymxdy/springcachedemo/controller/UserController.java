package cn.ymxdy.springcachedemo.controller;

import cn.ymxdy.springcachedemo.entity.UserEntity;
import cn.ymxdy.springcachedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/26 15:17
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.search();
    }

    @PutMapping("/add")
    public void addUser(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody UserEntity userEntity) {
        userService.update(userEntity);
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable String id) {
        UserEntity entity = userService.getById(id);
        return entity;
    }

    @GetMapping("/findall")
    public List findAll() {
        List<UserEntity> all = userService.findAll();
        return all;
    }

}
