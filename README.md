# TasteBuds Catering System (TBCS)

A restaurant order management system for TasteBuds restaurant in Dhaka, Bangladesh.

## Overview

TBCS is a Java-based system that tracks customers, manages orders, coordinates kitchen operations, handles deliveries, and collects customer feedback. The system provides discount benefits for registered customers and prioritizes orders based on size and value.

## Features

### Customer Management
- **Registered Customers**: Automatic discounts based on monthly order count
    - 5% discount for 1-4 orders
    - 10% discount for 5-9 orders
    - 15% discount for 10+ orders
- **Guest Customers**: No registration required

### Order Processing
- Queue number assignment
- Order tracking
- Automatic discount calculation
- XML-based order persistence

### Kitchen Operations
- Priority order classification (>5 items or >$100)
- Automatic chef assignment
- Preparation time estimation
- Order status tracking

### Delivery Management
- Driver assignment based on order priority
- Priority orders: Assigned within 10 minutes
- Normal orders: Assigned based on availability
- Driver license verification
- Mobile checkout system

### Customer Feedback
- Order delivery confirmation
- 5-star rating system
- Customer comments and suggestions

## System Architecture

```
┌─────────────┐
│  Customer   │
└──────┬──────┘
       │
       ▼
┌─────────────┐     ┌──────────────┐
│OrderService │────▶│ XMLHandler   │
└──────┬──────┘     └──────────────┘
       │
       ▼
┌─────────────┐
│ HeadChef    │
│  Service    │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Delivery    │
│  Service    │
└──────┬──────┘
       │
       ▼
┌─────────────┐
│ Feedback    │
│  Service    │
└─────────────┘
```

## Project Structure

```
tbcs/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── tbcs/
│   │               ├── Main.java
│   │               ├── Customer.java
│   │               ├── Order.java
│   │               ├── Driver.java
│   │               ├── Chef.java
│   │               ├── XMLHandler.java
│   │               ├── OrderService.java
│   │               ├── HeadChefService.java
│   │               ├── DeliveryService.java
│   │               └── FeedbackService.java
│   └── test/
│       └── java/
│           └── org/
│               └── tbcs/
│                   └── TBCSTestSuite.java
└── README.md
```

## Running the application

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/tbcs.git
   cd tbcs
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/main/java/org/tbcs/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin org.tbcs.Main
   ```

### Using Maven

```bash
# Compile
mvn clean compile

# Run
mvn exec:java -Dexec.mainClass="org.tbcs.Main"
```


## XML Output

The system generates XML files for each order and driver checkout:

**Order XML Example:**
```xml
<Order>
  <OrderId>ORD1234567890</OrderId>
  <CustomerId>C001</CustomerId>
  <Items>
    <Item>Biryani</Item>
    <Item>Drinks</Item>
  </Items>
  <TotalAmount>950.0</TotalAmount>
  <QueueNumber>1001</QueueNumber>
  <Status>DELIVERED</Status>
  <Priority>true</Priority>
  <AssignedChef>Chef John</AssignedChef>
  <Rating>5</Rating>
</Order>
```
---

**Author:** Sieam Shahriare
**Student ID:** 230042153
**Last Updated:** January 2026

___