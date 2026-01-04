package org.tbcs;

import java.util.*;

class OrderService {
    private Map<String, Order> orders;
    private int currentQueueNumber;
    private int currentServingNumber;

    public OrderService() {
        orders = new HashMap<>();
        currentQueueNumber = 1000;
        currentServingNumber = 1001;
    }

    public Order placeOrder(Customer customer, List<String> items, double amount) {
        String orderId = "ORD" + System.currentTimeMillis();
        Order order = new Order(orderId, customer.getId(), items, amount);

        // discount for registered customers
        if (customer.isRegistered()) {
            double discount = customer.getDiscount();
            double discountedAmount = amount * (1 - discount);
            order.setTotalAmount(discountedAmount);
            System.out.println("Discount applied: " + (discount * 100) + "%");
        }

        currentQueueNumber++;
        order.setQueueNumber(currentQueueNumber);

        customer.incrementOrderCount();

        orders.put(orderId, order);

        System.out.println("\n=== ORDER PLACED ===");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Items: " + items);
        System.out.println("Total Amount: $" + String.format("%.2f", order.getTotalAmount()));
        System.out.println("Queue Number: " + order.getQueueNumber());
        System.out.println("Current Serving: " + currentServingNumber);

        // Save to XML
        XMLHandler.saveOrderToXML(order, "order_" + orderId + ".xml");

        return order;
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public int getCurrentServingNumber() {
        return currentServingNumber;
    }

    public void updateCurrentServing() {
        currentServingNumber++;
    }
}
