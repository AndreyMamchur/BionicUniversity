package Homework3;

public class SMS extends MobileMessage {

    public SMS() {

    }

    public SMS(String senderPhoneNumber, String recipientPhoneNumber) {
        super(senderPhoneNumber, recipientPhoneNumber);
    }

    public SMS(String text, String senderPhoneNumber, String recipientPhoneNumber) {
        super(text, senderPhoneNumber, recipientPhoneNumber);
    }

    @Override
    public String toString() {
        return "SMS{" +
                "senderPhoneNumber='" + senderPhoneNumber + '\'' +
                ", recipientPhoneNumber='" + recipientPhoneNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
