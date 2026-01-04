package org.tbcs;

import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private List<String> items;
    private double totalAmount;
    private int queueNumber;
    private String status;
    private boolean isPriority;
    private String assignedChef;
    private int estimatedTime;
    private String deliveryStaff;
    private int rating;
    private String feedback;

    public Order(String orderId, String customerId, List<String> items, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = "PLACED";
        this.isPriority = false;
        this.rating = 0;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public List<String> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double amount) { this.totalAmount = amount; }
    public int getQueueNumber() { return queueNumber; }
    public void setQueueNumber(int num) { this.queueNumber = num; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isPriority() { return isPriority; }
    public void setPriority(boolean priority) { this.isPriority = priority; }
    public void setAssignedChef(String chef) { this.assignedChef = chef; }
    public void setEstimatedTime(int time) { this.estimatedTime = time; }
    public String getAssignedChef() { return assignedChef; }
    public int getEstimatedTime() { return estimatedTime; }
    public void setDeliveryStaff(String staff) { this.deliveryStaff = staff; }
    public String getDeliveryStaff() { return deliveryStaff; }
    public void setRating(int rating) { this.rating = rating; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public int getRating() { return rating; }
    public String getFeedback() { return feedback; }
}