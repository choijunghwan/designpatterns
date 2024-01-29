package org.example.observer.monitoring;

import java.util.List;

public class StatisticsLogDisplay implements Observer {
    private LogData data;

    public StatisticsLogDisplay(LogData data) {
        this.data = data;
        data.registerObserver(this);
    }

    @Override
    public void update() {
        int lastLogIndex = data.getLastLogIndex();
        List<RestfulAPILogFormat> logs = data.getLog();

        display(lastLogIndex, logs);
    }

    private void display(int lastLogIndex, List<RestfulAPILogFormat> logs) {
        for (int i = lastLogIndex; i < logs.size(); i++) {
            System.out.println("status: " + logs.get(i).getStatus() + ", message: " + logs.get(i).getMessage());
        }
    }
}
