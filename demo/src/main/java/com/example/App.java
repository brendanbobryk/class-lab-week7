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
        // sort array
        Integer arr[] = input;
        int n = arr.length;

        // Find the maximum element in the array to determine the range of the count
        // array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a count array with the size equal to the maximum element plus one
        int count[] = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }

        // Change count[i] so that count[i] now contains the actual position
        // of this element in the output array
        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now contains sorted elements
        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }

        // print sorted array
        System.out.println();
        System.out.printf("-------- target missile distances (output) --------\n");
        print(output);
    }
}
