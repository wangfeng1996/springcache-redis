package cn.ymxdy.springcachedemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wf
 * @date 2022/5/9 14:52
 * @description
 */
@Data
@TableName("log_details")
public class LogDetail implements Serializable {
    private static final long serialVersionUID = 8482720462943906924L;
    /**
     * 操作的用户
     */
    @TableId(value = "operator_id", type = IdType.AUTO)
    private Integer operatorId;

    private String operator;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.DEFAULT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 操作时长
     */
    private String time;
    /**
     * 返回的结果
     */
    private String result;
    /**
     * 操作的的方法名
     */
    private String methodName;
}
