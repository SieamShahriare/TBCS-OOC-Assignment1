package org.tbcs;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

class XMLHandler {

    public static void saveOrderToXML(Order order, String filename) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElement("Order");
            doc.appendChild(root);

            Element orderId = doc.createElement("OrderId");
            orderId.appendChild(doc.createTextNode(order.getOrderId()));
            root.appendChild(orderId);

            Element customerId = doc.createElement("CustomerId");
            customerId.appendChild(doc.createTextNode(order.getCustomerId()));
            root.appendChild(customerId);

            Element items = doc.createElement("Items");
            for (String item : order.getItems()) {
                Element itemNode = doc.createElement("Item");
                itemNode.appendChild(doc.createTextNode(item));
                items.appendChild(itemNode);
            }
            root.appendChild(items);

            Element total = doc.createElement("TotalAmount");
            total.appendChild(doc.createTextNode(String.valueOf(order.getTotalAmount())));
            root.appendChild(total);

            Element queue = doc.createElement("QueueNumber");
            queue.appendChild(doc.createTextNode(String.valueOf(order.getQueueNumber())));
            root.appendChild(queue);

            Element status = doc.createElement("Status");
            status.appendChild(doc.createTextNode(order.getStatus()));
            root.appendChild(status);

            Element priority = doc.createElement("Priority");
            priority.appendChild(doc.createTextNode(String.valueOf(order.isPriority())));
            root.appendChild(priority);

            if (order.getAssignedChef() != null) {
                Element chef = doc.createElement("AssignedChef");
                chef.appendChild(doc.createTextNode(order.getAssignedChef()));
                root.appendChild(chef);

                Element time = doc.createElement("EstimatedTime");
                time.appendChild(doc.createTextNode(String.valueOf(order.getEstimatedTime())));
                root.appendChild(time);
            }

            if (order.getDeliveryStaff() != null) {
                Element delivery = doc.createElement("DeliveryStaff");
                delivery.appendChild(doc.createTextNode(order.getDeliveryStaff()));
                root.appendChild(delivery);
            }

            if (order.getRating() > 0) {
                Element rating = doc.createElement("Rating");
                rating.appendChild(doc.createTextNode(String.valueOf(order.getRating())));
                root.appendChild(rating);

                if (order.getFeedback() != null) {
                    Element feedback = doc.createElement("Feedback");
                    feedback.appendChild(doc.createTextNode(order.getFeedback()));
                    root.appendChild(feedback);
                }
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);

            System.out.println("XML file saved: " + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDriverCheckoutToXML(String orderId, String driverLicense, String filename) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElement("DriverCheckout");
            doc.appendChild(root);

            Element order = doc.createElement("OrderId");
            order.appendChild(doc.createTextNode(orderId));
            root.appendChild(order);

            Element license = doc.createElement("DriverLicense");
            license.appendChild(doc.createTextNode(driverLicense));
            root.appendChild(license);

            Element timestamp = doc.createElement("Timestamp");
            timestamp.appendChild(doc.createTextNode(new java.util.Date().toString()));
            root.appendChild(timestamp);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);

            System.out.println("Driver checkout saved: " + filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}