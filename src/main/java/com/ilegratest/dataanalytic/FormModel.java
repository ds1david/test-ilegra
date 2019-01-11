package com.ilegratest.dataanalytic;

import java.util.List;

public class FormModel {
    private Long amountClients;
    private Long amountSalesman;
    private String idMostExpensiveSale;
    private String worstSalesmanEver;

    @java.beans.ConstructorProperties({"amountClients", "amountSalesman", "idMostExpensiveSale", "worstSalesmanEver"})
    FormModel(Long amountClients, Long amountSalesman, String idMostExpensiveSale, String worstSalesmanEver) {
        this.amountClients = amountClients;
        this.amountSalesman = amountSalesman;
        this.idMostExpensiveSale = idMostExpensiveSale;
        this.worstSalesmanEver = worstSalesmanEver;
    }



    public static FormModelBuilder builder() {
        return new FormModelBuilder();
    }

    public Long getAmountClients() {
        return amountClients;
    }

    public Long getAmountSalesman() {
        return amountSalesman;
    }

    public String getIdMostExpensiveSale() {
        return idMostExpensiveSale;
    }

    public String getWorstSalesmanEver() {
        return worstSalesmanEver;
    }

    public static class FormModelBuilder {
        private Long AmountClients;
        private Long AmountSalesman;
        private String idMostExpensiveSale;
        private String worstSalesmanEver;

        FormModelBuilder() {
        }

        public FormModelBuilder AmountClients(Long AmountClients) {
            this.AmountClients = AmountClients;
            return this;
        }

        public FormModelBuilder AmountSalesman(Long AmountSalesman) {
            this.AmountSalesman = AmountSalesman;
            return this;
        }

        public FormModelBuilder idMostExpensiveSale(String idMostExpensiveSale) {
            this.idMostExpensiveSale = idMostExpensiveSale;
            return this;
        }

        public FormModelBuilder worstSalesmanEver(String worstSalesmanEver) {
            this.worstSalesmanEver = worstSalesmanEver;
            return this;
        }

        public FormModel build() {
            return new FormModel(AmountClients, AmountSalesman, idMostExpensiveSale, worstSalesmanEver);
        }

        public String toString() {
            return "FormModel.FormModelBuilder(amountClients=" + this.AmountClients + ", amountSalesman=" + this.AmountSalesman + ", idMostExpensiveSale=" + this.idMostExpensiveSale + ", worstSalesmanEver=" + this.worstSalesmanEver + ")";
        }
    }
}
