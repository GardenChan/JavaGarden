package dream.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * projectName:java-garden
 * see:dream.concurrent
 * createTime:2021/9/3 17:01
 * author: Garden Chan
 * description: 多线程交替打印
 */
public class ABCPrint {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;
    static class ThreadA extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state%3==0){
                        System.out.println("A");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state%3==1){
                        System.out.println("B");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadC extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state%3==2){
                        System.out.println("C");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
