package org.tbcs;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nTASTEBUDS CATERING SYSTEM (TBCS)");

        OrderService orderService = new OrderService();
        HeadChefService chefService = new HeadChefService();
        DeliveryService deliveryService = new DeliveryService();
        FeedbackService feedbackService = new FeedbackService();

        // Customers
        Customer customer1 = new Customer("CUST1", "Karim Abdullah", "01712345678", true);
        customer1.incrementOrderCount();
        customer1.incrementOrderCount();
        customer1.incrementOrderCount();

        Customer customer2 = new Customer("CUST002", "Abdul Rahman", "01898765432", false);

        System.out.println("- " + customer1.getName() + " (Registered, " + customer1.getMonthlyOrderCount() + " orders this month)");
        System.out.println("- " + customer2.getName() + " (Guest)\n");

        // Priority order
        System.out.println("\nPriority Order =>\n");
        List<String> items1 = Arrays.asList("Biryani", "Butter Chicken", "Naan", "Raita", "Salad", "Dessert");
        Order order1 = orderService.placeOrder(customer1, items1, 1200.0);

        chefService.prepareOrder(order1);
        chefService.markOrderReady(order1);
        deliveryService.assignDelivery(order1);
        deliveryService.driverCheckout(order1, "DL12345");
        feedbackService.markDelivered(order1);
        feedbackService.submitFeedback(order1, 5, "Good food and fast delivery");

        // Normal order
        System.out.println("\nNormal Order =>\n");
        List<String> items2 = Arrays.asList("Chicken Tikka", "Rice", "Drinks");
        Order order2 = orderService.placeOrder(customer2, items2, 450.0);

        chefService.prepareOrder(order2);
        chefService.markOrderReady(order2);
        deliveryService.assignDelivery(order2);
        deliveryService.driverCheckout(order2, "DL67890");
        feedbackService.markDelivered(order2);
        feedbackService.submitFeedback(order2, 4, "Food was good but slow delivery");

        // Registered customer (increased discount)
        System.out.println("\nRegular Customer Order => \n");
        System.out.println("Customer " + customer1.getName() + " now has " + customer1.getMonthlyOrderCount() + " orders this month");

        List<String> items3 = Arrays.asList("Beef Kebab", "Paratha", "Tea");
        Order order3 = orderService.placeOrder(customer1, items3, 600.0);

        chefService.prepareOrder(order3);
        chefService.markOrderReady(order3);
        deliveryService.assignDelivery(order3);
        deliveryService.driverCheckout(order3, "DL54321");
        feedbackService.markDelivered(order3);
        feedbackService.submitFeedback(order3, 4, "Good as always!");

        // Summary
        System.out.println("\n========================================");
        System.out.println("  SUMMARY");
        System.out.println("========================================");
        System.out.println("Total orders processed: 3");
        System.out.println("Current serving number: " + orderService.getCurrentServingNumber());
        System.out.println("\nAll order details and checkouts saved to XML files");
        System.out.println("Check the following files:");
        System.out.println("- order_" + order1.getOrderId() + ".xml");
        System.out.println("- order_" + order2.getOrderId() + ".xml");
        System.out.println("- order_" + order3.getOrderId() + ".xml");
        System.out.println("- checkout_" + order1.getOrderId() + ".xml");
        System.out.println("- checkout_" + order2.getOrderId() + ".xml");
        System.out.println("- checkout_" + order3.getOrderId() + ".xml");
        System.out.println("\n========================================");
    }
}
