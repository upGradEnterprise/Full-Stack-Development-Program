package com.zeta.testing.bean;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
//        if(numbers.isEmpty())
//            return 0;
//        else if(numbers.contains(",")) {
//            String[] strNumbers = numbers.split(",");
//            int sum = 0;
//            for(String strNumber : strNumbers) {
//                sum += Integer.parseInt(strNumber);
//            }
//            return sum;
//        } else
//            return Integer.parseInt(numbers);
        if(numbers.isEmpty())
            return 0;
        String[] numbersArray = numbers.split(",");
        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }
}