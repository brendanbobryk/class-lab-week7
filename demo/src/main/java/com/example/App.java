package com.example;

import java.util.HashSet;
import java.util.Set;

public class App {
    // create two arrays
    static final Integer minValue = 1;
    static final Integer maxValue = 100;
    static final Integer minSize = 3;
    static final Integer maxSize = 15;
    private static Integer[] input;

    // create names
    public static void assignValues() {
        // populate array
        Set<Integer> hs = new HashSet<Integer>();
        Integer i = 0;
        while (i < input.length) {
            Integer val = randomRange(minValue, maxValue);
            // if val not in set
            if (!hs.contains(val)) {
                hs.add(val);
                input[i] = val;
                i += 1;
            }
        }
    }

    // prInteger array
    public static void print(Integer[] arr) {
        for (Integer i = 0; i < arr.length; i += 1) {
            System.out.printf("[%d] %s\n", i + 1, arr[i]);
        }
    }

    public static Integer randomRange(Integer minSize, Integer maxSize) {
        return minSize + (int) (Math.random() * ((maxSize - minSize) + 1));
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.printf("radar distance = %d to %d miles\n", minValue, maxValue);
        // create the input and output array
        final int arrSize = randomRange(minSize, maxSize);
        input = new Integer[arrSize];
        Integer[] output = new Integer[arrSize];
        // create random array of unique numbers from min to max
        assignValues();
        System.out.println();
        System.out.printf("-------- incoming missile distances (input) --------\n");
        print(input);
        /*
         * STUDENTS NEED TO ADD CODE HERE
         */
        // print sorted array
        System.out.println();
        System.out.printf("-------- target missile distances (output) --------\n");
        print(output);
    }
}
