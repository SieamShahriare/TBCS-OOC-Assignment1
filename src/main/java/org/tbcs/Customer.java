package org.tbcs;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private boolean registered;
    private int monthlyOrderCount;

    public Customer(String id, String name, String phone, boolean registered) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.registered = registered;
        this.monthlyOrderCount = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isRegistered() { return registered; }
    public int getMonthlyOrderCount() { return monthlyOrderCount; }
    public void incrementOrderCount() { monthlyOrderCount++; }

    public double getDiscount() {
        if (!registered) return 0;
        if (monthlyOrderCount >= 10) return 0.15;
        if (monthlyOrderCount >= 5) return 0.10;
        if (monthlyOrderCount >= 1) return 0.05;
        return 0;
    }
}