package com.ilegratest.features.sales;

import java.util.List;

public class SaleModel {
    private String id;
    private String saleId;
    private String sellerName;
    private List<ItemModel> itens;
    private Double saleAmount;

    @java.beans.ConstructorProperties({"id", "saleId", "sellerName", "itens", "saleAmount"})
    SaleModel(String id, String saleId, String sellerName, List<ItemModel> itens, Double saleAmount) {
        this.id = id;
        this.saleId = saleId;
        this.sellerName = sellerName;
        this.itens = itens;
        this.saleAmount = saleAmount;
    }

    public SaleModel() {
    }

    public static SaleModelBuilder builder() {
        return new SaleModelBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getSaleId() {
        return this.saleId;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public List<ItemModel> getItens() {
        return this.itens;
    }

    public Double getSaleAmount() {
        return this.saleAmount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setItens(List<ItemModel> itens) {
        this.itens = itens;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public static class SaleModelBuilder {
        private String id;
        private String saleId;
        private String sellerName;
        private List<ItemModel> itens;
        private Double saleAmount;

        SaleModelBuilder() {
        }

        public SaleModelBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SaleModelBuilder numberSale(String numberSale) {
            this.saleId = numberSale;
            return this;
        }

        public SaleModelBuilder sellerName(String sallerName) {
            this.sellerName = sallerName;
            return this;
        }

        public SaleModelBuilder itens(List<ItemModel> itens) {
            this.itens = itens;
            return this;
        }

        public SaleModelBuilder saleAmount(Double saleAmount) {
            this.saleAmount = saleAmount;
            return this;
        }

        public SaleModel build() {
            return new SaleModel(id, saleId, sellerName, itens, saleAmount);
        }

        public String toString() {
            return "SaleModel.SaleModelBuilder(id=" + this.id + ", saleId=" + this.saleId + ", sellerName=" + this.sellerName + ", itens=" + this.itens + ", saleAmount=" + this.saleAmount + ")";
        }
    }
}
