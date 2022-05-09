package cn.ymxdy.springcachedemo.aspect;

import cn.ymxdy.springcachedemo.dao.LogDetailMapper;
import cn.ymxdy.springcachedemo.entity.LogDetail;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author wf
 * @version 1.0
 * @date 2022/5/9 14:28
 * @discription 系统日志，定义切面的处理类
 */
@Aspect
@Slf4j
@Component
public class AutoLogAspect {
    @Autowired
    private LogDetailMapper logDetailMapper;

    /**
     * 将自定义注解的@webLog注解作为切点
     */
    @Pointcut("@annotation(cn.ymxdy.springcachedemo.aspect.annotation.WebLog)")
    public void webLog() {
    }


    /**
     * 定义环绕通知
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 记录调用接口的时间
        long startTime = System.currentTimeMillis();
        // 执行切点，切点返回的结果
        Object result = proceedingJoinPoint.proceed();
        log.info("Response Args : {}", new Gson().toJson(result));
        long time = System.currentTimeMillis() - startTime;
        saveSysLog(proceedingJoinPoint, time, result);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogDetail detail = new LogDetail();
        detail.setTime(TimeUnit.MILLISECONDS.toSeconds(time) + "秒");
        detail.setOperator("wangfeng");
        detail.setResult(result.toString());
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        detail.setMethodName(className + "." + methodName + "()");
        detail.setCreateTime(new Date());
        detail.setUpdateTime(new Date());
        logDetailMapper.insert(detail);
    }

}
