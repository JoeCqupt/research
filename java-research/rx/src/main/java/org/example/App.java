package org.example;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(
                        v-> System.out.println(v),
                        t-> t.printStackTrace(),
                        ()-> System.out.println("finished")
                );

        Thread.currentThread().join();
    }
}
