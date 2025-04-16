package com.hexaware.cm.task6.abstractclass;

import java.util.List;
import com.hexaware.cm.task5.oops.*;
public interface ICourierUserService {
    
    // Place a new courier order
    String placeOrder(Courier courierObj);
    
    // Get a list of orders assigned to a specific courier staff member
    List<Courier> getAssignedOrder(int courierStaffId);
    
    // Get the status of a courier order
    String getOrderStatus(String trackingNumber);
    
    // Cancel a courier order
    boolean cancelOrder(String trackingNumber);
}

