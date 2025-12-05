package multy.threads;

import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class t1114Foo {

}

class Foo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int state = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (state != 1) {
                condition.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            state++;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (state != 2) {
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            state++;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while(state != 3) {
                condition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            state++;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
