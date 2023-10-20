package com.Helper;

import java.text.DecimalFormat;

public class HelperClass {

    public static double ConvertCurrencyPriceToInt(String price){
        // Remove the "$" sign and any leading/trailing whitespace
        price = price.replaceAll("[^\\d.]", "").trim();

        try {
            // Parse the string as a double
            double priceDouble = Double.parseDouble(price);

            return roundUp(priceDouble);

        } catch (NumberFormatException e) {
            return 0; // Default value or error handling logic
        }
    }

    public static double roundUp(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(number));
    }
}
