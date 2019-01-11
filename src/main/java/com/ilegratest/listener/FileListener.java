package com.ilegratest.listener;

import java.util.List;
import java.util.concurrent.Flow;

public abstract class FileListener implements Flow.Subscriber<List<String>> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(10);
    }

    @Override
    public void onNext(List<String> item) {
        System.out.println("Proccessing next item");
        this.proccess(item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error");
    }

    @Override
    public void onComplete() {
        System.out.println("All messages read");
    }


    public abstract void proccess(List<String> lines);
}
