package com.saiful.androidrxnetworkcalling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

public class RxExample {

    public RxExample() {

        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onNext(Integer s) {
                System.out.println("MyObserver onNext(): " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Observer complete");
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        Observable<String> createObservable = Observable.
                create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {

                        subscriber.onNext("Hello World");
                        subscriber.onCompleted();
                    }
                });
        //createObservable.subscribe(myObserver);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Observable<Integer> fromObservable = Observable.from(numbers);
        //   fromObservable.subscribe(myObserver);

        Observable<Integer> justObservable = Observable.just(5, 5, 5, null).map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer * 5;
            }
        });
        justObservable.subscribe(myObserver);

        Observable intervalObservable = Observable.interval(1, TimeUnit.SECONDS);
        //intervalObservable.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
