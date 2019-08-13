package com.lvyou.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: VernLv
 * @Data: Create in 21:00 2019/8/12
 */
public class ConditionWaitNotifyService {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();


    public void await(){
        try{
            lock.lock();
            System.out.println("await的时间为 " + System.currentTimeMillis());
            condition.await();
            System.out.println("await结束的时间" + System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void signal(){
        try{
            lock.lock();
            System.out.println("sign的时间为" + System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ConditionWaitNotifyService service = new ConditionWaitNotifyService();
        new Thread(service::await).start();
        Thread.sleep(1000 * 3);
        service.signal();
        Thread.sleep(1000);
    }
}
