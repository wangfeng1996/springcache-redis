package cn.ymxdy.springcachedemo.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author wf
 * @version 1.0
 * @date 2022/5/9 14:28
 * @discription 系统日志，定义切面的处理类
 */
@Retention(RetentionPolicy.RUNTIME)  // 1、定义运行的时间
@Target({ElementType.METHOD})        // 2、定义作用的范围
@Documented                          // 3、注解是否包含在Javadoc中
public @interface WebLog {  // 定义注解名称
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";   // 默认值为空

}
