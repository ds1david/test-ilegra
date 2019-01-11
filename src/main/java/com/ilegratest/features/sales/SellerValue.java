package com.ilegratest.features.sales;

public class SellerValue {
    private String salesman;
    private Double value;

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @java.beans.ConstructorProperties({"salesman", "value"})
    SellerValue(String salesman, Double value) {
        this.salesman = salesman;
        this.value = value;
    }

    public static SellerValueBuilder builder() {
        return new SellerValueBuilder();
    }

    public static class SellerValueBuilder {
        private String salesman;
        private Double value;

        SellerValueBuilder() {
        }

        public SellerValueBuilder salesman(String salesman) {
            this.salesman = salesman;
            return this;
        }

        public SellerValueBuilder value(Double value) {
            this.value = value;
            return this;
        }

        public SellerValue build() {
            return new SellerValue(salesman, value);
        }

        public String toString() {
            return "SellerValue.SellerValueBuilder(salesman=" + this.salesman + ", value=" + this.value + ")";
        }
    }
}
