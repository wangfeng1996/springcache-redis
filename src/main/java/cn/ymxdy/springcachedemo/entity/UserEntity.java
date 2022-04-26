package cn.ymxdy.springcachedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangfeng
 */
@TableName("db_user")
@Data
public class UserEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5237730257103305078L;
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String userName;
    private String userSex;

}
