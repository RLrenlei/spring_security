package com.rl.spring_security.thread.test;

import java.util.concurrent.*;

/**
 * @author Ren
 * @description 实现callable接口异步测试
 * @date 2022/1/7 14:50
 */
public class CallableThreadTest {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new CallThread());

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

// 异步方法
class CallThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }
}
