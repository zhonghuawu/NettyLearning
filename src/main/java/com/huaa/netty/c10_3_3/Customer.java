package com.huaa.netty.c10_3_3;

import java.util.List;

public class Customer {
    private long customerNumber;

    private String firstName;
    private String lastName;

    private List<String> middlerNames;

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getMiddlerNames() {
        return middlerNames;
    }

    public void setMiddlerNames(List<String> middlerNames) {
        this.middlerNames = middlerNames;
    }
}