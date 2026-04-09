import java.util.*;

class UndergroundSystem {

    // Stores check-in details: id -> (station, time)
    private Map<Integer, Pair> checkInMap;

    // Stores route data: "start-end" -> (totalTime, count)
    private Map<String, int[]> travelMap;

    // Helper class
    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);

        String route = p.station + "-" + stationName;
        int travelTime = t - p.time;

        travelMap.putIfAbsent(route, new int[2]);
        int[] data = travelMap.get(route);

        data[0] += travelTime; // total time
        data[1] += 1;          // count

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int[] data = travelMap.get(route);

        return (double) data[0] / data[1];
    }
}