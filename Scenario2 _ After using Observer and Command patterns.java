// Observer Pattern for decoupling
interface NotificationObserver { void update(Notification notification); }
class EmailSender implements NotificationObserver { /*... */ }
class SMSSender implements NotificationObserver { /*... */ }
class PushSender implements NotificationObserver { /*... */ }

class NotificationService { // Subject
    private List<NotificationObserver> observers = new ArrayList<>();
    public void addObserver(NotificationObserver observer) { /*... */ }
    public void notifyObservers(Notification notification) { /*... */ }
}

// Command Pattern for asynchronous processing
interface Command { void execute(); }
class SendNotificationCommand implements Command {
    private Notification notification;
    private NotificationObserver sender;
    public SendNotificationCommand(Notification n, NotificationObserver s) { /*... */ }
    public void execute() { sender.update(notification); }
}

// Application logic:
NotificationService service = new NotificationService();
service.addObserver(new EmailSender());
service.addObserver(new SMSSender());
//...
// When a notification needs to be sent:
Notification notification = new Notification("User A", "New message");
for (NotificationObserver sender : service.getObservers()) {
    Command command = new SendNotificationCommand(notification, sender);
    CommandQueue.add(command); // Asynchronously processed by worker threads
}
