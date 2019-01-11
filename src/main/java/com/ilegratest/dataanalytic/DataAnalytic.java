package com.ilegratest.dataanalytic;

import com.ilegratest.features.customer.CustomerService;
import com.ilegratest.features.sales.SalesService;
import com.ilegratest.features.salesman.SalesmanService;
import com.ilegratest.file.FileUtil;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataAnalytic {
    private static final Path dirsPath = Paths.get("./data/out");
    private CustomerService customerService;
    private SalesmanService salesmanService;
    private SalesService salesService;
    private FileUtil fileUtil;

    public DataAnalytic() {
        this.customerService = new CustomerService();
        this.salesmanService = new SalesmanService();
        this.salesService = new SalesService();
        this.fileUtil = new FileUtil();
    }

    public void analyseResult() {
        FormModel formModel = FormModel.builder()
                .AmountClients(customerService.getAmountClient())
                .AmountSalesman(salesmanService.getAmountSalesman())
                .idMostExpensiveSale(salesService.getBestSelling())
                .worstSalesmanEver(salesService.getWorstSeller())
                .build();

        System.out.println(buildContent(formModel));
    }

    private String buildContent(FormModel formModel){
        return new StringBuilder().append("Amount of customers in the input file: ").append(formModel.getAmountClients()).append("\n")
                .append("Amount of salesman in the input file: ").append(formModel.getAmountSalesman()).append("\n")
                .append("ID of the moest expensive sale: ").append(formModel.getIdMostExpensiveSale()).append("\n")
                .append("Worst salesman ever: ").append(formModel.getWorstSalesmanEver()).append("\n")
                .toString();
    }
}
