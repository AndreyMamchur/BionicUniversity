package Homework3;

public class EmailMessage extends Message{
    String senderEmailAddress;
    String recipientEmailAddress;

    public EmailMessage(){

    }

    public EmailMessage(String senderEmailAddress, String recipientEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public EmailMessage(String text, String senderEmailAddress, String recipientEmailAddress) {
        super(text);
        this.senderEmailAddress = senderEmailAddress;
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "senderEmailAddress='" + senderEmailAddress + '\'' +
                ", recipientEmailAddress='" + recipientEmailAddress + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
