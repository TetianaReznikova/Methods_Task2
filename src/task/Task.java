package task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class Task {
    static double amountOfPurchase;
    static double discountAmount;
    static double totalAmount;


    public static void main(String[] args) {
        amountOfPurchase = getSum();
        discountAmount = discount(amountOfPurchase);
        totalAmount = sumForPay(amountOfPurchase, discountAmount);
        dataOnScreen(amountOfPurchase, discountAmount, totalAmount);
    }

    //введення суми купівль
    private static double getSum() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        System.out.println("Enter sum: ");
        double amount = sc.nextDouble();
        sc.close();
        return amount;
    }

    //розрахунок суми дисконту
    private static double discount(double sum) {
        if (sum <= 5000) {
            return sum * 0.05;
        } else if (sum <= 10000) {
            return sum * 0.1;
        } else {
            return sum * 0.15;
        }
    }

    //розрахунок суми за мінусом дисконту
    private static double sumForPay(double calculatedValue, double discValue) {
        return roundSum(calculatedValue - discValue);
    }

    //округлення до 2х знаків
    public static double roundSum(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    //виведення результату на екран
    public static void dataOnScreen(double sum, double discountSum, double total) {
        System.out.println("Total cost: " + sum);
        System.out.println("Your discount is: " + discountSum);
        System.out.println("You have to pay: " + total);
    }
}


