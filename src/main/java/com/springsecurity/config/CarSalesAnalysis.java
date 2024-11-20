package com.springsecurity.config;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Car {
    private String type;
    private int year;
    private double sales;

    public Car(String type, int year, double sales) {
        this.type = type;
        this.year = year;
        this.sales = sales;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public double getSales() {
        return sales;
    }
}

public class CarSalesAnalysis {
    public static void main(String[] args) {
        // Sample data of car sales
        List<Car> cars = Arrays.asList(
                new Car("SUV", 2021, 50000),
                new Car("Sedan", 2021, 30000),
                new Car("SUV", 2022, 60000),
                new Car("Truck", 2021, 40000),
                new Car("Sedan", 2022, 35000),
                new Car("Truck", 2022, 45000),
                new Car("SUV", 2023, 70000),
                new Car("Sedan", 2023, 32000)
        );

        // Count of car sales by type
        Map<String, Long> salesCountByType = cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));

        System.out.println("Car Sales Count by Type:");
        salesCountByType.forEach((type, count) ->
                System.out.println(type + ": " + count));

        // Sum of car sales grouped by year
        Map<Integer, Double> totalSalesByYear = cars.stream()
                .collect(Collectors.groupingBy(Car::getYear, Collectors.summingDouble(Car::getSales)));

        System.out.println("\nTotal Car Sales by Year:");
        totalSalesByYear.forEach((year, totalSales) ->
                System.out.println("Year " + year + ": $" + totalSales));


        String input = "hello world";

        // Count occurrences of each character
        Map<Character, Long> characterCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("\n Character Count: " + characterCount);

        // Remove duplicate characters
        String uniqueChars = input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println("String without duplicates: " + uniqueChars); // Output: helo wrd

        // List of digits [1, 2, 3, 4]
        List<Integer> digits = Arrays.asList(1, 2, 3, 4);

        // Count the possible 3-digit combinations using nested loops
        long count = digits.stream()
                .flatMap(d1 -> digits.stream()
                        .flatMap(d2 -> digits.stream()
                                .map(d3 -> "" + d1 + d2 + d3))) // Create combinations of 3 digits
                .count(); // Count the combinations

        System.out.println(" \n \n Total 3-digit combinations: " + count);

    }
}

