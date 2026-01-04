package org.tbcs;

import java.util.*;

class HeadChefService {
    private List<Chef> chefs;

    public HeadChefService() {
        chefs = new ArrayList<>();
        chefs.add(new Chef("CH001", "Chef John"));
        chefs.add(new Chef("CH002", "Chef Maria"));
        chefs.add(new Chef("CH003", "Chef Ahmed"));
    }

    public void prepareOrder(Order order) {
        System.out.println("\n=== KITCHEN PREPARATION ===");
        System.out.println("Head Chef reviewing Order: " + order.getOrderId());

        if (order.getItems().size() > 5 || order.getTotalAmount() > 100) {
            order.setPriority(true);
            System.out.println("Order Type: PRIORITY");
        } else {
            order.setPriority(false);
            System.out.println("Order Type: NORMAL");
        }

        Chef assignedChef = findAvailableChef();
        if (assignedChef != null) {
            order.setAssignedChef(assignedChef.getName());
            assignedChef.setAvailable(false);
            System.out.println("Assigned Chef: " + assignedChef.getName());
        }

        // Estimate time
        int estimatedTime = order.getItems().size() * 5 + (order.isPriority() ? 10 : 20);
        order.setEstimatedTime(estimatedTime);
        System.out.println("Estimated Time: " + estimatedTime + " minutes");

        order.setStatus("PREPARING");

        XMLHandler.saveOrderToXML(order, "order_" + order.getOrderId() + ".xml");
    }

    private Chef findAvailableChef() {
        for (Chef chef : chefs) {
            if (chef.isAvailable()) {
                return chef;
            }
        }
        return chefs.getFirst();
    }

    public void markOrderReady(Order order) {
        order.setStatus("READY");
        System.out.println("\nOrder " + order.getOrderId() + " is ready for delivery!");
    }
}
