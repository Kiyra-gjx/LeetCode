package multy.threads;

public class t1115FooBar {
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            if (permitFoo) {
                printFoo.run();
                i++;
                permitFoo = false;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {
            if (!permitFoo) {
                printBar.run();
                i++;
                permitFoo = true;
            } else {
                Thread.yield();
            }
        }
    }
}
