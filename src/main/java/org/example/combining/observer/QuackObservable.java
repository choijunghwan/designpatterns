package org.example.combining.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);

    void notifyObservers();
}
