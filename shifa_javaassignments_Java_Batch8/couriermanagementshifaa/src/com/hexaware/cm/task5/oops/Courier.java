package com.hexaware.cm.task5.oops;

/**
 * Represents a Courier object with complete information about the shipment,
 * including sender, receiver, weight, status, delivery date, and tracking number.
 */
public class Courier {
    
    // Static variable to generate unique tracking numbers for each courier
    private static int trackingNumberCounter = 1000;

    // Fields / Attributes
    private int courierID;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private String trackingNumber;
    private String deliveryDate;
    private int userId; // courier staff ID assigned

    // ========================
    // Constructors
    // ========================

    // Default constructor
    public Courier() {}

    // Parametriz constructor
    public Courier(int courierID, String senderName, String senderAddress, String receiverName, 
                   String receiverAddress, double weight, String status, String deliveryDate, int userId) {
        this.courierID = courierID;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.weight = weight;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.userId = userId;

        // Automatically assign a unique tracking number using static counter
        this.trackingNumber = "T" + trackingNumberCounter++;
    }

    // ========================
    // Getters and Setters
    // ========================

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // ========================
    // toString() Method
    // ========================

    @Override
    public String toString() {
        return "Courier [courierID=" + courierID 
            + ", senderName=" + senderName 
            + ", senderAddress=" + senderAddress 
            + ", receiverName=" + receiverName 
            + ", receiverAddress=" + receiverAddress 
            + ", weight=" + weight 
            + ", status=" + status 
            + ", trackingNumber=" + trackingNumber 
            + ", deliveryDate=" + deliveryDate 
            + ", userId=" + userId + "]";
    }
}
