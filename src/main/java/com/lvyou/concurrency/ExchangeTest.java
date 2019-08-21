package com.lvyou.concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: VernLv
 * @Data: Create in 14:04 2019/8/19
 */
public class ExchangeTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String args[]){


        pool.execute(new Runnable() {
            public void run() {
                String A = "银行流水A";
                try {
                    A = exgr.exchange(A);
                    System.out.println("A 当前的值：" + A);
                }catch (InterruptedException e){

                }
            }
        });

        pool.execute(new Runnable() {
            public void run() {
                String B = "银行流水B";
                try {
                    B = exgr.exchange(B);
                    System.out.println("B 当前的值：" + B);
                }catch (InterruptedException e){

                }
            }
        });

        pool.shutdown();
    }
}
