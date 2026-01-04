package org.tbcs;

public class Driver {
    private String id;
    private String name;
    private String licenseNumber;
    private boolean available;

    public Driver(String id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.available = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
