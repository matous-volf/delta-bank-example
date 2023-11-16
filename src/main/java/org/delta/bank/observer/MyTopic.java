package org.delta.bank.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message = null;
    private boolean changed = false;
    private final Object MUTEX = new Object();

    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("Null Observer");
        }

        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
                observer.setSubject(this);
            }
        }
    }

    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        List<Observer> observersLocal;

        synchronized (MUTEX) {
            if (!changed) {
                return;
            }

            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;

            for (Observer observer: observersLocal) {
                observer.update();
            }
        }
    }

    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to topic: " + message);
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}
