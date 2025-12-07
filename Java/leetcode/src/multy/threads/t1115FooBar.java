package multy.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class t1115FooBar {
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    ReentrantLock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while(!flag) {
                condition.await();
            }
            printFoo.run();
            flag = false;
            condition.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while(flag) {
                condition.await();
            }
            printBar.run();
            flag = true;
            condition.signal();
            lock.unlock();
        }
    }
}
