package multy.threads;

import java.util.concurrent.CountDownLatch;

public class t1114Foo {

}

class Foo {

    private CountDownLatch countDownLatch = new CountDownLatch(3);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        countDownLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(countDownLatch.getCount() != 2);

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        countDownLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(countDownLatch.getCount() != 1);

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        countDownLatch.countDown();
    }
}
