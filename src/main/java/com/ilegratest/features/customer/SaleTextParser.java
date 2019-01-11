package com.ilegratest.features.customer;

import com.ilegratest.features.sales.ItemModel;
import com.ilegratest.features.sales.SaleModel;
import com.ilegratest.parser.DefaultParser;

import java.util.List;
import java.util.stream.Collectors;

public class SaleTextParser {
    private static final String SALE_LINE_ID = "003";

    public static List<SaleModel> parseSale(List<String> fileText) {
        return DefaultParser.parse(fileText)
                .stream().filter(i -> i.get(0).equals(SALE_LINE_ID))
                .map(i -> sale(i, parseItem(i.get(2))))
                .collect(Collectors.toList());
    }

    private static List<ItemModel> parseItem(String item) {
        List<String> itens = ItemTextParser.parse(item);
        List<List<String>> test = itens.stream().map(ItemTextParser::parseItens).collect(Collectors.toList());
        return test.stream().map(i -> ItemTextParser.itemParse(i)).collect(Collectors.toList());
    }

    private static SaleModel sale(List<String> sale, List<ItemModel> itens) {
        return SaleModel.builder()
                .id(sale.get(0))
                .numberSale(sale.get(1))
                .itens(itens)
                .saleAmount(sumValueSale(itens))
                .sellerName(sale.get(3))
                .build();
    }

    private static Double sumValueSale(List<ItemModel> itensVenda) {
        return itensVenda.stream().mapToDouble(i -> i.getSaleAmount()).sum();
    }
}
