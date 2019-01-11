package com.ilegratest.features.sales;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class SalesServiceTest {

    private SalesService salesService;
    @Mock private SalesData salesData;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(SalesServiceTest.class);
        salesService = new SalesService(salesData);
    }

    @Test
    public void shouldReturnWithSuccess(){
        Mockito.when(salesData.getSaleModel()).thenReturn(getMockedSales());
        String sale = salesService.getBestSelling();
        Assert.assertEquals(sale, "2");
    }

    @Test
    public void shouldReturnATextWhenNoSaleFound(){
        Mockito.when(salesData.getSaleModel()).thenReturn(new HashSet<>());
        String sale = salesService.getBestSelling();
        Assert.assertEquals(sale, "No sale found");
    }

    private Set<SaleModel> getMockedSales(){
        Set<SaleModel> sales = new HashSet<>();
        sales.add(new SaleModel("001", "1", "David Oliveira", Arrays.asList(),10D));
        sales.add(new SaleModel("001", "2", "David Oliveira", Arrays.asList(),20D));
        return sales;
    }
}
