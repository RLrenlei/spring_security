package com.rl.spring_security.task.schedule;

import com.rl.spring_security.task.job.PrintWordJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Ren
 * @description 调度器
 * @date 2022/1/7 10:29
 */
public class MyScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1.创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2.创建JobDetail实例,并与PrintWordJob类绑定
        JobDetail jobDetail = JobBuilder.newJob(PrintWordJob.class)
                .withIdentity("job1","group1").build();
        // 3.构建trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","triggerGroup1")
                // 立即生效
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        //每隔一秒执行一次,一直执行
                        .withIntervalInSeconds(10).repeatForever())
                .build();
        // 4.执行
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("--------------scheduler start !------------------");
        scheduler.start();
        // 5.睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("--------------scheduler shutdown !------------------");
    }
}
