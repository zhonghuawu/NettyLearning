package com.huaa.netty.c10_3_3;

public class OrderFactory {
    public static Order create(long orderNumber) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        Customer customer = new Customer();
        customer.setCustomerNumber(orderNumber+1);
        customer.setFirstName("Wu");
        customer.setLastName("zhonghua");
        order.setCustomer(customer);
        Address billTo = new Address();
        billTo.setCity("Shanghai");
        billTo.setCountry("China");
        billTo.setPostCode("23000");
        billTo.setState("Shanghai");
        billTo.setStreet1("yangsi");
        billTo.setStreet2("shengjianghaocheng");
        order.setBillTo(billTo);
        Address shipTo = new Address();
        shipTo.setCountry("China");
        shipTo.setCity("Shanghai");
        shipTo.setPostCode("230001");
        shipTo.setState("pudongxinqu");
        shipTo.setStreet1("hongqiaoroud");
        shipTo.setStreet2("yangzailu");
        order.setShipTo(shipTo);
        Float total = 5000f;
        order.setTotal(total);

        return order;
    }
}
