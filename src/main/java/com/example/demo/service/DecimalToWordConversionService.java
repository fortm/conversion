package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DecimalToWordConversionService {
    static HashMap<Integer, String> wordMap = new HashMap<>();

    static {
        wordMap.put(0, "Zero");
        wordMap.put(1, "One");
        wordMap.put(2, "Two");
        wordMap.put(3, "Three");
        wordMap.put(4, "Four");
        wordMap.put(5, "Five");
        wordMap.put(6, "Six");
        wordMap.put(7, "Seven");
        wordMap.put(8, "Eight");
        wordMap.put(9, "Nine");
        wordMap.put(10, "Ten");
        wordMap.put(11, "Eleven");
        wordMap.put(12, "Twelve");
        wordMap.put(13, "Thirteen");
        wordMap.put(14, "Fourteen");
        wordMap.put(15, "Fifteen");
        wordMap.put(16, "Sixteen");
        wordMap.put(17, "Seventeen");
        wordMap.put(18, "Eighteen");
        wordMap.put(19, "Nineteen");
        wordMap.put(20, "Twenty");
        wordMap.put(30, "Thirty");
        wordMap.put(40, "Forty");
        wordMap.put(50, "Fifty");
        wordMap.put(60, "Sixty");
        wordMap.put(70, "Seventy");
        wordMap.put(80, "Eighty");
        wordMap.put(90, "Ninety");
    }


    private String convertUnitToWords(int num) {
        int hundred = num / 100;
        int ten = (num % 100) / 10;
        int unit = num % 10;
        String word = "";

        if (hundred != 0) {
            word += wordMap.get(hundred) + " " + "Hundred" + " and ";
        }
        if (ten != 0) {
            int tensWithUnit = ten * 10 + unit;
            word += wordMap.get(tensWithUnit) != null ? wordMap.get(tensWithUnit) : wordMap.get(ten * 10) + " " + wordMap.get(unit);
        } else {
            word += wordMap.get(unit);
        }

        return word;
    }

    public String decimalToWords(long num) {
        int hundreds = (int) (num % 1000);
        int thousands = (int) ((num / Math.pow(10, 3)) % 1000);
        int millions = (int) ((num / Math.pow(10, 6)) % 1000);
        int billions = (int) ((num / Math.pow(10, 9)) % 1000);
        int trillions = (int) ((num / Math.pow(10, 12)) % 1000);

        String words = "";
        if (num == 0) {
            return wordMap.get(0);
        }
        if (trillions != 0) {
            words += convertUnitToWords(trillions) + " " + "Trillion" + " and ";
        }
        if (billions != 0) {
            words += convertUnitToWords(billions) + " " + "Billion" + " and ";
        }
        if (millions != 0) {
            words += convertUnitToWords(millions) + " " + "Million" + " and ";
        }
        if (thousands != 0) {
            words += convertUnitToWords(thousands) + " " + "Thousand" + " and ";
        }
        if (hundreds != 0) {
            words += convertUnitToWords(hundreds);
        }

        return words;
    }

}

