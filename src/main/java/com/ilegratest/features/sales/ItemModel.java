package com.ilegratest.features.sales;

public class ItemModel {
    private String itemId;
    private String quantity;
    private String price;
    private Double saleAmount;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    @java.beans.ConstructorProperties({"itemId", "quantity", "price", "saleAmount"})
    ItemModel(String itemId, String quantity, String price, Double saleAmount) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.saleAmount = saleAmount;
    }

    public static ItemModelBuilder builder() {
        return new ItemModelBuilder();
    }

    public static class ItemModelBuilder {
        private String itemId;
        private String quantity;
        private String price;
        private Double saleAmount;

        ItemModelBuilder() {
        }

        public ItemModelBuilder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public ItemModelBuilder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public ItemModelBuilder price(String price) {
            this.price = price;
            return this;
        }

        public ItemModelBuilder saleAmount(Double saleAmount) {
            this.saleAmount = saleAmount;
            return this;
        }

        public ItemModel build() {
            return new ItemModel(itemId, quantity, price, saleAmount);
        }

        public String toString() {
            return "ItemModel.ItemModelBuilder(itemId=" + this.itemId + ", quantity=" + this.quantity + ", price=" + this.price + ", saleAmount=" + this.saleAmount + ")";
        }
    }
}
