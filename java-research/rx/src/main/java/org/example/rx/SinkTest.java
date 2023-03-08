package org.example.rx;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class SinkTest {

    public static void main(String[] args) throws Exception {
        Flux<String> flux = Flux.generate(
                () -> 1,
                (state, sink) -> {
                    sink.next("generate :" + state);
                    return ++state;
                },
                (state) -> {
                    System.out.println("end state:" + state);
                }
        );

        flux.subscribe(new BaseSubscriber<String>() {
            long subscribeTime;

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                // 这一行必须放在request前面
                subscribeTime = System.currentTimeMillis();

                subscription.request(1);
            }

            @Override
            protected void hookOnNext(String value) {
                System.out.println(value);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long now = System.currentTimeMillis();
                if ( (now - subscribeTime) > 15000) {
                    cancel();
                } else {
                    request(1);
                }
            }
        });


        Thread.currentThread().join();
    }
}
