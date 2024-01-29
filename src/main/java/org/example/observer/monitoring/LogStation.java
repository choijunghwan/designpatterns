package org.example.observer.monitoring;

public class LogStation {
    public static void main(String[] args) {
        LogData logData = new LogData();

        StatisticsLogDisplay statisticsLogDisplay = new StatisticsLogDisplay(logData);
        StatusCountDisplay statusCountDisplay = new StatusCountDisplay(logData);

        logData.setRestfulAPIResult(new RestfulAPILogFormat(200, "ok"));
        logData.setRestfulAPIResult(new RestfulAPILogFormat(400, "bad request"));
        logData.setRestfulAPIResult(new RestfulAPILogFormat(500, "server internal error"));
        System.out.println("==========================================");
        logData.setRestfulAPIResult(new RestfulAPILogFormat(200, "ok"));
        logData.setRestfulAPIResult(new RestfulAPILogFormat(404, "not found"));
        logData.setRestfulAPIResult(new RestfulAPILogFormat(401, "unauthorized"));
    }
}
