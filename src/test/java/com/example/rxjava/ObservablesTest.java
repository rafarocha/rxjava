package com.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class ObservablesTest {

    @Test
    public void simples() {
        AtomicReference<String> result = new AtomicReference<>();
        Observable<String> observable = Observable.just("hello");
        observable.subscribe(s -> result.set(s) );
        Assertions.assertEquals("hello", result.get());
    }

}