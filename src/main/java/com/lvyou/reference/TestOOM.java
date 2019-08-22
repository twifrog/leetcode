package com.lvyou.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TestOOM {


    /**
     * -Xms2M -Xmx3M
     * */

    private static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        testStrongReference();
        //testSoftReference();
    }
    /**
     * 强引用，没空间了也不回收
     * */
    private static void testStrongReference() {
        byte[] buff = new byte[1024 * 1024 * 2];
    }
    /**
     * 软引用，堆满了之后会先去回收掉，如果回收后还不够空间才会报溢出的错误
     * */
    private static void testSoftReference() {
        for (int i = 0; i < 3; i++) {
            byte[] buff = new byte[1024 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buff);
            list.add(sr);
        }

        //主动通知垃圾回收
        //System.gc();

        for(int i=0; i < list.size(); i++){
            Object obj = ((SoftReference) list.get(i)).get();
            System.out.println(obj);
        }

    }
    /**
     * 只要一GC就全完
     * */
    private static void testWeakReference() {
        for (int i = 0; i < 10; i++) {
            byte[] buff = new byte[1024 * 1024];
            WeakReference<byte[]> sr = new WeakReference<>(buff);
            list.add(sr);
        }

        System.gc(); //主动通知垃圾回收

        for(int i=0; i < list.size(); i++){
            Object obj = ((WeakReference) list.get(i)).get();
            System.out.println(obj);
        }
    }
}
