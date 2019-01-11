package com.ilegratest.features.sales;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesData {

    private Set<SaleModel> saleModel;
    private static SalesData salesData = new SalesData();

    public SalesData() {
        saleModel = new HashSet<>();
    }

    public void add(List<SaleModel> saleModel) {
        this.saleModel.addAll(saleModel);
    }

    public Set<SaleModel> getSaleModel() {
        return this.saleModel;
    }

    public static SalesData getInstance() {
        return salesData;
    }
}
