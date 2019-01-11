package com.ilegratest.features.sales;

import com.ilegratest.dataanalytic.DataAnalytic;
import com.ilegratest.features.customer.SaleTextParser;
import com.ilegratest.listener.FileListener;

import java.util.List;

public class SaleFileListener extends FileListener {
    private SalesData salesData;
    private DataAnalytic dataAnalytic = new DataAnalytic();

    public SaleFileListener() {
        this.salesData = SalesData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.salesData.add(SaleTextParser.parseSale(lines));
        this.dataAnalytic.analyseResult();
    }
}
