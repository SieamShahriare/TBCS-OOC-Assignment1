package org.tbcs;

class FeedbackService {

    public void markDelivered(Order order) {
        order.setStatus("DELIVERED");
        System.out.println("\n=== ORDER DELIVERED ===");
        System.out.println("Order " + order.getOrderId() + " has been delivered");
    }

    public void submitFeedback(Order order, int rating, String comments) {
        System.out.println("\n=== CUSTOMER FEEDBACK ===");
        System.out.println("Order ID: " + order.getOrderId());

        order.setRating(rating);
        order.setFeedback(comments);

        System.out.println("Rating: " + rating + "/5 stars");
        if (comments != null && !comments.isEmpty()) {
            System.out.println("Comments: " + comments);
        }

        if (rating < 3) {
            System.out.println("We're sorry you weren't satisfied. We'll work to improve!");
        } else {
            System.out.println("Thank you for your feedback!");
        }

        XMLHandler.saveOrderToXML(order, "order_" + order.getOrderId() + ".xml");
    }
}
