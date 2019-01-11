package com.ilegratest.features.customer;

import com.ilegratest.dataanalytic.DataAnalytic;
import com.ilegratest.listener.FileListener;
import com.ilegratest.parser.DefaultParser;

import java.util.List;

public class CustomerFileListener extends FileListener {
    private static final String CUSTOMER_LINE_ID = "001";
    private DataAnalytic dataAnalytic = new DataAnalytic();

    private CustomerData customerData;

    public CustomerFileListener() {
        this.customerData = CustomerData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.customerData.add(DefaultParser.parseWithDefaultSplitter(lines, CUSTOMER_LINE_ID));
        dataAnalytic.analyseResult();
    }
}
