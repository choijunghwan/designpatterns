package org.example.observer.monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusCountDisplay implements Observer {
    private LogData data;
    private Map<Integer, Integer> statusTimesMap;

    public StatusCountDisplay(LogData data) {
        this.data = data;
        this.statusTimesMap = new HashMap<>();
        data.registerObserver(this);
    }

    @Override
    public void update() {
        int lastLogIndex = data.getLastLogIndex();
        List<RestfulAPILogFormat> logs = data.getLog();

        for (int i = lastLogIndex; i < logs.size(); i++) {
            int logStatus = logs.get(i).getStatus();

            if (statusTimesMap.containsKey(logStatus)) {
                statusTimesMap.put(logStatus, statusTimesMap.get(logStatus) + 1);
            } else {
                statusTimesMap.put(logStatus, 1);
            }
        }

        display();
    }

    private void display() {
        for (Map.Entry<Integer, Integer> entry : statusTimesMap.entrySet()) {
            System.out.println("status: " + entry.getKey() + ", count: " + entry.getValue());
        }
    }
}
