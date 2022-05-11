package cn.ymxdy.springcachedemo.moudles.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description:  制定定时任务，规定时间段执行一次业务
 * @Author by wf
 * @Date 2022/5/11 15:51
 */
@Slf4j
public class CallPayQuartzTask extends QuartzJobBean {


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("hello world");

    }

}
