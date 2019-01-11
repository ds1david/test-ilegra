package com.ilegratest.features.sales;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SalesService {

    private SalesData salesData;

    public SalesService() {
        this.salesData = SalesData.getInstance();
    }

    public SalesService(SalesData salesData){
        this.salesData = salesData;
    }

    public String getWorstSeller() {
        var sales = new ArrayList<>(salesData.getSaleModel());
        var sellers = sales.stream().map(SaleModel::getSellerName).distinct().collect(Collectors.toList());
        var sellersValues = sellers.stream().map(getSalesOfSeller(sales)).collect(Collectors.toList());
        return sellersValues.stream().filter(s -> s.getValue().equals(sellersValues.stream()
                .map(SellerValue::getValue).min(Double::compare).get())).collect(Collectors.toList())
                .stream().map(SellerValue::getSalesman).collect(Collectors.toList()).toString();
    }

    private Function<String, SellerValue> getSalesOfSeller(ArrayList<SaleModel> sales) {
        return sl -> {
            List<SaleModel> saleModelStream = sales.stream().filter(getSellerFromSellers(sl)).collect(Collectors.toList());
            return SellerValue.builder()
                    .salesman(sl)
                    .value(saleModelStream.stream().mapToDouble(SaleModel::getSaleAmount).sum())
                    .build();
        };
    }

    private Predicate<SaleModel> getSellerFromSellers(String sl) {
        return t -> t.getSellerName().equals(sl);
    }

    public String getBestSelling() {
        return salesData.getSaleModel()
                .stream().max(Comparator.comparing(SaleModel::getSaleAmount))
                .map(SaleModel::getSaleId)
                .orElse("No sale found");
    }
}
