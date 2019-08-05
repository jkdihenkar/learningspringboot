package com.jdcomponents.rxjavaexample;

import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.reactivex.Observable;

import java.util.stream.IntStream;

@RestController("RxJavaExample")
public class SimpleRxJava {

    Logger log = LoggerFactory.getLogger(SimpleRxJava.class);

    private Observable<Integer> generateSequence() {
        return Observable.<Integer>create(
                subscriber -> {
                    IntStream stream = IntStream.iterate(1, i -> i + 1);
                    stream.forEach(subscriber::onNext);
                }
        );
    }

    private Integer squareIt(Integer number) {
        log.info("Squaring {} ...", number);
        return number*number;
    }

    private Integer echoMe(Integer number) {
        log.info("Square value is {} ...", number);
        return number;
    }

    @GetMapping("v1/testrx")
    public String printSquaresUpto(@RequestParam(name = "upto") int uptoNum) {
        generateSequence().subscribeOn(Schedulers.newThread())
                .map(num -> squareIt(num))
                .map(num -> echoMe(num))
                .takeWhile(num -> num < (uptoNum*uptoNum)+1)
                .subscribe();
        return "Worked?";
    }

}
