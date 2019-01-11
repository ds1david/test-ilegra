package com.ilegratest.features.salesman;

import com.ilegratest.dataanalytic.DataAnalytic;
import com.ilegratest.listener.FileListener;
import com.ilegratest.parser.DefaultParser;

import java.util.List;

public class SalesmanFileListener extends FileListener {

    private SalesmanData salesmanData = SalesmanData.getInstance();
    private DataAnalytic dataAnalytic = new DataAnalytic();
    private static final String SALESMAN_LINE_ID = "002";

    @Override
    public void proccess(List<String> lines) {
        salesmanData.add(DefaultParser.parseWithDefaultSplitter(lines, SALESMAN_LINE_ID));
        this.dataAnalytic.analyseResult();
    }
}
