package com.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ObservablesTest {

    @Test
    public void simples() {
        AtomicReference<String> result = new AtomicReference<>();
        Observable<String> observable = Observable.just("hello");
        observable.subscribe(s -> result.set(s) );
        Assertions.assertEquals("hello", result.get());
    }

    @Test
    public void map() {
        AtomicReference<List<Integer>> result = new AtomicReference<>(new ArrayList<>());
        Observable<Integer> observable = Observable.just(1, 3, 5, 7, 11);
        observable
            .filter(k -> k % 2 == 1)
            .map(a -> a * 2)
            .subscribe( n -> result.get().add(n) );

        Assertions.assertEquals(List.of(2, 6, 10, 14, 22), result.get());
    }

}