package org.example.rx;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class SubscribeTest {
    public static void main(String[] args) throws Exception {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(
                        v -> System.out.println(v),
                        t -> t.printStackTrace(),
                        () -> System.out.println("finished")
                );


        Flux.range(1, 5)
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        System.out.println("Subscribe");
                        request(1);

                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("value:" + value);
                        request(1);
                    }
                });

        Thread.currentThread().join();
    }
}
