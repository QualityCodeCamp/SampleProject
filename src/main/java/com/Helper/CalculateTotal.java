package com.Helper;

import java.util.List;

public class CalculateTotal {

    private List<Product> productList;

    public CalculateTotal(List<Product> productList) {
        this.productList = productList;
    }

    public void AddProduct(Product product){
        productList.add(product);
    }

    public double CalculateProductTotal(){
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public double CalculateTotalTaxIncl(){
        var total = CalculateProductTotal();
        var tax = HelperClass.roundUp(total * 0.08);
        return total + tax;
    }

}
