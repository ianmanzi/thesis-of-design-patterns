// ---------------------- Before the Flyweight Pattern ----------------------
// Each DataPoint object stores all its properties, including the
// redundant timestamp and dataType. This leads to excessive memory consumption.
public class DataPoint {
    private final double value;
    private final String timestamp;
    private final String dataType;

    public DataPoint(double value, String timestamp, String dataType) {
        this.value = value;
        this.timestamp = timestamp;
        this.dataType = dataType;
    }

    public void display() {
        System.out.println("DataPoint: Value=" + value + ", Timestamp=" + timestamp + ", Type=" + dataType);
    }
}


// ---------------------- Before the Singleton Pattern ----------------------
// The application directly instantiates database connections, leading to
// resource contention and high overhead under heavy load.
public class DatabaseConnector {
    public Connection createNewConnection() {
        System.out.println("Creating a new database connection...");
        // This simulates a new, resource-intensive connection being made.
        // In a real application, this would be a line like:
        // return DriverManager.getConnection("jdbc:...", "user", "password");
        return null;
    }
}


// ---------------------- Putting It All Together ----------------------
// An analytics processor that uses the inefficient DataPoint and DatabaseConnector.
public class NaiveAnalyticsProcessor {

    public void runReport() {
        System.out.println("Starting report using inefficient design...");

        // Problem 1: Memory Exhaustion (Flyweight problem)
        // Imagine this loop runs for millions of data points.
        // Each object duplicates the timestamp and data type strings.
        for (int i = 0; i < 1000000; i++) {
            DataPoint point = new DataPoint(
                Math.random() * 100,
                "2025-08-19 12:00:00",
                "sales_data"
            );
            // In a real scenario, these objects would be stored in a list or processed further,
            // quickly filling up memory.
            // point.display();
        }
        System.out.println("Processed 1,000,000 DataPoint objects, each with redundant data. This is highly memory-inefficient.");

        // Problem 2: Resource Contention (Singleton problem)
        // A new connection is created for each operation or even each user request.
        // This is not a centralized or efficient way to manage a shared resource.
        DatabaseConnector dbConnector = new DatabaseConnector();
        Connection connection1 = dbConnector.createNewConnection();
        //... use connection1 to perform a task...

        DatabaseConnector dbConnector2 = new DatabaseConnector();
        Connection connection2 = dbConnector2.createNewConnection();
        //... use connection2 to perform another task...

        System.out.println("Created multiple database connections, leading to high overhead and resource contention.");
    }
}
