package com.example;

import java.util.*;

public class SieveOfEratosthenes {


    private static void listPrimes(int upperLimit) {
        if (upperLimit < 2) {
            System.out.println("There are no prime numbers less than or equal to " + upperLimit);
            return;
        }
        boolean[] prime = new boolean[upperLimit + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= upperLimit; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
    }


    /**
     * <img src="./doc-img/img.png" />
     */
    public static void main(String[] args) {
        listPrimes(100);

    }
}