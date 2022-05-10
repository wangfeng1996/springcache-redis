package cn.ymxdy.springcachedemo.moudles.user.dao;

import cn.ymxdy.springcachedemo.moudles.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wf
 * @date 2022/4/26 14:52
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
