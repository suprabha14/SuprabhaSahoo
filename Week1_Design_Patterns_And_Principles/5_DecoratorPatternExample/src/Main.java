public class Main {
    public static void main(String[] args) {
       
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier allNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        allNotifier.send("Hello, this is a test notification!");
    }
}
