package com.hexaware.cm.task6.abstractclass;

import com.hexaware.cm.task5.oops.*;
import java.util.ArrayList;
import java.util.List;

public class CourierUserService implements ICourierUserService {

    // List to hold all courier orders
    private List<Courier> courierOrders = new ArrayList<>();

    @Override
    public String placeOrder(Courier courierObj) {
        // Add the courier order to the list and return the tracking number
        courierOrders.add(courierObj);
        return courierObj.getTrackingNumber();
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) {
        // For simplicity, assume every courier order is assigned to a courier staff member
        // In a real-world application, you would match the staff ID with assigned orders
        return courierOrders;
    }

    @Override
    public String getOrderStatus(String trackingNumber) {
        // Search for the order with the given tracking number and return its status
        for (Courier courier : courierOrders) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier.getStatus();
            }
        }
        return "Order not found";
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        // Find the order by tracking number and cancel it
        for (Courier courier : courierOrders) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                courierOrders.remove(courier);
                return true;  // Successfully canceled
            }
        }
        return false;  // Order not found
    }
}
