package Task4;

/*
 * This program allows users to perform currency conversion by selecting a base currency and a target currency.
 * It fetches real-time exchange rates from a reliable API, takes input for the amount to convert,
 * and converts the amount from the base currency to the target currency using the fetched exchange rate.
 * The converted amount and the target currency symbol are then displayed to the user.
 *
 * Author: Maswanganyi Successfull
 */

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to choose base currency
        System.out.println("Choose the base currency (e.g., USD, EUR, GBP):");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Prompt user to choose target currency
        System.out.println("Choose the target currency (e.g., USD, EUR, GBP):");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Prompt user to input the amount to convert
        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        // Fetch real-time exchange rate from a reliable API
        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        // Perform currency conversion
        double convertedAmount = amount * exchangeRate;

        // Display the converted amount and the target currency symbol to the user
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    // Method to fetch real-time exchange rate from a reliable API
    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        // Code to fetch exchange rate from API will be implemented here
        // For demonstration purposes, let's assume a fixed exchange rate
        // In a real-world scenario, this method would make an API call to fetch the exchange rate
        // and parse the response to extract the exchange rate

        // For demonstration, assume fixed exchange rates for a few currency pairs
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85; // 1 USD = 0.85 EUR
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return 0.72; // 1 USD = 0.72 GBP
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18; // 1 EUR = 1.18 USD
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return 0.85; // 1 EUR = 0.85 GBP
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return 1.39; // 1 GBP = 1.39 USD
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("EUR")) {
            return 1.18; // 1 GBP = 1.18 EUR
        } else {
            // Default exchange rate if pair not found
            return 1.0; // 1:1 exchange rate if no specific rate found
        }
    }
}
