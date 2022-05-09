package cn.ymxdy.springcachedemo.service.impl;

import cn.ymxdy.springcachedemo.constant.CacheConstant;
import cn.ymxdy.springcachedemo.dao.UserMapper;
import cn.ymxdy.springcachedemo.entity.UserEntity;
import cn.ymxdy.springcachedemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/26 15:02
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


    @Override
    @CacheEvict(value = CacheConstant.SYS_USER_CACHE, key = "#user")  //根据key清除缓存，一般该注解标注在修改和删除方法上
    public void update(UserEntity user) {
        this.baseMapper.updateById(user);
    }

    @Override
    @CachePut(cacheNames = {"user"}, key = "#user.id",unless = "#result==null") //写入缓存，key为user.id,一般该注解标注在新增方法上
    public void addUser(UserEntity user) {
        this.baseMapper.insert(user);

    }

    @Override
    @Cacheable(value = CacheConstant.SYS_USER_CACHE) // 标志读取缓存操作，如果缓存不存在，则调用目标方法，并将结果放入缓存
    public List<UserEntity> search() {
        return this.baseMapper.selectList(null);
    }

    @Override
    @Cacheable(cacheNames = {"user"}, key = "#id",unless = "#result==null")//如果缓存存在，直接读取缓存值；如果缓存不存在，则调用目标方法，并将结果放入缓存
    public UserEntity getById(String id) {
        System.out.println("缓存不存在");
        UserEntity userEntity = this.baseMapper.selectById(id);
        return userEntity;

    }
}
