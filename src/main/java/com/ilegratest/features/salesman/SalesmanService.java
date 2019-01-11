package com.ilegratest.features.salesman;

public class SalesmanService {
    private SalesmanData salesmanData = SalesmanData.getInstance();

    public Long getAmountSalesman() {
        return salesmanData.getSalesmanCpf().stream().distinct().count();
    }
}
