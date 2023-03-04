package design;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LogAggregator {

    private ConcurrentHashMap<Integer, List<Integer>> serviceLogs;
    private ConcurrentHashMap<Integer, List<Integer>> machineLogs;
    private ConcurrentHashMap<Integer, String> logs;

    public LogAggregator(int machines, int services) {
        this.serviceLogs = new ConcurrentHashMap<>(services);
        this.machineLogs = new ConcurrentHashMap<>(machines);
        this.logs = new ConcurrentHashMap<>();
    }

    public void pushLog(int logId, int machineId, int serviceId, String message) {
        logs.put(logId, message);
        serviceLogs.putIfAbsent(serviceId, new ArrayList<>());
        serviceLogs.get(serviceId).add(logId);


        machineLogs.putIfAbsent(machineId, new ArrayList<>());
        machineLogs.get(machineId).add(logId);

    }

    public List<Integer> getLogsFromMachine(int machineId) {
        return machineLogs.getOrDefault(machineId, new ArrayList<>());
    }

    public List<Integer> getLogsOfService(int serviceId) {
        return serviceLogs.getOrDefault(serviceId, new ArrayList<>());
    }

    public List<String> search(int serviceId, String searchString) {
        List<Integer> logIds = getLogsOfService(serviceId);
        List<String> messages = logIds.stream()
                .map((id) -> logs.get(id))
                .filter((word) -> word.contains(searchString))
                .collect(Collectors.toList());
        return messages;
    }


}
