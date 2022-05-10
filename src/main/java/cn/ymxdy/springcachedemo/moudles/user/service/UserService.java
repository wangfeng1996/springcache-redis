package cn.ymxdy.springcachedemo.moudles.user.service;

import cn.ymxdy.springcachedemo.moudles.user.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/26 15:02
 * @description
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 更新接口
     *
     * @param userEntity
     */
    void update(UserEntity userEntity);

    /**
     * 添加接口
     *
     * @param userEntity
     */
    void addUser(UserEntity userEntity);


    /**
     * 查询所有的接口
     *
     * @return
     */
    List<UserEntity> search();

    /**
     * chauxn
     * @param id
     * @return
     */
    UserEntity getById(String id);


    /**
     * 查询所有的接口
     *
     * @return
     */
    List<UserEntity> findAll();
}
