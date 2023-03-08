package org.example.rx;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class SinkTest2 {

    public static void main(String[] args) throws Exception {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        Flux
                .range(1, 50)
                .map(i -> 10 + i)
                .publishOn(s)
                .map(i -> "value " + i).subscribe(System.out::println);


        Thread.currentThread().join();
    }
}
