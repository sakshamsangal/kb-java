package com.example.dsa;

public class BinaryExponentiation{
static int binaryExponentiation(int base, int power) {
    int result = 1;
    while (power != 0) {
        if ((power & 1) == 1) {
            power--;
            result *= base;
        }
        // we have even power now
        power = power >> 1; // divide by 2
        base *= base;
    }
    return result;
}
}