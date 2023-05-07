package org.example.asm.core.method;

import java.util.concurrent.TimeUnit;

public class TestClass {
    public void func1() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    public void func2() throws Exception {
        long time = 0 - System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(1);
        time = time + System.currentTimeMillis();
    }
}
