package org.tbcs;

import java.util.*;

class DeliveryService {
    private List<Driver> drivers;

    public DeliveryService() {
        drivers = new ArrayList<>();
        drivers.add(new Driver("DRV001", "Ali Rahman", "DL12345"));
        drivers.add(new Driver("DRV002", "Sara Khan", "DL67890"));
        drivers.add(new Driver("DRV003", "Fahim Ahmed", "DL54321"));
    }

    public void assignDelivery(Order order) {
        System.out.println("\n=== DELIVERY ASSIGNMENT ===");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Priority: " + (order.isPriority() ? "YES" : "NO"));

        Driver assignedDriver = findAvailableDriver();
        if (assignedDriver != null) {
            order.setDeliveryStaff(assignedDriver.getName());
            assignedDriver.setAvailable(false);

            if (order.isPriority()) {
                System.out.println("Priority delivery assigned within 10 minutes");
            } else {
                System.out.println("Normal delivery assigned based on availability");
            }

            System.out.println("Assigned Driver: " + assignedDriver.getName());
            System.out.println("License Number: " + assignedDriver.getLicenseNumber());

            order.setStatus("OUT_FOR_DELIVERY");

            // Save to XML
            XMLHandler.saveOrderToXML(order, "order_" + order.getOrderId() + ".xml");
        } else {
            System.out.println("No drivers available at the moment");
        }
    }

    private Driver findAvailableDriver() {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }

    public Driver getDriverByLicense(String licenseNumber) {
        for (Driver driver : drivers) {
            if (driver.getLicenseNumber().equals(licenseNumber)) {
                return driver;
            }
        }
        return null;
    }

    public void driverCheckout(Order order, String licenseNumber) {
        System.out.println("\n=== DRIVER CHECKOUT ===");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Driver License: " + licenseNumber);

        Driver driver = getDriverByLicense(licenseNumber);
        if (driver != null && order.getDeliveryStaff().equals(driver.getName())) {
            System.out.println("Driver: " + driver.getName());
            System.out.println("Checkout successful - Delivery in progress");

            // Save checkout to XML
            XMLHandler.saveDriverCheckoutToXML(order.getOrderId(), licenseNumber,
                    "checkout_" + order.getOrderId() + ".xml");
        } else {
            System.out.println("Invalid driver or license number");
        }
    }
}
