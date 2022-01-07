package com.rl.spring_security.thread.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Ren
 * @description 测试使用线程池执行定时任务
 * @date 2022/1/7 13:44
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        // 任务需要2000ms才能执行完
        TimerTask timerTask = new TimerTask(2000);
        System.out.printf("起始时间: %s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        // 延时1s后按3s的周期执行任务
        timer.scheduleAtFixedRate(timerTask, 1000, 3000, TimeUnit.MILLISECONDS);
    }

    private static class TimerTask implements Runnable {

        private final int sleepTime;
        private final SimpleDateFormat dateFormat;

        public TimerTask(int sleepTime) {
            this.sleepTime = sleepTime;
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public void run() {

            System.out.println("任务开始执行,当前时间为:" + dateFormat.format(new Date()));

            try {
                System.out.println("模拟任务运行.....");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            System.out.println("任务结束,当前时间为:" + dateFormat.format(new Date()));
            System.out.println();
        }
    }
}
