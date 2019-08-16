package com.lvyou.concurrency;

/**
 * @Author: VernLv
 * @Data: Create in 9:55 2019/8/13
 */
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(demo);
        TestClient t2 = new TestClient(demo);
        TestClient t3 = new TestClient(demo);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalDemo demo;

        public TestClient(ThreadLocalDemo demo) {
            this.demo = demo;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> demo["
                        + demo.getNextNum() + "]");
            }
        }
    }
}
