package org.tbcs;

public class Chef {
    private String id;
    private String name;
    private boolean available;

    public Chef(String id, String name) {
        this.id = id;
        this.name = name;
        this.available = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}