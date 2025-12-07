package multy.threads;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class t1115FooBar {
}

class FooBar {
    private int n;
    private BlockingDeque<Integer> bar = new LinkedBlockingDeque<>(1);
    private BlockingDeque<Integer> foo = new LinkedBlockingDeque<>(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.put(i);
            printFoo.run();
            bar.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.take();
            printBar.run();
            foo.take();
        }
    }
}
