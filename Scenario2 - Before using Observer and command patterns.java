// A single class responsible for all notification logic
public class LegacyNotificationManager {

    // This method handles all notification types directly
    public void sendNotification(String type, String recipient, String message) {
        if ("email".equals(type)) {
            // Direct call to email sending logic, may be synchronous
            System.out.println("Sending email to " + recipient + ": " + message);
            //... complex logic for setting up email connection and sending
        } else if ("sms".equals(type)) {
            // Direct call to SMS sending logic
            System.out.println("Sending SMS to " + recipient + ": " + message);
            //... complex logic for SMS gateway integration
        } else if ("push".equals(type)) {
            // Direct call to push notification logic
            System.out.println("Sending push notification to " + recipient + ": " + message);
            //... complex logic for mobile push services
        } else {
            System.err.println("Unsupported notification type: " + type);
        }
    }
}

// A separate part of the application that needs to send notifications
public class ApplicationClient {

    public static void main(String args) {
        LegacyNotificationManager manager = new LegacyNotificationManager();

        // Direct calls from the application client to the manager.
        // The client is coupled to the manager's specific methods and logic.
        // These calls are synchronous and will block the application thread.
        System.out.println("Application logic begins...");
        manager.sendNotification("email", "user@example.com", "Your order has shipped!");
        manager.sendNotification("push", "device-token-12345", "Special offer just for you.");
        System.out.println("Application logic continues...");
    }
}
