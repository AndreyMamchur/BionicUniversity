package Homework3;

public class MMS extends MobileMessage {
    @Override
    public String toString() {
        return "MMS{" +
                "senderPhoneNumber='" + senderPhoneNumber + '\'' +
                ", recipientPhoneNumber='" + recipientPhoneNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public MMS(String text, String senderPhoneNumber, String recipientPhoneNumber) {
        super(text, senderPhoneNumber, recipientPhoneNumber);
    }

    public MMS(String senderPhoneNumber, String recipientPhoneNumber) {

        super(senderPhoneNumber, recipientPhoneNumber);
    }

    public MMS() {

    }
}
