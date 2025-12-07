package multy.threads;

import java.util.Objects;

public class t1115FooBar {
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean type = true;
    private final Object foo = new Object();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (foo) {
                while(!type) {
                    foo.wait();
                }
                printFoo.run();
                type = false;
                foo.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (foo) {
                while (type) {
                    foo.wait();
                }
                printBar.run();
                type = true;
                foo.notify();
            }
        }
    }
}
