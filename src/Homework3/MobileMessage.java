package Homework3;

public class MobileMessage extends Message {
    String senderPhoneNumber;
    String recipientPhoneNumber;

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public MobileMessage() {

    }

    public MobileMessage(String senderPhoneNumber, String recipientPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public MobileMessage(String text, String senderPhoneNumber, String recipientPhoneNumber) {
        super(text);
        this.senderPhoneNumber = senderPhoneNumber;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }
}
