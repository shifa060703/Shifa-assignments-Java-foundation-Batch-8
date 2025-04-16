package com.hexware.cm.task8.collections;

import com.hexaware.cm.task5.oops.Courier;
import com.hexaware.cm.task6.abstractclass.ICourierUserService;
import com.hexware.cm.task8.collections.CourierCompanyCollection;
import java.util.List;
import java.util.ArrayList;

public class CourierUserServiceCollectionImpl implements ICourierUserService {

    private CourierCompanyCollection companyObj;

    public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
        this.companyObj = companyObj;
    }

    @Override
    public String placeOrder(Courier courier) {
        companyObj.getCourierList().add(courier);
        return "Order placed successfully! Tracking number: " + courier.getTrackingNumber();
    }

    @Override
    public List<Courier> getAssignedOrder(int courierStaffId) { // Updated method name
        List<Courier> assignedOrders = new ArrayList<>();
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getUserId() == courierStaffId) {
                assignedOrders.add(courier);
            }
        }
        return assignedOrders;
    }

    @Override
    public String getOrderStatus(String trackingNumber) {
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return "Status: " + courier.getStatus();
            }
        }
        return "Order not found!";
    }

    @Override
    public boolean cancelOrder(String trackingNumber) {
        for (Courier courier : companyObj.getCourierList()) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                companyObj.getCourierList().remove(courier);
                return true;
            }
        }
        return false;
    }
}
