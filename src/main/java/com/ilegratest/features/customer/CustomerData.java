package com.ilegratest.features.customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerData {

    private Set<String> customerCnpj;
    private static CustomerData customerData = new CustomerData();

    private CustomerData() {
        customerCnpj = new HashSet<>();
    }

    public void add(List<String> customerCnpj) {
        this.customerCnpj.addAll(customerCnpj);
    }

    public Set<String> getCustomerCnpj() {
        return this.customerCnpj;
    }

    public static CustomerData getInstance() {
        return customerData;
    }
}
