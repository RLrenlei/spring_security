package com.rl.spring_security.task.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * @author Ren
 * @description 打印任意内容的job
 * @date 2022/1/7 10:22
 */
public class PrintWordJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("PrintWordJob start at: " + printTime + ",prints: helloJob-" + new Random().nextInt(100));
    }
}
