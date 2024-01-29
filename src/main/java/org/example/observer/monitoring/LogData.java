package org.example.observer.monitoring;

import java.util.ArrayList;
import java.util.List;

public class LogData implements Subject {
    private List<Observer> observers;
    private int count;
    private List<RestfulAPILogFormat> log;
    private int lastLogIndex = 0;

    public LogData() {
        this.observers = new ArrayList<Observer>();
        count = 0;
        this.log = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
        lastLogIndex = count;
    }

    public void logCountChanged() {
        // 로그데이터가 3개 쌓일때 마다 옵저버에게 데이터를 전달
        if (count % 3 == 0) {
            notifyObservers();
        }
    }

    public void setRestfulAPIResult(RestfulAPILogFormat logFormat) {
        this.log.add(logFormat);
        count++;
        logCountChanged();
    }

    public int getLastLogIndex() {
        return lastLogIndex;
    }

    public List<RestfulAPILogFormat> getLog() {
        return log;
    }
}
