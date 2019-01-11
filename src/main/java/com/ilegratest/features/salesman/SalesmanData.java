package com.ilegratest.features.salesman;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesmanData {

    private Set<String> salesmanCpf;
    private static SalesmanData salesmanData = new SalesmanData();

    private SalesmanData() {
        salesmanCpf = new HashSet<>();
    }

    public void add(List<String> customerCnpj) {
        this.salesmanCpf.addAll(customerCnpj);
    }

    public Set<String> getSalesmanCpf() {
        return this.salesmanCpf;
    }

    public static SalesmanData getInstance() {
        return salesmanData;
    }
}
