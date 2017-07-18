package Homework3;

public class PushMessage extends Message {
    String deviceId;
    String applicationId;

    public PushMessage() {
    }

    @Override
    public String toString() {
        return "PushMessage{" +
                "deviceId='" + deviceId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public PushMessage(String deviceId, String applicationId) {

        this.deviceId = deviceId;
        this.applicationId = applicationId;
    }

    public PushMessage(String text, String deviceId, String applicationId) {
        super(text);
        this.deviceId = deviceId;
        this.applicationId = applicationId;
    }
}
