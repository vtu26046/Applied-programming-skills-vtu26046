import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Store check-in details: id -> (station, time)
    private Map<Integer, CheckIn> checkInMap;

    // Store route data: "start-end" -> (totalTime, count)
    private Map<String, Trip> routeMap;

    // Helper class for check-in info
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route info
    class Trip {
        int totalTime;
        int count;

        Trip(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    // Constructor
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    // Check-in
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    // Check-out
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);

        String startStation = checkIn.station;
        int startTime = checkIn.time;

        String key = startStation + "-" + stationName;
        int travelTime = t - startTime;

        Trip trip = routeMap.getOrDefault(key, new Trip(0, 0));
        trip.totalTime += travelTime;
        trip.count += 1;

        routeMap.put(key, trip);

        // Remove user after checkout
        checkInMap.remove(id);
    }

    // Get average time
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        Trip trip = routeMap.get(key);

        return (double) trip.totalTime / trip.count;
    }
}