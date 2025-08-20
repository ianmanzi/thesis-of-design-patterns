// Flyweight for common data point properties
class DataPointIntrinsicState { // Shared by many DataPoint objects
    private final String timestamp;
    private final String dataType;
    // Constructor, getters...
}

class DataPointFactory { // Manages shared intrinsic states
    private static final Map<String, DataPointIntrinsicState> states = new HashMap<>();
    public static DataPointIntrinsicState getIntrinsicState(String timestamp, String dataType) {
        String key = timestamp + "_" + dataType;
        return states.computeIfAbsent(key, k -> new DataPointIntrinsicState(timestamp, dataType));
    }
}

class DataPoint { // Extrinsic state (unique to each point)
    private final double value;
    private final DataPointIntrinsicState intrinsicState;

    public DataPoint(double value, String timestamp, String dataType) {
        this.value = value;
        this.intrinsicState = DataPointFactory.getIntrinsicState(timestamp, dataType);
    }
    //...
}

// Singleton for Database Connection Pool
class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    private DatabaseConnectionPool() { /* Initialize pool */ }
    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }
    // Methods to get/release connections
}
